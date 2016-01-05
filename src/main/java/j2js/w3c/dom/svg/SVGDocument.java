
package j2js.w3c.dom.svg;

import j2js.w3c.dom.Document;
import j2js.w3c.dom.events.DocumentEvent;

public interface SVGDocument extends 
               Document,
               DocumentEvent {
  public String    getTitle( );
  public String     getReferrer( );
  public String      getDomain( );
  public String      getURL( );
  public SVGSVGElement getRootElement( );
}
