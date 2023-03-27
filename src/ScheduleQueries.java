
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jamesbiser
 */
public class ScheduleQueries {
    private static Connection connection;
    private static ArrayList<String> faculty = new ArrayList<String>();
    private static PreparedStatement addScheduleEntry;
    private static PreparedStatement getSchedule;
    private static PreparedStatement getFirstWaitlisted;
    private static PreparedStatement getSeats;
    private static PreparedStatement genericPreparedStatement;
    private static ResultSet resultSet;
    private static ResultSet resultSet3;

    
    public static void addScheduleEntry(ScheduleEntry entry) {
        connection = DBConnection.getConnection();
        try
        {
            addScheduleEntry = connection.prepareStatement("insert into app.schedule values (?,?,?,?,?)");
            addScheduleEntry.setString(1, entry.getSemester());
            addScheduleEntry.setString(3, entry.getCourseCode());
            addScheduleEntry.setString(2, entry.getStudentID());
            addScheduleEntry.setString(4, entry.getStatus());
            addScheduleEntry.setTimestamp(5, entry.getTimeStamp());
            addScheduleEntry.executeUpdate();
            
            
        }
        catch(java.sql.SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
    
    public static int getScheduledStudentCount(String currentSemester, String courseCode){

        int count = 0;
        try {
            getSeats = connection.prepareStatement("select count(studentID) from app.schedule where semester = ? and courseCode = ?" );
            getSeats.setString(1, currentSemester);
            getSeats.setString(2, courseCode);
            resultSet3 = getSeats.executeQuery();
            
            while (resultSet3.next()){
                count = resultSet3.getInt(1);
            }
                
        }
        catch(java.sql.SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return count; 
    } 
    
    public static ArrayList<ScheduleEntry> getScheduleByStudent(String semester, String studentID) {
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> studentSchedule = new ArrayList<ScheduleEntry>();
        try
        {
            getSchedule = connection.prepareStatement("select * from app.schedule where semester = ? and studentID = ?");
            getSchedule.setString(1, semester);
            getSchedule.setString(2, studentID);
            resultSet = getSchedule.executeQuery();
            
            while(resultSet.next())
            {
                String sem = resultSet.getString("semester");
                String id= resultSet.getString("studentID");
                String courseCode = resultSet.getString("courseCode");
                String status = resultSet.getString("status");
                Timestamp timeStamp = resultSet.getTimestamp("timestamp");
                
                studentSchedule.add(new ScheduleEntry(sem, courseCode, id, status, timeStamp));
            }
        }
        catch(java.sql.SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return studentSchedule;
    }
    
    
    public static ArrayList<ScheduleEntry> getWholeScheduleByStudent(String studentID) {
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> studentSchedule = new ArrayList<ScheduleEntry>();
        try
        {
            getSchedule = connection.prepareStatement("select * from app.schedule where studentID = ?");
            getSchedule.setString(1, studentID);
            resultSet = getSchedule.executeQuery();
            
            while(resultSet.next())
            {
                String sem = resultSet.getString("semester");
                String id= resultSet.getString("studentID");
                String courseCode = resultSet.getString("courseCode");
                String status = resultSet.getString("status");
                Timestamp timeStamp = resultSet.getTimestamp("timestamp");
                
                studentSchedule.add(new ScheduleEntry(sem, courseCode, id, status, timeStamp));
            }
        }
        catch(java.sql.SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return studentSchedule;
    }    
    
    public static ArrayList<ScheduleEntry> getScheduleByCourse(String semester, String course) {
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> studentSchedule = new ArrayList<ScheduleEntry>();
        try
        {
            getSchedule = connection.prepareStatement("select * from app.schedule where semester = ? and coursecode = ?");
            getSchedule.setString(1, semester);
            getSchedule.setString(2, course);
            resultSet = getSchedule.executeQuery();
            
            while(resultSet.next())
            {
                String sem = resultSet.getString("semester");
                String id= resultSet.getString("studentID");
                String courseCode = resultSet.getString("courseCode");
                String status = resultSet.getString("status");
                Timestamp timeStamp = resultSet.getTimestamp("timestamp");
                
                studentSchedule.add(new ScheduleEntry(sem, courseCode, id, status, timeStamp));
            }
        }
        catch(java.sql.SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return studentSchedule;
    }
    
    
    
    
    public static void removeCourse(String semester, String course){
        
        connection = DBConnection.getConnection();
        try
        {
            getSchedule = connection.prepareStatement("delete from app.schedule where semester = ? and coursecode = ?");
            getSchedule.setString(1, semester);
            getSchedule.setString(2, course);
            getSchedule.execute();
        }
        catch(java.sql.SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    
    public static ArrayList<ScheduleEntry>  getWaitlisted(String semester, String courseCode){
        ArrayList<ScheduleEntry> studentSchedule = new ArrayList<ScheduleEntry>();
        connection = DBConnection.getConnection();
        try {
            getFirstWaitlisted = connection.prepareStatement("select * from app.schedule where semester = ? and courseCode = ? and status = ? order by timestamp");
            getFirstWaitlisted.setString(1, semester);
            getFirstWaitlisted.setString(2, courseCode);
            getFirstWaitlisted.setString(3,"W");
            resultSet = getFirstWaitlisted.executeQuery();
            while(resultSet.next())
            {
                studentSchedule.add(new ScheduleEntry(semester, courseCode, resultSet.getString("studentID"), resultSet.getString("status"), resultSet.getTimestamp("timestamp")));
                //return ""+resultSet.getString(2);
            }
            
         }catch(java.sql.SQLException sqlException){
            sqlException.printStackTrace();
        }
        return studentSchedule;
    }
    
    public static void dropStudentFromCourse(String semester, String course, String studentID){
        
        connection = DBConnection.getConnection();
        try {
            genericPreparedStatement = connection.prepareStatement("delete from app.schedule where semester = ? and coursecode = ? and studentID = ?");
            genericPreparedStatement.setString(1, semester);
            genericPreparedStatement.setString(2,course);
            genericPreparedStatement.setString(3,studentID);
            genericPreparedStatement.execute();

         }catch(java.sql.SQLException sqlException){
            sqlException.printStackTrace();
        }
        
    }
    
    public static void updateStudentFromWaitlist(String semester, String course, String studentID){
                connection = DBConnection.getConnection();
        try {
            genericPreparedStatement = connection.prepareStatement("update app.schedule set status = ? where semester = ? and courseCode = ? and studentid = ?");
            genericPreparedStatement.setString(1, "S");
            genericPreparedStatement.setString(2, semester);
            genericPreparedStatement.setString(3,course);
            genericPreparedStatement.setString(4,studentID);
            genericPreparedStatement.execute();
         }catch(java.sql.SQLException sqlException){
            sqlException.printStackTrace();
        }
        
        
    }
    
    
}
