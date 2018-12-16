//必要なパッケージ群を指定します。
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


//クラス宣言部です。
public class PolygonDraw extends JPanel implements MouseListener{
    //クラスフィールド宣言部です。
    public Polygon my_polygon;
    public Rectangle my_rectangle;
    private Color polygon_color = Color.BLUE;
    private Color rectangle_color = Color.RED;


    //PolygonDrawクラスのコンストラクタです。
    public PolygonDraw(){
        setPreferredSize(new Dimension(256, 256));
        addMouseListener(this);
        
        my_polygon = new Polygon();
        my_rectangle = new Rectangle();
    }
    
    public void mouseClicked(MouseEvent my_event){
        double mousepos_x, mousepos_y;

        mousepos_x = my_event.getX();
        mousepos_y = my_event.getY();

        if((my_polygon.contains(mousepos_x, mousepos_y)) && (my_event.getClickCount() >= 2)){
            my_polygon.reset();
        }else{
            my_polygon.addPoint((int)mousepos_x, (int)mousepos_y);
        }
        my_rectangle = my_polygon.getBounds();

        System.out.printf("Count   :" + my_event.getClickCount() + "\n");
        System.out.printf("MousePos_x   :" + (int)mousepos_x + "\n");
        System.out.printf("MousePos_y   :" + (int)mousepos_y + "\n");

        repaint();
    }

    public void mousePressed(MouseEvent my_event){}
    public void mouseReleased(MouseEvent my_event){}
    public void mouseEntered(MouseEvent my_event){}
    public void mouseExited(MouseEvent my_event){}

    @Override
    public void paintComponent(Graphics my_graphics){
        super.paintComponent(my_graphics);

        my_graphics.setColor(polygon_color);
        my_graphics.drawPolygon(my_polygon);
        my_graphics.setColor(rectangle_color);
        my_graphics.drawRect(my_rectangle.x, my_rectangle.y, my_rectangle.width, my_rectangle.height);
    }

    public static void main(String argv[]){
        SwingUtilities.invokeLater(()->{
            JFrame my_frame = new JFrame("長方形の描画");
            my_frame.add(new PolygonDraw());
            my_frame.pack();
            my_frame.setVisible(true);
            my_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}