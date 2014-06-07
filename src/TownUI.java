import java.awt.Color;
import java.awt.Container;
import java.awt.TextField;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * 
 * @author blmdlm
 * 
 */
public class TownUI extends javax.swing.JFrame {

	private House house[][] = new House[11][11];

	public TownUI() {
	}

	public void showUI() {

		this.setSize(600, 600);
		this.setTitle("快乐小镇");

		java.awt.FlowLayout f = new java.awt.FlowLayout();
		this.setLayout(f);

		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(3);

		this.setResizable(false);

		this.setVisible(true);
		java.awt.Graphics g = this.getGraphics();
		HouseListener hl = new HouseListener(g, house);
		this.getContentPane().setBackground(Color.WHITE);
		this.addMouseListener(hl);
		

	}

	public void paint(java.awt.Graphics g) {
		super.paint(g);
	
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TownUI cb = new TownUI();
		cb.showUI();
	}

}
