package shapes;

import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class GELine extends GEShape {
	public GELine() {
		super(new Line2D.Double());
	}

public void initDraw(Point startP) {
	this.startP = startP;
}

public void setCoordinate(Point currentP) {
	Line2D tempLine = (Line2D)myShape;
	tempLine.setLine(startP.x, startP.y, currentP.x, currentP.y);

}

	public GEShape clone() {
		return new GELine();
	}
}
