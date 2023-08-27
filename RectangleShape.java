/**
 *	===============================================================================
 *	RectangleShape.java : A shape that is a rectangle.
 *  YOUR UPI: ahua091
 *	=============================================================================== */
import java.awt.*;

//Complete the RectangleShape

class RectangleShape extends Shape {
    
    public RectangleShape() {
        super();
    }
    
    public RectangleShape(Color c, Color bc, PathType pt) {
        super(c, bc, pt);
    }

    public RectangleShape(int x, int y, int width, int height, int panelWidth, int panelHeight, Color c, Color bc, PathType pt) {
        super(x, y, width, height, panelWidth, panelHeight, c, bc, pt);
    }

    // @overriden
    public void draw(Graphics g) {
        System.out.println(color);
        System.out.println(borderColor);
        System.out.println(toString());
    }

    //@overriden 
    public boolean contains(Point mousePt) {
        if (mousePt.x >= x && mousePt.y >= y && mousePt.x <= width && mousePt.y <= height ) {
            return true;
        }
        return false;
    }
}