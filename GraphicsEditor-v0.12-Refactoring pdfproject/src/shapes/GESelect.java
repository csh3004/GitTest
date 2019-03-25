package shapes;

import java.awt.Point;
import java.awt.Rectangle;

public class GESelect extends GEShape {
	public GESelect() {
			super(new Rectangle());
		}
	
	public void initDraw(Point startP) {
		this.startP = startP;
	}
	
	public void setCoordinate(Point currentP) {
		Rectangle tempRectangle = (Rectangle)myShape;
		tempRectangle.setFrameFromDiagonal(startP.x, startP.y, currentP.x, currentP.y);

	}
	public GEShape clone() {
		return new GESelect();
	}
}
