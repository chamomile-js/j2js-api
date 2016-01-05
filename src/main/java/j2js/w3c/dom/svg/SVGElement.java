
package j2js.w3c.dom.svg;

import j2js.w3c.dom.DOMException;
import j2js.w3c.dom.Element;

public interface SVGElement extends 
               Element {
  public String getId( );
  public void      setId( String id )
                       throws DOMException;
  public String getXMLbase( );
  public void      setXMLbase( String xmlbase )
                       throws DOMException;
  public SVGSVGElement getOwnerSVGElement( );
  public SVGElement getViewportElement( );
}
