//必要なパッケージ群を指定します。
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//クラス宣言部です。
public class CountUp extends JPanel implements ActionListener{
    private int count = 0;

    private JLabel my_label;

    //CountUpクラスのコンストラクタです。
    public CountUp(){
        //GUI部品・ボタンを生成し、表示される固定テキスト「Next」を設定します。
        JButton my_button = new JButton("Next");
        //生成したボタンにActionListenerインタフェースメソッドを生成し割り当てます。
        my_button.addActionListener(this);
        my_label = new JLabel(String.format("%05d",count));
        setLayout(new FlowLayout());
        add(my_button); add(my_label);

    }

    public void actionPerformed(ActionEvent my_event){
        count = count + 1;
        my_label.setText(String.format("%05d", count));
        System.out.printf("%05d", count);
    }

    @Override
    public void paintComponent(Graphics my_graphics){
        super.paintComponent(my_graphics);
    }

    public static void main(String argv[]){
        SwingUtilities.invokeLater(()->{
            JFrame my_frame = new JFrame("CountUp");
            my_frame.add(new CountUp());
            my_frame.pack();
            my_frame.setVisible(true);
            my_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }

}

