package LifeGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LifeGameMachine extends JFrame {
	private JPanel contentPane;
	private JPanel pl_menu = new JPanel();
	private JPanel pl_view = new View();
	private JButton btn_start = new JButton("开始游戏");
	private JButton btn_reborn = new JButton("重生");
	private SingleForm[][] btns;
	private int theWidth;
	private int theHeight;
	private Field theField;
	private Clock theClock;
	/**
	 * Create the frame.
	 */
	public LifeGameMachine(int width, int height) {
		super("生命游戏");
		theHeight = height;
		theWidth = width;
		init(width, height);
	}
private	class btn_StartActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton jbtn = (JButton)e.getSource();
			if(jbtn.getText().equals("开始游戏")) {
				jbtn.setText("暂停游戏");
				theClock.setOK();
			}
			else {
				jbtn.setText("开始游戏");
				theClock.setOK();
			}
		}

	}
	
private class ViewClickActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SingleForm sf = (SingleForm)e.getSource();
			if(sf.getBackground() == Color.red) return;
			else {
				Cell o = theField.getCell(sf.getRow(),sf.getCol());
				o.reborn();
				sf.setBackground(Color.RED);
			}
		}
}

	public void setField(Field field) {
		theField = field;
	}
	
	public void setClock(Clock clock) {
		theClock = clock;
	}
	private void init(int width, int height) {
		btn_start.addActionListener(new btn_StartActionListener());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 438);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(pl_menu, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
				.addComponent(pl_view, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(pl_menu, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pl_view, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
		);
		pl_view.setLayout(new GridLayout(width, height));
		GroupLayout gl_pl_menu = new GroupLayout(pl_menu);
		gl_pl_menu.setHorizontalGroup(
			gl_pl_menu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pl_menu.createSequentialGroup()
					.addGap(38)
					.addComponent(btn_start, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(btn_reborn, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(312, Short.MAX_VALUE))
		);
		gl_pl_menu.setVerticalGroup(
			gl_pl_menu.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_pl_menu.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pl_menu.createParallelGroup(Alignment.LEADING)
						.addComponent(btn_reborn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(btn_start, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
					.addContainerGap())
		);
		pl_menu.setLayout(gl_pl_menu);
		contentPane.setLayout(gl_contentPane);
		initButtons();
		pack();
		setVisible(true);
	}
	
	public void initButtons() {
		btns = new SingleForm[theHeight][theWidth];
		for(int row = 0; row < theHeight; row++)
			for(int col = 0; col < theWidth; col++) {
				btns[row][col] = new SingleForm("");
				btns[row][col].setRowAndCol(row, col);
				btns[row][col].addActionListener(new ViewClickActionListener());
				btns[row][col].setBackground(Color.green);
				pl_view.add(btns[row][col]);
			}
	}
	
	public void changeButtonsColor(Field theField) {
		for(int row = 0; row < theHeight; row++)
			for(int col = 0; col < theWidth; col++) {
		if(theField.getCell(row, col).isAlive())
			btns[row][col].setBackground(Color.RED);
		else
			btns[row][col].setBackground(Color.white);
		}
	}
	/**
	 * Launch the application.
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		LifeGameMachine lGameMachine = new LifeGameMachine(40, 40);
		GameControl gameControl = new GameControl();
		Clock clock = new Clock(400);
		gameControl.InitField(40, 40);
		Field field = gameControl.getField();
		lGameMachine.setField(field);
		lGameMachine.setClock(clock);
		while(true) {
			//System.out.println(clock.getOK().booleanValue());
			while(clock.getOK().booleanValue()) {
				gameControl.updateView();
				lGameMachine.changeButtonsColor(field);
				clock.pause();
			}
			Thread.sleep(1);
		}
	}

}
