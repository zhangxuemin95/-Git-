package LifeGame;

import javax.swing.JButton;

public class SingleForm extends JButton{
	private int row;
	private int col;
	
	public SingleForm(String s) {
		super(s);
	}
	public void setRowAndCol(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
}
