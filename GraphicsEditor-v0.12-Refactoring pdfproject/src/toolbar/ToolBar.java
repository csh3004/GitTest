package toolbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JToolBar;

import drawingPanel.DrawingPanel;
import global.Contants.EToolBar;
import shapes.GEEllipse;
import shapes.GELine;
import shapes.GEPolygon;
import shapes.GERectangle;
import shapes.GESelect;

public class ToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;

	
	// components
	private Vector<JButton> buttons;
	
	private GEToolBarHandler shapeToolBarHandler;
	// associations
	private DrawingPanel drawingPanel;


	public void associate(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
		
	}
	
	public ToolBar() {
	
		this.buttons = new Vector<JButton>();
		GEToolBarHandler actionHandler = new GEToolBarHandler();
		for(EToolBar eToolBar: EToolBar.values()) {
			JButton button = new JButton(eToolBar.getText());
			
			button.setActionCommand(eToolBar.getText());
			button.addActionListener(actionHandler);
			this.buttons.add(button);
			this.add(button);
		}
	}
	
	private class GEToolBarHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			JButton button = (JButton)event.getSource();
			if(button.getActionCommand().equals(EToolBar.rectangle.getText())) {
				drawingPanel.setCurrentShape(new GERectangle());
				drawingPanel.setCurrentTool("사각형");
			}else if(button.getActionCommand().equals(EToolBar.ellipse.getText())) {
				drawingPanel.setCurrentShape(new GEEllipse());
				drawingPanel.setCurrentTool("동그라미");
			}else if(button.getActionCommand().equals(EToolBar.line.getText())) {
				drawingPanel.setCurrentShape(new GELine());
				drawingPanel.setCurrentTool("선");
			}else if(button.getActionCommand().equals(EToolBar.select.getText())) {
				drawingPanel.setCurrentShape(new GESelect());
				drawingPanel.setCurrentTool("선택");
			}else if(button.getActionCommand().equals(EToolBar.polygon.getText())) {
				drawingPanel.setCurrentShape(new GEPolygon());
				drawingPanel.setCurrentTool("다각형");
			}				
			}
			
		}
		
	}

	

