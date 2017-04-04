package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/3/19 0019.
 */
public class ConnPostgres {

    public static Connection getConn()
    {
        Connection conn = null;
        try
        {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://101.200.55.200:5432/spatialdb";
            try
            {
                conn = DriverManager.getConnection(url, "postgres", "postgres");
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        return conn;
    }
}
