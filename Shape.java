/**
 *    ===============================================================================
 *    Shape.java : The superclass of all shapes.
 *    A shape defines various properties, including selected, colour, width and height.
 *    YOUR UPI: ahua091
 *    ===============================================================================
 */
import java.awt.*;
abstract class Shape {
    public static final ShapeType DEFAULT_SHAPETYPE = ShapeType.RECTANGLE;
    public static final PathType DEFAULT_PATHTYPE = PathType.BOUNCING;
    public static final int DEFAULT_X = 0, DEFAULT_Y = 0, DEFAULT_WIDTH=50, DEFAULT_HEIGHT=50, DEFAULT_PANEL_WIDTH=400, DEFAULT_PANEL_HEIGHT=600;
    public static final Color DEFAULT_COLOR=Color.red, DEFAULT_BORDER_COLOR=Color.blue;


    public int x, y, width=DEFAULT_WIDTH, height=DEFAULT_HEIGHT, panelWidth=DEFAULT_PANEL_WIDTH, panelHeight=DEFAULT_PANEL_HEIGHT; // the bouncing area
    protected Color color = DEFAULT_COLOR;
    protected boolean selected = false;    // draw handles if selected
    protected MovingPath path = new BouncingPath(1, 2);

	public Shape() {}
    public abstract void draw(Graphics g);
    public abstract boolean contains(Point mousePt);

	protected Color borderColor = DEFAULT_BORDER_COLOR;

    public Color getBorderColor() {
        return this.borderColor;
    }

    public void setBorderColor(Color bc) {
        borderColor = bc;
    }

	public Shape(Color c, Color bc, PathType pt) {
        this.color = c;
        this.borderColor = bc;
        
        if (pt == PathType.BOUNCING) {
            this.path = new BouncingPath(1, 2); 
        }
        
        else if (pt == PathType.DOWN_AND_UP) {
            this.path = new DownAndUpPath(1, 2); 
        }
    }
    
    
    public Shape(int x, int y, int width, int height, int panelWidth, int panelHeight, Color c, Color bc, PathType pt) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;
        this.color = c;
        this.borderColor = bc;
        
        if (pt == PathType.BOUNCING) {
            this.path = new BouncingPath(1, 2); 
        }
        
        else if (pt == PathType.DOWN_AND_UP) {
            this.path = new DownAndUpPath(1, 2); 
        }
    }
    
    
    public String toString() {
        return String.format("%s:[(%d,%d),%dx%d(%s)]", getClass().getName(), this.x, this.y, this.width, this.height, path.getClass().getName());
    }

 	public int getX() { return this.x; }
    public int getY() { return this.y;}
    public int getWidth() { return width; }
	public void setWidth(int w) { if (w < DEFAULT_PANEL_WIDTH && w > 0) width = w; }
    public int getHeight() {return height; }
	public void setHeight(int h) { if (h < DEFAULT_PANEL_HEIGHT && h > 0) height = h; }
    public boolean isSelected() { return selected; }
    public void setSelected(boolean s) { selected = s; }
	public Color getColor() { return color; }
    public void setColor(Color fc) { color = fc; }
    public void resetPanelSize(int w, int h) {
		panelWidth = w;
		panelHeight = h;
	}
 	public void drawHandles(Graphics obj) {
        if (selected) {
			System.out.println("Draw 4 handles");
        }
    }
    public void move() {
	        path.move();
    }
    /* Inner class ===================================================================== Inner class
     *    MovingPath : The superclass of all paths. It is an inner class.
     *    A path can change the current position of the shape.
     *    YOUR UPI: ahua091
     *    =============================================================================== */
    abstract class MovingPath {
        protected int deltaX, deltaY; // moving distance
        public MovingPath() { }
        public abstract void move();
    }
    class BouncingPath extends MovingPath {
        public BouncingPath(int dx, int dy) {
            deltaX = dx;
            deltaY = dy;
         }
        public void move() {
             x = x + deltaX;
             y = y + deltaY;
             if ((x < 0) && (deltaX < 0)) {
                 deltaX = -deltaX;
                 x = 0;
             }
             else if ((x + width > panelWidth) && (deltaX > 0)) {
                 deltaX = -deltaX;
                 x = panelWidth - width;
             }
             if ((y< 0) && (deltaY < 0)) {
                 deltaY = -deltaY;
                 y = 0;
             }
             else if((y + height > panelHeight) && (deltaY > 0)) {
                 deltaY = -deltaY;
                 y = panelHeight - height;
             }
        }
    }

    class DownAndUpPath extends MovingPath{

    
        public DownAndUpPath(int x, int y) {
            this.deltaX = x;
            this.deltaY = y;
        }
        
        public void move() {
            
            x += deltaX;
            y += deltaY;
            
            
            if (x > panelWidth - width) {
                x = 0;
            }
            
            if (y > panelHeight - height) {
                y = panelHeight - height;
                deltaY = -deltaY;
            }
    
            
            else if (y < 0) {
                y =  0;
                deltaY = -deltaY;
            }
    
            
        }
    }
}