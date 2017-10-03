import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private Container cp;
    private JButton Jbtn1 = new JButton("範例文");
    private JButton Jbtn2 = new JButton("加密");
    private JButton Jbtn3 = new JButton("清除");
    private JButton Jbtn4 = new JButton("離開");
    private JLabel Jlab = new JLabel("key");
    private JTextField Jtf = new JTextField("3");
    private JTextArea JtaL = new JTextArea();
    private JTextArea JtaR = new JTextArea();
    private JPanel Jpnl = new JPanel(new GridLayout(6,1,3,3));
    private JScrollPane JspL = new JScrollPane(JtaL);
    private JScrollPane JspR = new JScrollPane(JtaR);

    public MainFrame(){
        initComp();
    }
    private void initComp(){
        cp = this.getContentPane();
        this.setBounds(120,220,720,720);
        cp.setLayout(new BorderLayout(3,1));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Jlab.setHorizontalAlignment(JLabel.CENTER);
        Jpnl.add(Jbtn1);
        Jpnl.add(Jbtn2);
        Jpnl.add(Jlab);
        Jpnl.add(Jtf);
        Jpnl.add(Jbtn3);
        Jpnl.add(Jbtn4);
        cp.add(Jpnl,BorderLayout.CENTER);
        cp.add(JspL,BorderLayout.WEST);
        cp.add(JspR,BorderLayout.EAST);
        JtaL.setLineWrap(true);
        JtaR.setLineWrap(true);
        JspL.setPreferredSize(new Dimension(300,200));
        JspR.setPreferredSize(new Dimension(300,200));
        Jbtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JtaL.setText("請同學完成凱撒加密器，畫面如下：完成後請將 Repository 連結上傳到系統\n" +
                        "\n" +
                        "凱撒加密的作法是將英文字往後退 key 個位置，例如 key = 3則 asia 加密後會得到 dvld");
            }
        });

        Jbtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int key = Integer.parseInt(Jtf.getText());
                char data[]=JtaL.getText().toCharArray();
                int len=data.length;
                for(int i=0;i<len;i++){
                    data[i]+=key;
                }
                String str = new String(data);
                JtaR.setText(str);
            }
        });

        Jbtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JtaL.setText("");
                JtaR.setText("");
            }
        });

    }


}
