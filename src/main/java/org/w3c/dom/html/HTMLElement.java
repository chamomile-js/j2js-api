/*
 * Copyright (c) 1998 World Wide Web Consortium, (Massachusetts Institute of
 * Technology, Institut National de Recherche en Informatique et en
 * Automatique, Keio University).
 * All Rights Reserved. http://www.w3.org/Consortium/Legal/
 */

package org.w3c.dom.html;

import org.w3c.dom.*;

/**
 * All HTML element interfaces derive from this class. Elements that only 
 * exposethe HTML core attributes are represented by the base
 * <code>HTMLElement</code> interface. These elements are as follows:HEAD
 * special: SUB, SUP, SPAN, BDOfont: TT, I, B, U, S, STRIKE, BIG, SMALL
 * phrase: EM, STRONG, DFN, CODE, SAMP, KBD, VAR, CITE, ACRONYM, ABBRlist: 
 * DD, DTNOFRAMES, NOSCRIPTADDRESS, CENTER
 * Note. The <code>style</code> attribute for thisinterface is reserved for 
 * future usage. 
 */
public interface HTMLElement extends Element {
  /**
   * The element's identifier. See the id attribute definition in HTML 4.0.
   */
  public String             getId();
  public void               setId(String id);
  /**
   * The element's advisory title. See the title attribute definition in HTML 
   * 4.0.
   */
  public String             getTitle();
  public void               setTitle(String title);
  /**
   * Language code defined in RFC 1766. See the lang attribute definition in 
   * HTML 4.0.
   */
  public String             getLang();
  public void               setLang(String lang);
  /**
   * Specifies the base direction of directionally neutraltext and the 
   * directionality of tables. See the dir attribute definition in HTML 4.0.
   */
  public String             getDir();
  public void               setDir(String dir);
  /**
   * The class attribute of the element. This attribute has been renameddue to 
   * conflicts with the "class" keyword exposed by many languages. See the 
   * class attribute definition in HTML 4.0.
   */
  public String             getClassName();
  public void               setClassName(String className);
  
   // ---
   
   /**
    * Returns a fragment of HTML or XML that represents the element's contents.
    */
   public String getInnerHTML();
   
   /**
    * Replace the contents of the element with nodes parsed from the given
    * string.
    */
   public void setInnerHTML(String html);
   
   // ---
   
   /**
    * Returns a fragment of HTML or XML that represents the element's contents.
    * 
    * @see Node#getTextContent
    * 
    * @deprecated This feature is non-standard and is not on a standards track.
    *             Do not use it on production sites facing the Web: it will not
    *             work for every user. There may also be large incompatibilities
    *             between implementations and the behavior may change in the
    *             future.
    */
   public String getInnerText();
   
   /**
    * Replace the contents of the element with nodes parsed from the given
    * string.
    * 
    * @see Node#setTextContent
    * 
    * @deprecated This feature is non-standard and is not on a standards track.
    *             Do not use it on production sites facing the Web: it will not
    *             work for every user. There may also be large incompatibilities
    *             between implementations and the behavior may change in the
    *             future.
    */
   public void setInnerText(String text);
   
   // ---
   
   /**
    * Returns the first element that is a descendant of the element on which it
    * is invoked that matches the specified group of selectors.
    * 
    * @param selectors
    *           a group of selectors to match on.
    * @return {@code null} if no matches are found; otherwise, it returns the
    *         first matching element.
    *         
    * @see https://developer.mozilla.org/en-US/docs/Web/API/Element/
    *      querySelector
    */
   public HTMLElement querySelector(String selectors);
   
   /**
    * Returns a non-live {@link NodeList} of all elements descended from the
    * element on which it is invoked that match the specified group of CSS
    * selectors.
    * 
    * @param selectors
    *           a group of selectors to match on or an elements of the DOM.
    * @return a non-live NodeList of all the matching element nodes.
    */
   public NodeList querySelectorAll(String selectors);
   
   // ---
   
}

