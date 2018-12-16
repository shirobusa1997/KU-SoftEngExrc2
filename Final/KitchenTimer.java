import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class KitchenTimer extends JPanel implements Runnable, ActionListener {
	private int[] args = new int[12];
	private final Color[] cs = {Color.RED, Color.ORANGE, Color.GREEN, Color.BLUE};
	private volatile Thread thread = null;
	private int i, j;
	private volatile boolean threadSuspended = true;

	public synchronized void actionPerformed(ActionEvent e) {
		threadSuspended = false;
		notify();
	}

	@Override
	public void paintComponent(Graphics g) {
		int k;
		
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.fillOval(5, 50 + j * 10, 10, 10);
		g.setColor(Color.CYAN);
		g.fillOval(5, 50 + i * 10, 10, 10);
		for (k = 0; k < args.length; k++) {
			g.setColor(cs[k % cs.length]);
			g.fillRect(20, 50 + k * 10, args[k] * 5, 10);
		}
	}

	private void prepareRandomData() {
		int len = args.length;
		for (int k = 0; k < len; k++) { 
			args[k] = (int)(Math.random() * len * 4);  // 適当な範囲の乱数
		}
    }

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("キッチンタイマー");
			frame.add(new KitchenTimer());
			frame.pack();
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		});
	}
}
