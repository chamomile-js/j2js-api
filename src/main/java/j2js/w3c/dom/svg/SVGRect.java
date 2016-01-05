
package j2js.w3c.dom.svg;

import j2js.w3c.dom.DOMException;

public interface SVGRect {
  public float getX( );
  public void      setX( float x )
                       throws DOMException;
  public float getY( );
  public void      setY( float y )
                       throws DOMException;
  public float getWidth( );
  public void      setWidth( float width )
                       throws DOMException;
  public float getHeight( );
  public void      setHeight( float height )
                       throws DOMException;
}
