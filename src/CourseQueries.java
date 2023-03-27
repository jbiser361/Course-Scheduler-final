
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
public class CourseQueries {
    private static Connection connection;
    private static PreparedStatement addCourse;
    private static PreparedStatement getAllCourseCodes;
    private static PreparedStatement getSeats;
    private static ResultSet resultSet2;
    private static ResultSet resultSet3;
    
    
    public static void addCourse(String semester, String name, String description, int maxSeats)
    {
        connection = DBConnection.getConnection();
        try
        {
            addCourse = connection.prepareStatement("insert into app.Course values (?,?,?,?)");
            addCourse.setString(1, semester);
            addCourse.setString(2, name);
            addCourse.setString(3, description);
            addCourse.setInt(4, maxSeats);
            addCourse.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }

    public static ArrayList<CourseEntry> getAllCourses(String semester)
    {
       connection = DBConnection.getConnection();
        ArrayList<CourseEntry> courses = new ArrayList<CourseEntry>();
       
        try
        {
            getAllCourseCodes = connection.prepareStatement("select * from app.Course where semester = ?" );
            getAllCourseCodes.setString(1, semester);
            
           resultSet2 = getAllCourseCodes.executeQuery();
            
            while(resultSet2.next())
            {
                String sem = resultSet2.getString("semester");
                String courseCode = resultSet2.getString("coursecode");
                String des = resultSet2.getString("description");
                int seats = resultSet2.getInt("seats");
                courses.add(new CourseEntry(sem, courseCode, des, seats));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return courses;
    }
    
    public static int getCourseSeats(String currentSemester, String courseCode){

        int count = 0;
        try {
            getSeats = connection.prepareStatement("select * from app.course where semester = ? and courseCode = ?");
            getSeats.setString(1, currentSemester);
            getSeats.setString(2, courseCode);
            resultSet3 = getSeats.executeQuery();
            while (resultSet3.next()){
                count = resultSet3.getInt(4);
            }
                
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return count; 
    }
    
    
    public static void dropCourse(String currentSemester, String courseCode){
        
        try {
            getSeats = connection.prepareStatement("delete from app.course where semester = ? and coursecode = ?");
            getSeats.setString(1, currentSemester);
            getSeats.setString(2, courseCode);
            getSeats.execute();
                
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
    
}
