
package j2js.w3c.dom.svg;

import j2js.w3c.dom.events.EventTarget;

public interface SVGLineElement extends 
               SVGElement,
               SVGTests,
               SVGLangSpace,
               SVGExternalResourcesRequired,
               SVGStylable,
               SVGTransformable,
               EventTarget {
  public SVGAnimatedLength getX1( );
  public SVGAnimatedLength getY1( );
  public SVGAnimatedLength getX2( );
  public SVGAnimatedLength getY2( );
}