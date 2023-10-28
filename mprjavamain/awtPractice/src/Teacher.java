import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Teacher extends JFrame implements ActionListener {
    String name, email, teacherId, password;

    Teacher() {
        ImageIcon emailIcon = new ImageIcon("Images/email.png");
        ImageIcon passwdIcon = new ImageIcon("Images/passwd.png");
        ImageIcon nameIcon = new ImageIcon("Images/name.png");
        ImageIcon credsIcon = new ImageIcon("Images/score.png");
        ImageIcon loginIcon = new ImageIcon("Images/login.png");

        JLabel l0 = new JLabel("Teacher login :");
        JLabel l1 = new JLabel("Name                 : ");
        JLabel l2 = new JLabel("Email                 : ");
        JLabel l3 = new JLabel("Teacher id         :");
        JLabel l4 = new JLabel("Password          : ");


        l0.setBounds(450, 100, 250, 40);
        l1.setBounds(270, 190, 250, 30);
        l2.setBounds(270, 240, 250, 30);
        l3.setBounds(270, 290, 250, 30);
        l4.setBounds(270, 340, 250, 30);

        l0.setFont(new Font("Arial", Font.PLAIN, 30));
        l1.setFont(new Font("Arial", Font.PLAIN, 24));
        l2.setFont(new Font("Arial", Font.PLAIN, 24));
        l3.setFont(new Font("Arial", Font.PLAIN, 24));
        l4.setFont(new Font("Arial", Font.PLAIN, 24));

        l0.setIcon(loginIcon);
        l1.setIcon(nameIcon);
        l2.setIcon(emailIcon);
        l3.setIcon(credsIcon);
        l4.setIcon(passwdIcon);

        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        TextField tf4 = new TextField();
        tf1.setBounds(530, 190, 400, 30);
        tf2.setBounds(530, 240, 400, 30);
        tf3.setBounds(530, 290, 400, 30);
        tf4.setBounds(530, 340, 400, 30);

        tf1.setFont(new Font("Arial", Font.PLAIN, 24));
        tf2.setFont(new Font("Arial", Font.PLAIN, 24));
        tf3.setFont(new Font("Arial", Font.PLAIN, 24));
        tf4.setFont(new Font("Arial", Font.PLAIN, 24));

        Button b1 = new Button("Admission log");
        b1.setBounds(490, 450, 100, 30);
        b1.addActionListener(this);

        add(l0);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(tf1);
        add(tf2);
        add(tf3);
        add(tf4);
        add(b1);

        setSize(1200, 1000);
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        DisplayInformation di = new DisplayInformation();
    }
}
