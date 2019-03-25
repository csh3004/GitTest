package menu;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import drawingPanel.DrawingPanel;
import global.Contants.EMenu;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;
	// components
	private FileMenu fileMenu;
	
	// associations
	private DrawingPanel drawingPanel;
	public void associate(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
		
	}
	public MenuBar() {
		this.fileMenu = new FileMenu(EMenu.fileMenu.getText());
		this.add(this.fileMenu);
	}


}
