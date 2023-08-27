/**
 *	===============================================================================
 *	SpottedRectangleShape.java : A shape that is a recangle with spotted circles.
 *  YOUR UPI: ahua091
 *	=============================================================================== */
import java.awt.*;
import java.util.*;
//Complete the SpottedRectangleShape
class SpottedRectangleShape extends RectangleShape {
    Random rand = new Random(30);
    private ArrayList<Point> ptList = new ArrayList<Point>();
    
    public SpottedRectangleShape() {
        super();
        for (int i = 0; i < 1; i++){
            // use height, width, x, and y of the shape being drawn
            int ptx = rand.nextInt(width - 10);
            int pty = rand.nextInt(height - 10);
            ptList.add(new Point(ptx, pty));
            }
        }
    
    
    public SpottedRectangleShape(Color c, Color bc, PathType pt) {
        super(c, bc, pt);
        for (int i = 0; i < 3; i++){
            // use height, width, x, and y of the shape being drawn
            int ptx = rand.nextInt(width - 10);
            int pty = rand.nextInt(height - 10);
            ptList.add(new Point(ptx, pty));
            }
        }

    
    public SpottedRectangleShape(int x, int y, int width, int height, int panelWidth, int panelHeight, Color c, Color bc, PathType pt) {
        super(x, y, width, height, panelWidth, panelHeight, c, bc, pt);
        for (int i = 0; i < 3; i++){
            // use height, width, x, and y of the shape being drawn
            int ptx = rand.nextInt(width - 10);
            int pty = rand.nextInt(height - 10);
            ptList.add(new Point(ptx, pty));
            }
        }
    
    
    public SpottedRectangleShape(Point... pts) { 
        for (Point pt: pts) {
            ptList.add(pt);
        }
        
    }
    // @overriden
    public void draw(Graphics g) {
        System.out.println(color);
        System.out.println(borderColor);
        System.out.println(toString());

        if (ptList.size() == 0) { 
            
            for (int i = 0; i < 3; i++){
            // use height, width, x, and y of the shape being drawn
            int ptx = rand.nextInt(width - 10);
            int pty = rand.nextInt(height - 10);
            ptList.add(new Point(ptx, pty));
            }
        
        } System.out.println(ptList.toString());    
    }
}
    

