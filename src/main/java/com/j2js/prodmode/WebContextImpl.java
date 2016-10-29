//@formatter:off
/*
 * Copyright (c) 2005 j2js.com,
 *
 * All Rights Reserved. This work is distributed under the j2js Software License [1]
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.
 *
 * [1] http://www.j2js.com/license.txt
 */
//@formatter:on

package com.j2js.prodmode;

import java.io.PrintStream;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import com.j2js.prodmode.client.ConsoleImpl;
import com.j2js.prodmode.client.ConsoleOutputStream;
import com.j2js.prodmode.client.HTMLUtilsImpl;
import com.j2js.prodmode.net.HttpRequestFactoryImpl;
import com.j2js.prodmode.net.JSON.JSONImpl;
import com.j2js.prodmode.test.TimeoutManagerImpl;

import j2js.Context;
import j2js.Global;
import j2js.w3c.dom.views.Window;
import javascript.ScriptHelper;

public final class WebContextImpl implements Context {

	// Need to maintain the order of properties.
	// TODO: Implement and use LinkedHashMap instead.
	private static ArrayList<String> propertyValues = new ArrayList<String>();

	// -------------------------------------
	// E N T R Y P O I N T (see runtime.js)
	// -------------------------------------
	static void premain(String className, String methodName) {
		WebContextImpl foo = new WebContextImpl();
		foo.init();

		// Call given main...
		ScriptEngine engine = System.scriptEngine;
		engine.put("className", className);
		engine.put("methodName", methodName);
		if (methodName.matches(".*\\(.+\\).*")) {
			// Method has parameters.
			if (!methodName.matches(".*\\(java.lang.String\\[\\]\\).*"))
				throw new RuntimeException("Method must have no argument or argument of type 'java.lang.String[]'");
			String[] argv = (String[]) propertyValues.toArray();
			engine.put("argv", argv);
			engine.eval("j2js.invokeStatic(className, methodName, [argv])");
		} else {
			engine.eval("j2js.invokeStatic(className, methodName, [])");
		}
	}

	// ---

	private WebContextImpl() {
	}

	@Override
	public void init() {
		// Global.window = WindowImpl.self;

		ScriptEngineManager manager = new ScriptEngineManager();
		System.scriptEngine = manager.getEngineByName("JavaScript");
		System.err = new PrintStream(new ConsoleOutputStream());
		System.out = new PrintStream(new ConsoleOutputStream());

		Global.window = (Window) System.scriptEngine.eval("self");
		Global.document = Global.window.getDocument();
		// System.out.println("Setting " + Global.document);

		Global.JSON = new JSONImpl();
		Global.HTMLUtils = new HTMLUtilsImpl();
		Global.httpRequestFactory = new HttpRequestFactoryImpl();
		Global.console = new ConsoleImpl();

		Global.timeoutManager = new TimeoutManagerImpl();

		initializePropertiesFromQuery();
		System.properties.put("java.version", "1.5 J2JS");
	}

	private static void initializePropertiesFromQuery() {
		// Initialize system properties through query part of URL.
		String query = (String) System.scriptEngine.eval("window.location.search");
		// Drop '?'.
		query = query.substring(1).trim();
		String[] keyValuePairs = query.split("&");
		for (int i = 0; i < keyValuePairs.length; i++) {
			String[] keyValue = keyValuePairs[i].split("=");
			if (keyValue.length != 2)
				continue;
			String value = URLDecoder.decode(keyValue[1], "UTF-8");
			System.properties.put(keyValue[0], value);
			propertyValues.add(value);
		}
	}

	@Override
	public void close() {
	}

	public static String getAssemblyVersion() {
		return (String) ScriptHelper.eval("j2js.assemblyVersion");
	}

}
