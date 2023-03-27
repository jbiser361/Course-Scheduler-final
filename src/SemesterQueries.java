/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author acv
 */
public class SemesterQueries {
    private static Connection connection;
    private static ArrayList<String> faculty = new ArrayList<String>();
    private static PreparedStatement addSemester;
    private static PreparedStatement getSemesterList;
    private static PreparedStatement getSeats;

    private static ResultSet resultSet;
    private static ResultSet resultSet3;

    
    public static void addSemester(String name)
    {
        connection = DBConnection.getConnection();
        try
        {
            addSemester = connection.prepareStatement("insert into app.Semester values (?)");
            addSemester.setString(1, name);
            addSemester.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    
    public static ArrayList<String> getSemesterList()
    {
        connection = DBConnection.getConnection();
        ArrayList<String> semester = new ArrayList<String>();
        try
        {
            getSemesterList = connection.prepareStatement("select Name from app.semester order by Name");
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
     public static int getScheduledStudentCount(String currentSemester, String courseCode){

        int count = 0;
        try {
            getSeats = connection.prepareStatement("select count(studentID) from app.schedule where semester = ? and courseCode = ?");
            getSeats.setString(1, currentSemester);
            getSeats.setString(1, courseCode);
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
    
}
