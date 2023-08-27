/**
 *	===============================================================================
 *	TriangleArrowShape.java : A shape that is a triangle arrow (i.e. upside down triangle).
 *  YOUR UPI: ahua091
 *	=============================================================================== */
import java.awt.*;
import java.util.*;
//Complete the TriangleArrowShape

class TriangleArrowShape extends Shape {

    public TriangleArrowShape() {
        super();
    }
    
    public TriangleArrowShape(Color c, Color bc, PathType pt) {
        super(c, bc, pt);
    }
    
    public TriangleArrowShape(int x, int y, int width, int height, int panelWidth, int panelHeight, Color c, Color bc, PathType pt) {
        super(x, y, width, height, panelWidth, panelHeight, c, bc, pt);
    }
    
    // @overriden
    public void draw(Graphics g) {
        System.out.println(color);
        System.out.println(borderColor);
        System.out.println(toString());
        int[][] polyArr = new int[][] {{x, x + width, (x + x + width) / 2}, {y, y, y + height}};
        Polygon polyObject = new Polygon(polyArr[0], polyArr[1], 3);
        System.out.println(Arrays.toString(polyArr[0]) + ", " + Arrays.toString(polyArr[1]));
    }

    //@overriden 
    public boolean contains(Point mousePt) {
        int[][] polyArr = new int[][] {{x, x + width, (x + x + width) / 2}, {y, y, y + height}};
        Polygon polyObject = new Polygon(polyArr[0], polyArr[1], 3);
        if (polyObject.contains(mousePt)) {
            return true;
        }
        return false;
    }
}