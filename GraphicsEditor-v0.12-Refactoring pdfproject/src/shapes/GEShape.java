package shapes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;

import global.Contants;

public abstract class GEShape {
	protected Shape myShape;
	protected Point startP;
	protected BasicStroke dashedLineStroke;
	
	public GEShape(Shape shape) {
		this.myShape = shape;
	}
	
	
	public void draw(Graphics2D g2D) {
		g2D.draw(myShape);
	}
	
	public void dotdraw(Graphics2D g2D) {
		float dashes[] = {Contants.DEFAULT_DASH_OFFSET};
		dashedLineStroke = new BasicStroke(
				Contants.DEFAULT_DASHEDLINE_WIDTH,
				BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND, 10, dashes, 0);
		g2D.setStroke(dashedLineStroke);
		g2D.draw(myShape);
		
	}
	
	
	abstract public void initDraw(Point startP);
	abstract public void setCoordinate(Point currentP);
	abstract public GEShape clone();
}
