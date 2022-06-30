/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.Soundbank;

/**
 *
 * @author MHAE
 */
public class DataBase {

    final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final static String DB_URL = "jdbc:mysql://localhost/collage";
    final static String USER = "root";
    final static String PASSWORD = "";
    Connection connect = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public static String ID = null;
    public Vector<String> M = new Vector<String>();

    public DataBase() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        connect = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        statement = connect.createStatement();
    }

    public String Login(String Id, String Pass) throws SQLException {
        String SQL = "select * from admin where " + "id='" + Id + "' and " + "password='" + Pass + "'";
        resultSet = statement.executeQuery(SQL);
        if (resultSet.next()) {
            ID = Id;
            return "Admin";
        }
        return "Fail";
    }

    public String GetPass(String Id) throws SQLException {
        String SQL = "select * from admin";
        resultSet = statement.executeQuery(SQL);
        String a = null;
        while (resultSet.next()) {
            if (resultSet.getString("id").equals(Id)) {
                a = resultSet.getString("password");
            }
        }
        return a;
    }

    public boolean Valid(String id, String Table) throws SQLException {
        String SQL = "select * from " + Table;
        resultSet = statement.executeQuery(SQL);
        while (resultSet.next()) {
            if (resultSet.getString("id").equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void InsertDegree(String stdID, String Course) throws SQLException {
        String SQL = "INSERT INTO grades ( `sid` , `bid` ) values ('" + stdID + "','" + Course + "')";
        connect.prepareStatement(SQL).executeUpdate();
        System.out.println("Added");

    }

    public void Insert(String Id, String mail, String Password, String name) throws SQLException {
        String SQL = "INSERT INTO admin values ('" + Id + "','" + mail + "','" + Password + "','" + name + "')";
        connect.prepareStatement(SQL).executeUpdate();
        System.out.println("Added");
    }

    public void Insert(String Table, String id, String Fname, String Lname, String Phone, String Class, String GPA) throws SQLException {
        String SQL = "INSERT INTO " + Table + " values (";
        SQL += "'" + id + "', '" + Fname + "', '" + Lname + "', '" + Phone + "', '" + Class + "', '" + GPA + "')";
        connect.prepareStatement(SQL).executeUpdate();
        System.out.println("Added");
    }

    public ResultSet Search(String ID, String Table) throws SQLException {
        String SQL = "select * from " + Table + " where " + "id='" + ID + "'";
        resultSet = statement.executeQuery(SQL);
        return resultSet;
    }

    public void Update(String Table, String A, String B, String C, String I) throws SQLException {
        String SQL = "UPDATE " + Table;
        if (Table == "student") {
            SQL += " set stdPhone=? ,class=?,gpa=? Where id= '" + I + "'";
            preparedStatement = connect.prepareStatement(SQL);
            preparedStatement.setString(1, A);
            preparedStatement.setString(2, B);
            preparedStatement.setString(3, C);
        } else if (Table == "admin") {
            SQL += " set password=? Where id= '" + I + "'";
            preparedStatement = connect.prepareStatement(SQL);
            preparedStatement.setString(1, A);
        } else {
            SQL += " set mid=? ,project=?,final=? Where id= '" + I + "'";
            preparedStatement = connect.prepareStatement(SQL);
            preparedStatement.setString(1, A);
            preparedStatement.setString(2, B);
            preparedStatement.setString(3, C);
        }
        preparedStatement.executeUpdate();
        System.out.println("Updated");
    }

    public void Update(String pass, String id) throws SQLException {
        String SQL = "UPDATE admin set password = " + pass + " where id = '" + id + "'";
        System.out.println(SQL);
        connect.prepareStatement(SQL).executeUpdate();

    }

    public void Delete(String Table, String Id) throws SQLException {
        String SQL = "delete from " + Table + " Where id='" + Id + "'";
        connect.prepareStatement(SQL).executeUpdate();
        System.out.println("Deleted");

    }

    public void GetM(String Id) throws SQLException {
        String SQL = "select * from grades" + " where " + "sid='" + Id + "'";
        resultSet = statement.executeQuery(SQL);
        while (resultSet.next()) {
            if (resultSet.getString("sid").equals(Id)) {
                M.add(resultSet.getString("bid"));
            }
        }
    }

    public void Close() throws SQLException {
        connect.close();
    }
}
