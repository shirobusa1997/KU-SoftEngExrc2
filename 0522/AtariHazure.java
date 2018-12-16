//プログラム実行に必要なパッケージ群をインポートします。
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.awt.Color.*;

public class AtariHazure extends JPanel implements MouseListener{
    private boolean clicked = false;
    private boolean isinranged = false;
    private int circle_x = 50, circle_y = 50, circle_w = 50, circle_h = 50, circle_cx, circle_cy, circle_r;    
    
    //クラスのコンストラクタです。
    public AtariHazure(){
        setPreferredSize(new Dimension(150, 150));
        addMouseListener(this);

        circle_cx = circle_x + circle_w / 2;
        circle_cy = circle_y + circle_h / 2;
        circle_r = circle_w / 2;

        System.out.printf("circle_x     :" + circle_x + "\n");
        System.out.printf("circle_y     :" + circle_y + "\n");
        System.out.printf("circle_w     :" + circle_w + "\n");
        System.out.printf("circle_h     :" + circle_h + "\n");
        System.out.printf("circle_cx    :" + circle_cx + "\n");
        System.out.printf("circle_cy    :" + circle_cy + "\n");
        System.out.printf("circle_r     :" + circle_r + "\n\n");
    }

    public void mouseClicked(MouseEvent e){
        double mousepos_x, mousepos_y, clickedval;

        clicked = true;
        mousepos_x = e.getX();
        mousepos_y = e.getY();

        clickedval = (mousepos_x - circle_cx) * (mousepos_x - circle_cx) + (mousepos_y - circle_cy) * (mousepos_y - circle_cy);
        isinranged = (clickedval <= (circle_r * circle_r)) ? true : false;

        System.out.printf("MousePos_x   :" + mousepos_x + "\n");
        System.out.printf("MousePos_y   :" + mousepos_y + "\n");
        System.out.printf("clickedval   :" + clickedval + "\n");
        System.out.printf("circle_r^2   :" + (circle_r * circle_r) + "\n");
        System.out.printf("isinranged   :" + isinranged + "\n");
  
        if (clickedval <= (circle_r * circle_r)){
            isinranged = true;
            System.out.printf("mouseClicked :Clicked position is in range.\n");
        }else{
            isinranged = false;
            System.out.printf("mouseClicked :Clicked position is NOT in range.\n");
        }
        repaint();

        return;
    }

    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}    

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(RED);
        g.fillArc(circle_x,circle_y,circle_w,circle_h,0,360);
        
        if(clicked == true){
            if(isinranged == true)
            {
                g.setColor(BLACK);
                g.drawString("あたり", 65, 120);
            }
            else
            {
                g.setColor(BLACK);
                g.drawString("はずれ", 65, 120);
            }
        }
    }

    //AtariHazureクラスのメインメソッドです。
    public static void main(String argv[]){
        SwingUtilities.invokeLater(()->{
            JFrame frame = new JFrame("あたりはずれ");
            frame.add(new AtariHazure());
            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}