package main;
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Administrator on 2017/3/19 0019.
 */
public class FileNum {

     public static void main(String[] args) throws FileNotFoundException {


         StringBuffer lines = null;

         File outfile = new File("D:/OUT1.txt");
         FileOutputStream fop = new FileOutputStream(outfile);
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fop));
         CarDB car = null;
         Connection conn=ConnPostgres.getConn();
         String sql="select * from cardb1 where vehicleid = '1046193'";
         Statement stmt=null;
         ResultSet rs=null;
         int i = 1;
         try
         {
             stmt=conn.createStatement();
             rs=stmt.executeQuery(sql);
             while(rs.next()){
                 /*
                    private Integer VehicleID;
                    private Double  UtcTime;
                    private Double  Speed;
                    private Double  Angle;
                    private Double TemValue;
                    private Integer RoadID;
                    private Double mmX;
                    private Double mmY;
                    private Integer Type;
                    private Double  PointPos;
                    private String  DigDirect;
                  */
                 car = new CarDB();
                 car.setVehicleID((Integer) rs.getObject(1));
                 car.setUtcTime((Double) rs.getObject(2));
                 car.setSpeed(rs.getDouble(3));
                 car.setAngle(rs.getDouble(4));
                 car.setTemValue(rs.getDouble(5));
                 car.setRoadID(rs.getInt(6));
                 car.setMmX(rs.getDouble(7));
                 car.setMmY(rs.getDouble(8));
                 car.setType(rs.getInt(9));
                 car.setPointPos(rs.getDouble(10));
                 car.setDigDirect(rs.getString(11));
                 lines = new StringBuffer(i++);
                 lines.append(","+car.toString());
                 bw.write(lines.toString());
                 bw.newLine();


                 System.out.println(rs.getInt(1));
             }
         }
         catch (SQLException e)
         {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }


     }
}
