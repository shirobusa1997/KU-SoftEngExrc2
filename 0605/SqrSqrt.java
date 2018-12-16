//必要なパッケージ群を指定します。
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//クラス宣言部です。
public class SqrSqrt extends JPanel implements ActionListener{
    private JTextField input;
    private JTextField output;

    //SqrSqrtクラスのコンストラクタです。
    public SqrSqrt(){
        setPreferredSize(new Dimension(400, 50));
        input = new JTextField("0", 8);
        output = new JTextField("0", 8);
        input.addActionListener(this);
        output.addActionListener(this);
        add(input); add(new JLabel("の平方は")); add(output); add(new JLabel("です。"));

    }

    public void actionPerformed(ActionEvent my_event){
        double n_input, n_output;

        Object my_source = my_event.getSource();

        if(my_source == input)
        {
            n_input = Double.parseDouble(input.getText());
            output.setText(String.format("%f", n_input * n_input));
        }

        else if(my_source == output)
        {
            n_output = Double.parseDouble(output.getText());
            input.setText(String.format("%f",  Math.sqrt(n_output)));
        }
    }

    @Override
    public void paintComponent(Graphics my_graphics){
        super.paintComponent(my_graphics);
    }

    public static void main(String argv[]){
        SwingUtilities.invokeLater(()->{
            JFrame my_frame = new JFrame("SqrSqrt");
            my_frame.add(new SqrSqrt());
            my_frame.pack();
            my_frame.setVisible(true);
            my_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }

}