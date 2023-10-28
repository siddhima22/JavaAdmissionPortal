import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class DisplayInformation extends JFrame {

    int count, i = 0;
    String[][] rows;
    DisplayInformation(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\adwai\\IdeaProjects\\awtPractice\\StudentLog.db");
            Statement statement = con.createStatement();
            Statement statement1 = con.createStatement();

            ResultSet results1 = statement1.executeQuery("SELECT COUNT(*) AS count FROM StudentData");
            while(results1.next()){
                count = results1.getInt("count");
            }

            statement.execute("SELECT * FROM StudentData");
            ResultSet results = statement.getResultSet();
            rows = new String[count][6];
            while (results.next()){
                rows[i][0] = results.getString("Name");
                rows[i][1] = results.getInt("Percentile") + "";
                rows[i][2] = results.getString("Email");
                rows[i][3] = results.getString("Password");
                rows[i][4] = results.getString("Quota");
                rows[i][5] = results.getString("Course");
                i++;
            }
            results1.close();
            results.close();
            statement1.close();
            statement.close();
            con.close();
        } catch (SQLException e){
            System.out.println("Something went wrong " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, count * 60 + 10);
        setLayout(new GridLayout(count + 1, 6));

        String[] headings = {"Name", "Score", "Email", "Password", "Quota", "Course"};
        for (i = 0; i < 6; i++){
            JLabel label = new JLabel(headings[i]);
            label.setFont(new Font("Arial", Font.BOLD, 20));
            add(label);
        }

        for (i = 0; i < count; i++){
            for (int j = 0; j < 6; j++){
                JLabel one = new JLabel(rows[i][j]);
                one.setFont(new Font("Arial", Font.PLAIN, 18));
                add(one);
            }
        }

        setTitle("Admission Status of Students");
        setVisible(true);
    }
}

