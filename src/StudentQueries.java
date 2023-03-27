
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jamesbiser
 */
public class StudentQueries {
    private static Connection connection;
    private static ArrayList<String> faculty = new ArrayList<String>();
    private static PreparedStatement addStudent;
    private static PreparedStatement getSemesterList;
    private static PreparedStatement getSchedule;
    private static PreparedStatement genericPreparedStatement;
    

    private static ResultSet resultSet;
    
    public static void addStudent(String firstName, String lastName, String studentID){
        connection = DBConnection.getConnection();
        try {
            addStudent = connection.prepareStatement("insert into app.Student values (?,?,?)");
            addStudent.setString(1, studentID);
            addStudent.setString(2, firstName);
            addStudent.setString(3, lastName);
            addStudent.executeUpdate();
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        
    }
    public static ArrayList<String> getStudentIDList(){
        connection = DBConnection.getConnection();
        ArrayList<String> semester = new ArrayList<String>();
        try
        {
            getSemesterList = connection.prepareStatement("select studentID from app.student order by studentID");
            resultSet = getSemesterList.executeQuery();
            
            while(resultSet.next())
            {
                semester.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return semester;
        
    }
    
    public static String getStudentName(String studentID){
        String cool = "";
        try
        {
            genericPreparedStatement = connection.prepareStatement("select firstname, lastname from app.student where studentid = ?");
            genericPreparedStatement.setString(1, studentID);
            resultSet = genericPreparedStatement.executeQuery();
           
                //xssemester.add(resultSet.getString(1));
            while(resultSet.next())
            {
                cool =  resultSet.getString(2)+", "+resultSet.getString(1);
            }            

        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return cool;
    }
    
    public static void dropStudent(String studentID){
        connection = DBConnection.getConnection();
        try
        {
            genericPreparedStatement = connection.prepareStatement("delete from app.student where studentid = ?");
            genericPreparedStatement.setString(1, studentID);
            genericPreparedStatement.execute();
            
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }        
    }

}
