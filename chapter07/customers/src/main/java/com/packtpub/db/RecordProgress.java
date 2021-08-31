package com.packtpub.db;

import java.sql.*;

public class RecordProgress {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Please, enter first name, last name and first last chapter.");
            System.exit(-1);
        }
        String firstName = args[0];
        String lastName = args[1];
        Integer chapter = Integer.parseInt(args[2]);
        RecordProgress recordProgress = new RecordProgress();
        recordProgress.storeStudentProgress(firstName, lastName, chapter);
    }

    public Long getStudentId(Connection conn, String firstName, String lastName)
            throws SQLException {
        Long studentId = 1L;
        PreparedStatement statement = null;
        String findStudent = "SELECT student_id FROM student WHERE " +
                "first_name = ? AND last_name = ?";
        statement = conn.prepareStatement(findStudent);
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            studentId = result.getLong(1);
        }
        return studentId;
    }

    public void storeStudentProgress(String firstName, String lastName, Integer chapter) {
        Connection conn = null;
        PreparedStatement statement = null;
        String insertProgress = "INSERT INTO student_progress" +
                "(STUDENT_ID, chapter_id, chapter_completed)" +
                "VALUES (?, ?, CURRENT_DATE);";
        try {
            conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            statement = conn.prepareStatement(insertProgress);
            Long studentId = getStudentId(conn, firstName, lastName);
            statement.setLong(1, studentId);
            statement.setInt(2, chapter);
            int rowsInserted = statement.executeUpdate();
            System.out.println("Number rows inserted: " + rowsInserted);
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
