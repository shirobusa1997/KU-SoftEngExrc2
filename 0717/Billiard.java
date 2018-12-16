import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Billiard extends JPanel implements Runnable{
    int ui_width = 300, ui_height = 300;
    double oval_w = 10, oval_h = 10;
    double oval_cx, oval_cy;
    double x = ui_width / 2, y = ui_height / 2, dx = 1.618034 * 3, dy = 3;
    Thread my_thread = null;

    public Billiard(){
        setPreferredSize(new Dimension(ui_width, ui_height));
        startThread();
    }

    public void startThread(){
        if(my_thread == null){
            my_thread = new Thread(this);
            my_thread.start();
        }
    }
    public void stopThread(){
        my_thread = null;
    }

    @Override
    public void run(){
        Thread me = Thread.currentThread();
        while(my_thread == me){
            x += dx;
            y += dy;
            oval_cx = x + oval_w/2;
            oval_cx = y + oval_h/2;

            if((x + oval_w) > (double)ui_width || x < 0){
                dx *= -1;
            }
            if((y + oval_h) > (double)ui_height || y < 0){
                dy *= -1;
            }

            repaint();
            try{
                Thread.sleep(40);
            }catch(InterruptedException e){}
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillOval((int)x, (int)y, (int)oval_w, (int)oval_h);
    }

    public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("ビリヤード");
			frame.add(new Billiard());
			frame.pack();
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		});
	}
}