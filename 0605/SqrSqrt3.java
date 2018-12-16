//必要なパッケージ群を指定します。
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//クラス宣言部です。
public class SqrSqrt3 extends JPanel{
    private JTextField input;
    private JTextField output;
    double n_input = 0;
    double n_output = 0;

    //SqrSqrt3クラスのコンストラクタです。
    public SqrSqrt3(){

        setPreferredSize(new Dimension(400, 50));

        input = new JTextField("0", 8);
        output = new JTextField("0", 8);

        input.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent my_event){
                n_input = Double.parseDouble(input.getText());
                output.setText(String.format("%f", n_input * n_input));
            }
        });

        output.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent my_event){
                n_output = Double.parseDouble(output.getText());
                input.setText(String.format("%f", Math.sqrt(n_output)));
            }
        });

        add(input); add(new JLabel("の平方は")); add(output); add(new JLabel("です。"));

    }

    @Override
    public void paintComponent(Graphics my_graphics){
        super.paintComponent(my_graphics);
    }

    public static void main(String argv[]){
        SwingUtilities.invokeLater(()->{
            JFrame my_frame = new JFrame("SqrSqrt");
            my_frame.add(new SqrSqrt3());
            my_frame.pack();
            my_frame.setVisible(true);
            my_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }

}