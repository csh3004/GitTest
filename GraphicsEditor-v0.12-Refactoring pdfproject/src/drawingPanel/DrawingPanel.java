package drawingPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import global.Contants.EState;
import global.Contants.EToolBar;
import shapes.GEEllipse;
import shapes.GELine;
import shapes.GEPolygon;
import shapes.GERectangle;
import shapes.GESelect;
import shapes.GEShape;


public class DrawingPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private MouseHandler mouseHandler;
	private GERectangle rectangle;
	private GELine line;
	private GEEllipse ellipse;
	private GESelect select;
	private EToolBar selectShape;
	private String currentTool;
	private GEShape currentShape;
	private EState currentState;
	private ArrayList<GEShape> shapeList;
	
	public void setCurrentTool(String currentTool) {
		this.currentTool = currentTool;
		
	}
	
	
	public DrawingPanel() {
		super();
		
		currentState = EState.Idle;
		
		shapeList = new ArrayList<GEShape>();
		this.setBackground(Color.WHITE);
		
		this.mouseHandler = new MouseHandler();
		this.addMouseListener(this.mouseHandler);
		this.addMouseMotionListener(this.mouseHandler);
		
	//	currentTool = EToolBar.select.getText();
		
	}

	public void setCurrentShape(GEShape currentShape) {
		this.currentShape = currentShape;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		for (GEShape shape : shapeList) {
			shape.draw(g2D);
		}
	}
	
	
	
	private void initDraw(Point originP) {
		currentShape = currentShape.clone();
		currentShape.initDraw(originP);
		
	}
	private void animateDraw(Point currentP){ 
		Graphics2D g2D = (Graphics2D)getGraphics(); 
		g2D.setXORMode(g2D.getBackground()); 
		
		currentShape.dotdraw(g2D);
		currentShape.setCoordinate(currentP); 
		currentShape.dotdraw(g2D); 
		} 
	
	private void continueDrawing(Point p) {
		((GEPolygon) currentShape ).continueDrawing(p);
	}
	
	private void finishDraw(GEShape shape) {
		shapeList.add(shape);
		
		currentState = EState.Idle;
		repaint();
	}
	


private class MouseHandler implements MouseListener, MouseMotionListener {
	

		@Override
		public void mouseClicked( MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON1 ){ 
				if(currentState == EState.NPointsDrawing ){ 
					if(e.getClickCount() == 1){ 
						continueDrawing(e.getPoint()); 
					} else if(e.getClickCount() == 2){ 
						finishDraw(currentShape); 
						currentState = EState.Idle ; 
						repaint(); 
						} 
					} 
				}

		}

		public void mousePressed(MouseEvent e) {

			if(currentState  == EState.Idle ){ 
				initDraw(e.getPoint()); 
			if(currentShape instanceof GEPolygon){
				currentState = EState.NPointsDrawing ; 
				}
			else{
				currentState = EState.TwoPointsDrawing ;
				} 
			}
		
		
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
			if(currentTool == "º±≈√" ) {
				initDraw(e.getPoint());
				animateDraw(e.getPoint());
			}
			
			
			if(currentState == EState.TwoPointsDrawing ){
				finishDraw(currentShape);
			}
			
			
			
			
		}

		@Override
		public void mouseDragged(MouseEvent e) {
				
			if (currentState != EState.Idle ){
				animateDraw(e.getPoint()); 
			}

	
		
		
			
		}

		

		@Override
		public void mouseMoved(MouseEvent e) {
			if(currentState == EState. NPointsDrawing ){
				animateDraw(e.getPoint()); 
			}
			
		}


		public void mouseEntered(MouseEvent arg0) {	}
		public void mouseExited(MouseEvent e) {	}
		
	}



}
