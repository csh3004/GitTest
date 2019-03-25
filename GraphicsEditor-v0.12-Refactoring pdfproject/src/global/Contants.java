package global;

public class Contants {

	public static final int DEFAULT_DASH_OFFSET = 4;
	public static final int DEFAULT_DASHEDLINE_WIDTH = 1;
	
	
	public enum EMainFrame {
		x(200),
		y(100),
		w(400),
		h(600)
		;
		private int value;
		EMainFrame(int value){
			this.value = value;
		}
		public int getValue() {
			return this.value;
		}
		
	}
	
	public enum EToolBar {
		select("선택"),
		rectangle("네모"),
		ellipse("동그라미"),
		line("라인"),
		polygon("다각형")
		;
		private String text;
		private EToolBar(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
			}
		}
	
	public enum EMenu {
		fileMenu("파일"),
		editMenu("Edit"),
		;
		private String text;
		private EMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
			}
		}
	
	public enum EFileMenu {
		newItem("새로만들기"),
		openItem("open"),
		;
		private String text;
		private EFileMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
			}
		}
	
	public static enum EState {Idle, TwoPointsDrawing, NPointsDrawing }
	
	
	
}
