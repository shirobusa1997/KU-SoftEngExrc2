import java.awt.*;
import javax.swing.*;

public class FontMetricsTest extends JPanel{
    public String ud_string = "Good Morning!";
    public FontMetrics metrics;

    public FontMetricsTest(){
        setPreferredSize(new Dimension(256, 128));
    }

    @Override
    public void paintComponent(Graphics my_graphics){
        super.paintComponent(my_graphics);
        
        my_graphics.setColor(Color.BLUE);
        my_graphics.drawLine(0, 64, 256, 64);
        my_graphics.setColor(Color.RED);
        my_graphics.drawLine(128, 0, 128, 128);
        my_graphics.setColor(Color.BLACK);

        my_graphics.setFont(new Font("Arial", Font.BOLD, 24));
        metrics = my_graphics.getFontMetrics();
        int asc = metrics.getAscent();
        int dec = metrics.getDescent();
        int width = metrics.stringWidth(ud_string);
        my_graphics.drawString(ud_string, 128 - (width / 2), 64);

        my_graphics.setColor(Color.GREEN);
        my_graphics.drawRect(128 - (width / 2), 64 - asc, width, asc + dec);
    }

    public static void main(String argv[]){
        SwingUtilities.invokeLater(()->{
            JFrame my_frame = new JFrame("フォントメトリクステスト");
            my_frame.add(new FontMetricsTest());
            my_frame.pack();
            my_frame.setVisible(true);
            my_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}