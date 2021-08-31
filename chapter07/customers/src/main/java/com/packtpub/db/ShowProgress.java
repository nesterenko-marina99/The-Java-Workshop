package com.packtpub.db;

import java.sql.*;

public class ShowProgress {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Please, enter first name and last name.");
            System.exit(-1);
        }
        String firstName = args[0];
        String lastName = args[1];
        Connection conn = null;
        PreparedStatement statement = null;
        String sql = "SELECT chapter.chapter_id, title, chapter_completed "
                + "FROM student, chapter, student_progress " +
                "WHERE first_name = ? " +
                "AND last_name = ? " +
                "AND student.student_id = student_progress.student_id " +
                "AND chapter.chapter_id = student_progress.chapter_id " +
                " order by chapter_id";
        try {
            conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            statement = conn.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            ResultSet result = statement.executeQuery();
            System.out.println(firstName.toUpperCase() + " " +
                    lastName.toUpperCase());
            while (result.next()) {
                Date date = result.getDate("chapter_completed");
                int chapterId = result.getInt("chapter_id");
                String title = result.getString("title");
                System.out.println(date.toString() + " " + chapterId +
                        " " + title);
            }
             if (result != null)
                 result.close();
            if (statement != null)
                statement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
                conn.close();
            } catch (SQLException nested) {
                nested.printStackTrace();
            }
        }
    }
}
