import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.RepaintManager;


/**
 * 
 * @author blmdlm
 * 
 */
public class HouseListener implements java.awt.event.MouseListener {
	private java.awt.Graphics g;
	private House houses[][];
	private List<Integer> x;
	private List<Integer> y;
	static int poX=0;
	static int poY=0;

	public HouseListener(java.awt.Graphics g, House houses[][]) {
		this.g = g;
		this.houses = houses;
		x=new ArrayList<>();
		y=new ArrayList<>();
	}



	@Override
	public void mouseReleased(MouseEvent e) {

		House house = new House();
		
	
		house.setX(e.getX());
		house.setY(e.getY());
		boolean inner = false;

		if (house.getX() >= 50 && house.getX() <= 550 && house.getY() >= 50
				&& house.getY() <= 550) {
			inner = true;
		}

		if (house.getX() % 50 < 25)
			house.setX(house.getX() / 50 * 50);
		else
			house.setX(house.getX() / 50 * 50 + 50);
		if (house.getY() % 50 < 25)
			house.setY(house.getY() / 50 * 50);
		else {
			house.setY(house.getY() / 50 * 50 + 50);

		}
		if (inner) {

			int i = house.getX() / 50 - 1;
			int j = house.getY() / 50 - 1;

			if (houses[i][j] != null) {

				javax.swing.JOptionPane.showMessageDialog(null, "已经放置了居民点");
				return;
			}
		
			System.out.println("新的居民点" + house.getX() + " " + house.getY());
			houses[i][j] = house;
			//清空画布
			g.clearRect(0, 0,600,600);
			//重画居民点
			 
				for (int m = 0; m < houses.length; m++) {
			for (int n = 0; n< houses[m].length; n++) {
				House c = houses[m][n];
				if (c != null) {

					g.setColor(java.awt.Color.BLUE);

					g.fillOval(c.getX() - 10, c.getY() - 10, 20, 20);
					g.drawString("居民点", c.getX() - 10, c.getY() - 10);
				}
			}
		}
		//重画网格线
						int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
				x1 = 50;
				y1 = 50;
				x2 = x1 + 500;
				for (int p = 0; p < 11; p++) {
					g.drawLine(x1, y1, x2, y1);
					y1 += 50;

				}
				x1 = 50;
				y1 = 50;
				y2 = x1 + 500;
				for (int q= 0; q < 11; q++) {
					g.drawLine(x1, y1, x1, y2);
					x1 += 50;

				}
			
			//捕获新居民点
			x.add(house.getX());
			y.add(house.getY());
		
			//找出邮局的位置，并画出
			poX=Tool.findThePoint(x);
			poY=Tool.findThePoint(y);
			g.setColor(java.awt.Color.RED);
			//g.fillOval(poX - 20, poY - 20, 40, 40);
			//g.fillRect(poX - 20, poY - 20, 40, 40);
			g.fill3DRect(poX - 5, poY - 5, 10, 10,true);
			g.drawString("邮局", poX-10, poY-10);
			//g.fillArc(poX - 20, poY - 20, 40, 40, 100	,100);   //扇形
			//g.fillRoundRect(poX - 20, poY - 20, 40, 40, 30	,30); //圆角矩形
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}