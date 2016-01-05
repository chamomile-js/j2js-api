
package j2js.w3c.dom.svg;

import j2js.w3c.dom.css.CSSStyleDeclaration;
import j2js.w3c.dom.css.CSSValue;

public interface SVGStylable {
  public SVGAnimatedString getClassName( );
  public CSSStyleDeclaration getStyle( );

  public CSSValue getPresentationAttribute ( String name );
}
