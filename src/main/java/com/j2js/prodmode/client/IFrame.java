package com.j2js.prodmode.client;


import java.util.HashMap;
import java.util.Map;

import j2js.w3c.dom.Document;
import j2js.w3c.dom.events.EventListener;
import j2js.w3c.dom.events.EventTarget;
import j2js.w3c.dom.html.HTMLIFrameElement;
import j2js.w3c.dom.views.Window;

public class IFrame {
    
    private static Map<String, IFrame> iframes = new HashMap<String, IFrame>();
    
    public static IFrame getOrCreateIFrame(Window window, String name, EventListener listener) {
        if (iframes.containsKey(name)) return iframes.get(name);
        
        ((EventTarget) window).addEventListener("iframeload", listener, false);
        
        IFrame iframe = new IFrame(window, name);
        iframes.put(name, iframe);
        return iframe;
    }
    
    private HTMLIFrameElement element;
    
    private IFrame(Window window, String name) {
        Document document = window.getDocument();
        element = (HTMLIFrameElement) document.createElement("IFRAME");
        document.appendChild(element);
    }
    
    public void setSrc(String src) {
        element.setSrc(src);
    }
    
    public HTMLIFrameElement getHTMLIFrameElement() {
        return element;
    }
}
