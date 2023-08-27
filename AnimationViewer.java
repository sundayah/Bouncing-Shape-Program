/**
 * ==========================================================================================
 *  AnimationViewer.java : Moves shapes around on the screen according to different paths.
 *  It is the main drawing area where shapes are added and manipulated.
 *  YOUR UPI: ahua091
 *  =========================================================================================
 */

import java.awt.*;
import java.util.ArrayList;

class AnimationViewer  {
    private ArrayList<Shape> shapes = new ArrayList<Shape>(); //create the ArrayList to store shapes
    private ShapeType currentShapeType = Shape.DEFAULT_SHAPETYPE; // the current shape type,
    private PathType currentPathType = Shape.DEFAULT_PATHTYPE;  // the current path type
    private Color currentColor=Shape.DEFAULT_COLOR;  // the current fill colour of a shape
    private int currentPanelWidth=Shape.DEFAULT_PANEL_WIDTH, currentPanelHeight = Shape.DEFAULT_PANEL_HEIGHT, currentWidth=Shape.DEFAULT_WIDTH, currentHeight=Shape.DEFAULT_HEIGHT;
    private Color currentBorderColor = Shape.DEFAULT_BORDER_COLOR;
	


    
	public void createNewShape(int x, int y) {
   
        switch(currentShapeType) {
            
            case RECTANGLE:
                RectangleShape newShape = new RectangleShape(x, y, currentWidth, currentHeight, currentPanelWidth, currentPanelHeight, currentColor, currentBorderColor, currentPathType);
                shapes.add(newShape);
                break;
                
                
            case TRIANGLE_ARROW:
                TriangleArrowShape triangleShape = new TriangleArrowShape(x, y, currentWidth, currentHeight, currentPanelWidth, currentPanelHeight, currentColor, currentBorderColor, currentPathType);
                shapes.add(triangleShape);
                break;
                
                
            case SPOTTED:
                SpottedRectangleShape spottedShape = new SpottedRectangleShape(x, y, currentWidth, currentHeight, currentPanelWidth, currentPanelHeight, currentColor, currentBorderColor, currentPathType);
                shapes.add(spottedShape);
                break;
                
        }    
    }
    
   
	public AnimationViewer() {}


    public ShapeType getCurrentShapeType() {
        return currentShapeType;
    }

    public PathType getCurrentPathType() {
        return currentPathType;
    }

    public void setCurrentShapeType(ShapeType s) {
        currentShapeType = s;
    }

    public void setCurrentPathType(PathType p) {
        currentPathType = p;
    }


    public Color getCurrentBorderColor() {
        return currentBorderColor;
    }

    public void setCurrentBorderColor(Color bc) {
        currentBorderColor = bc;
    }

	public int getCurrentWidth() { return  currentWidth; }
    public void setCurrentWidth(int w) {currentWidth=w;}
	public int getCurrentHeight() { return currentHeight; }
    public void setCurrentHeight(int h) {currentHeight=h;}
    public Color getCurrentColor() { return currentColor; }
    public void setCurrentColor(Color c){currentColor = c;}
    public void setPanelWidth(int w) {currentPanelHeight=w;}
    public void setPanelHeight(int h) {currentPanelHeight=h;}
    public void paintComponent(Graphics g) {
		for (Shape currentShape: shapes) {
			currentShape.move();
			currentShape.draw(g);
			currentShape.drawHandles(g);
		}
    }
}