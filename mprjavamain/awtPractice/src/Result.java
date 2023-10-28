import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Random;

public class Result extends JFrame {

    JLabel mail, passwd, mailValue, passwdValue, l1, info;
//    JTextField info;
    ImageIcon emailIcon, passwdIcon, credsIcon;
    String resultInfo;
    boolean flag = false;
    Result(String name, String age, String percentile, String course, String quota, int emptySeats){

        credsIcon = new ImageIcon("Images/creds.png");
        emailIcon = new ImageIcon("Images/email.png");
        passwdIcon = new ImageIcon("Images/passwd.png");

        l1 = new JLabel("Results", SwingConstants.CENTER);
        l1.setBounds(250, 20, 500, 50);
        l1.setFont(new Font("Arial", Font.BOLD, 24));
        l1.setIcon(credsIcon);
        add(l1);

        float userPercentile = Float.parseFloat(percentile);
        if (userPercentile >= 80.0 && emptySeats > 0){
            flag = true;
            resultInfo = "Congratulations!! You are eligible to join this institute. These are your credentials";
        }
        else{
            resultInfo = "Sorry to inform you that you are not eligible yet to join our institution. However if there are any vacancies we'll contact you on the given credentials";
        }

        info = new JLabel("<html>" + resultInfo + "</html>", SwingConstants.CENTER);
        info.setBounds(100, 100, 800, 50);

        info.setFont(new Font("Arial", Font.PLAIN, 22));
        add(info);

        mail = new JLabel();
        mail.setText("Email ID");
        mail.setBounds(270, 180, 200, 30);
        mail.setFont(new Font("Arial", Font.BOLD, 22));
        mail.setIcon(emailIcon);
        add(mail);

        passwd = new JLabel();
        passwd.setBounds(270, 240, 200, 30);
        passwd.setFont(new Font("Arial", Font.BOLD, 22));
        passwd.setText("Password");
        passwd.setIcon(passwdIcon);
        add(passwd);

        mailValue = new JLabel();
        mailValue.setBounds(530, 180, 300, 30);
        mailValue.setFont(new Font("Arial", Font.PLAIN, 22));
        add(mailValue);

        passwdValue = new JLabel();
        passwdValue.setBounds(530, 240, 300, 30);
        passwdValue.setFont(new Font("Arial", Font.PLAIN, 22));
        add(passwdValue);

        String[] names = name.split(" ");
        String myMail = names[0] + names[names.length - 1] + age + "@gmail.com";
        Random random = new Random();
        int ran = random.nextInt(999999) + 100000;
        String userPasswd = names[0] + ran;
        mailValue.setText(myMail);
        passwdValue.setText(userPasswd);

        if (flag){
            insertDataIntoDatabase(name, Float.parseFloat(percentile), myMail, userPasswd, quota, course);
        }

        setSize(1000, 1000);
        setLayout(null);
        setVisible(true);
        setTitle("College Admission Portal");
        setResizable(false);
    }

    public void insertDataIntoDatabase(String name, float score, String mail, String passwd, String quota, String course){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\adwai\\IdeaProjects\\awtPractice\\StudentLog.db");
            Statement statement = con.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS StudentData (Name text, Percentile integer, Email text, Password text, Quota text, Course text)");
            statement.execute("INSERT INTO StudentData VALUES ( '" + name + "', " + score + ", '" + mail + "', '" + passwd + "', '" + quota + "', '" + course + "')");

            statement.close();
            con.close();
        } catch (SQLException e){
            System.out.println("Something went wrong " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
