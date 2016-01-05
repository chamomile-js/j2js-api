
package j2js.w3c.dom.svg;

import j2js.w3c.dom.events.EventTarget;

public interface SVGForeignObjectElement extends 
               SVGElement,
               SVGTests,
               SVGLangSpace,
               SVGExternalResourcesRequired,
               SVGStylable,
               SVGTransformable,
               EventTarget {
  public SVGAnimatedLength getX( );
  public SVGAnimatedLength getY( );
  public SVGAnimatedLength getWidth( );
  public SVGAnimatedLength getHeight( );
}
