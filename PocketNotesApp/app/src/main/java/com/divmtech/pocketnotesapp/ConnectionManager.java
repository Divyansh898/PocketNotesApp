package com.divmtech.pocketnotesapp;
import android.os.StrictMode;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
    String IP, DB, DBUSERNAME, DBPASSWORD;

    public Connection getConnection() {

        IP = "den1.mssql8.gear.host";
        DB = "divyanshdb";
        DBUSERNAME = "divyanshdb";
        DBPASSWORD = "div@123";
        Connection con = null;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            DriverManager.setLoginTimeout(5000);
            con = DriverManager.getConnection("jdbc:jtds:sqlserver://" + IP + ";databasename=" + DB + ";user=" + DBUSERNAME + ";password=" + DBPASSWORD + ";");

        } catch (Exception ex) {

        }


        return con;
    }
    public boolean ExecuteQuery(String command)
    {
        try {
            PreparedStatement ps=getConnection().prepareStatement(command);
            return ps.executeUpdate()>0?true:false;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    public ResultSet selectData(String command)
    {
        try
        {
           PreparedStatement ps=getConnection().prepareStatement(command);
           return ps.executeQuery();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }


}
