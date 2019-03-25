package main;
import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;

import drawingPanel.DrawingPanel;
import global.Contants.EMainFrame;
import menu.MenuBar;
import toolbar.ToolBar;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private MenuBar menuBar;
	private ToolBar toolBar;
	private DrawingPanel drawingPanel;
	
	
	public MainFrame() {
			
		//attributes 속성 (색깔 크기
	this.setLocation(EMainFrame.x.getValue(),EMainFrame.y.getValue());
	this.setSize(EMainFrame.w.getValue(), EMainFrame.h.getValue());
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	// components 자식 (바퀴 엔진
	this.menuBar = new MenuBar();
	this.setJMenuBar(this.menuBar);
	
	this.setLayout(new BorderLayout());
	this.toolBar = new ToolBar();
	this.add(this.toolBar, BorderLayout.NORTH);
	

	this.drawingPanel = new DrawingPanel();
	this.add(this.drawingPanel, BorderLayout.CENTER);
	
	
	// associations
	this.menuBar.associate(this.drawingPanel);
	this.toolBar.associate(this.drawingPanel);
	
	}
}
