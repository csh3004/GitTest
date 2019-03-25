package shapes;

import java.awt.Point;
import java.awt.Polygon;

public class GEPolygon extends GEShape {

	public GEPolygon() {
		super(new Polygon());
	}
	@Override
	public void initDraw(Point p) {
		((Polygon) myShape).addPoint(p.x, p.y);
	}

	@Override
	public void setCoordinate(Point p) {
		((Polygon) myShape).xpoints[((Polygon) myShape).npoints-1] = p.x;
		((Polygon) myShape).ypoints[((Polygon) myShape).npoints-1] = p.y;

	}
	
	public void continueDrawing(Point p) {
		((Polygon) myShape).addPoint(p.x, p.y);
	}

	@Override
	public GEShape clone() {
		// TODO Auto-generated method stub
		return new GEPolygon();
	}

}
