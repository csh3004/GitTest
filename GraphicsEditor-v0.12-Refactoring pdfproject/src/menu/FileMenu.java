package menu;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import global.Contants.EFileMenu;

public class FileMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	
	private JMenuItem newItem;
	
	public FileMenu(String text) {
		super(text);
		
		this.newItem = new JMenuItem(EFileMenu.newItem.getText());
		this.add(this.newItem);
	}
}
