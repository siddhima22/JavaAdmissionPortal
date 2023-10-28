import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectUser extends JFrame implements ActionListener {
    Button b1, b2;
    SelectUser() {

        ImageIcon loginIcon = new ImageIcon("Images/login.png");
        ImageIcon nameIcon = new ImageIcon("Images/name.png");

        JLabel l1 = new JLabel("Select User:", SwingConstants.CENTER);
        l1.setBounds(340, 220, 500, 50);
        l1.setFont(new Font("Arial", Font.PLAIN, 24));
        l1.setIcon(loginIcon);
        add(l1);

        b1 = new Button("Student");
        b2 = new Button("Teacher");
        b1.setFont(new Font("Arial", Font.PLAIN, 20));
        b2.setFont(new Font("Arial", Font.PLAIN, 20));
        b1.setBounds(525, 290, 100, 30);
        b2.setBounds(525, 340, 100, 30);

        b1.addActionListener(this);
        b2.addActionListener(this);

        add(b1);
        add(b2);

        setSize(1200, 1000);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        SelectUser f = new SelectUser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            dispose();
            Main main1 = new Main();
        }
        else if (e.getSource() == b2){
            dispose();
            Teacher teacher1 = new Teacher();
        }
    }
}
