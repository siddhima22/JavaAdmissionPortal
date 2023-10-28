import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

public class prac1 extends JFrame implements ActionListener{

    JLabel l1, name, age, gender, course, quota, seatsEmpty, score, phone, seatEmptyValue1;
    TextField tName, tAge, tScore, tPhone;
    CheckboxGroup cbgGender;
    Checkbox male, female, nb, others;
    Choice CCourse, CQuota;
    Button creds;
    int totalSeats = 10, seatsTaken, seatEmptyValue;

    void prac1() {

        try{
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\adwai\\IdeaProjects\\awtPractice\\StudentLog.db");
            Statement statement1 = con.createStatement();

            ResultSet results1 = statement1.executeQuery("SELECT COUNT(*) AS count FROM StudentData");
            while(results1.next()){
                seatsTaken = results1.getInt("count");
            }
            results1.close();
            statement1.close();
            con.close();
        } catch (SQLException e){
            System.out.println("Something went wrong " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        seatEmptyValue = totalSeats - seatsTaken;

        ImageIcon loginIcon = new ImageIcon("Images/login.png");
        ImageIcon nameIcon = new ImageIcon("Images/name.png");
        ImageIcon ageIcon = new ImageIcon("Images/age.png");
        ImageIcon genderIcon = new ImageIcon("Images/gender.png");
        ImageIcon courseIcon = new ImageIcon("Images/course.png");
        ImageIcon quotaIcon = new ImageIcon("Images/quota.png");
        ImageIcon scoreIcon = new ImageIcon("Images/score.png");
        ImageIcon seatsIcon = new ImageIcon("Images/seats.png");
        ImageIcon phoneIcon = new ImageIcon("Images/phone.jpg");

        l1 = new JLabel("Student Login", SwingConstants.CENTER);
        l1.setBounds(340, 20, 500, 50);
        l1.setFont(new Font("Arial", Font.PLAIN, 24));
        l1.setIcon(loginIcon);
        add(l1);

        name = new JLabel("Name");
        name.setBounds(270, 100, 200, 30);
        name.setFont(new Font("Arial", Font.BOLD, 22));
        name.setIcon(nameIcon);
        add(name);

        age = new JLabel("Age");
        age.setBounds(270, 160, 200, 30);
        age.setFont(new Font("Arial", Font.BOLD, 22));
        age.setIcon(ageIcon);
        add(age);

        gender = new JLabel("Gender");
        gender.setBounds(270, 220, 200, 30);
        gender.setFont(new Font("Arial", Font.BOLD, 22));
        gender.setIcon(genderIcon);
        add(gender);

        course = new JLabel("Course");
        course.setBounds(270, 280, 200, 30);
        course.setFont(new Font("Arial", Font.BOLD, 22));
        course.setIcon(courseIcon);
        add(course);

        quota = new JLabel("Quota");
        quota.setBounds(270, 340, 200, 30);
        quota.setFont(new Font("Arial", Font.BOLD, 22));
        quota.setIcon(quotaIcon);
        add(quota);

        seatsEmpty = new JLabel("Seats Empty");
        seatsEmpty.setBounds(270, 400, 200, 30);
        seatsEmpty.setFont(new Font("Arial", Font.BOLD, 22));
        seatsEmpty.setIcon(seatsIcon);
        add(seatsEmpty);

        score = new JLabel("CET Percentile");
        score.setBounds(270, 460, 200, 30);
        score.setFont(new Font("Arial", Font.BOLD, 22));
        score.setIcon(scoreIcon);
        add(score);

        phone = new JLabel("Phone Number");
        phone.setBounds(270, 520, 200, 30);
        phone.setFont(new Font("Arial", Font.BOLD, 22));
        phone.setIcon(phoneIcon);
        add(phone);

        tName = new TextField();
        tName.setBounds(530, 100, 400, 30);
        tName.setFont(new Font("Arial", Font.PLAIN, 22));
        add(tName);

        tAge = new TextField();
        tAge.setBounds(530, 160, 400, 30);
        tAge.setFont(new Font("Arial", Font.PLAIN, 22));
        add(tAge);

        cbgGender = new CheckboxGroup();

        male = new Checkbox("Male", cbgGender, false);
        male.setBounds(530, 220, 100, 30);
        male.setFont(new Font("Arial", Font.PLAIN, 18));
        add(male);

        female = new Checkbox("Female", cbgGender, false);
        female.setBounds(640, 220, 100, 30);
        female.setFont(new Font("Arial", Font.PLAIN, 18));
        add(female);

        nb = new Checkbox("Non-Binary", cbgGender, false);
        nb.setBounds(750, 220, 120, 30);
        nb.setFont(new Font("Arial", Font.PLAIN, 18));
        add(nb);

        others = new Checkbox("Prefer Not To Say", cbgGender, false);
        others.setBounds(880, 220, 180, 30);
        others.setFont(new Font("Arial", Font.PLAIN, 18));
        add(others);

        CCourse = new Choice();
        CCourse.setBounds(530, 280, 400, 30);
        CCourse.add("Computer Science");
        CCourse.add("IT");
        CCourse.add("AI / ML");
        CCourse.add("EXTC");
        CCourse.add("Mechanical Engineering");
        CCourse.add("Chemical Engineering");
        add(CCourse);

        CQuota = new Choice();
        CQuota.setBounds(530, 340, 400, 30);
        CQuota.add("Sindhi Quota");
        CQuota.add("OBC");
        CQuota.add("Women Quota");
        CQuota.add("General");
        add(CQuota);

        seatEmptyValue1 = new JLabel(seatEmptyValue + "");
        seatEmptyValue1.setBounds(530, 400, 200, 30);
        seatEmptyValue1.setFont(new Font("Arial", Font.BOLD, 22));
        add(seatEmptyValue1);

        tScore = new TextField();
        tScore.setBounds(530, 460, 400, 30);
        tScore.setFont(new Font("Arial", Font.PLAIN, 22));
        add(tScore);

        tPhone = new TextField();
        tPhone.setBounds(530, 520, 400, 30);
        tPhone.setFont(new Font("Arial", Font.PLAIN, 22));
        add(tPhone);

        creds = new Button("Result");
        creds.setBounds(500, 580, 200, 30);
        creds.setFont(new Font("Arial", Font.PLAIN, 22));
        creds.setBackground(Color.BLACK);
        creds.setForeground(Color.WHITE);

        creds.addActionListener(this);

        add(creds);

        setSize(1200, 800);
        setTitle("College Admission Portal");
        setResizable(false);
        setLayout(null);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == creds){
            String course = CCourse.getItem(CCourse.getSelectedIndex());
            String quota = CQuota.getItem(CQuota.getSelectedIndex());
            dispose();
            Result myMain = new Result(tName.getText(), tAge.getText(), tScore.getText(), course, quota, seatEmptyValue);
        }
    }
}

