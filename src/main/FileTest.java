package main;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/14 0014.
 */
public class FileTest {
    public static void main(String[] args) {
        String path = "F:\\Traj_10000.txt";
        StringBuffer lines = null;
        Map<String,StringBuffer> map = new HashMap<String, StringBuffer>();
        Map<String,Integer> map_num = new HashMap<String, Integer>();



        try {
            File file = new File(path);
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(file));
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String [] line_arr ;
            String line ;

            while ((line =br.readLine())!= null) {
                line_arr= line.split(",");

                String car_id = line_arr[0];
                String newstr = null;


                System.out.println("("+line_arr[5]+line_arr[9]+" "+line_arr[1]+")");

                if(map.containsKey(car_id)) {

                        if(map_num.get(car_id)%2==0){
                            newstr = "("+line_arr[5]+line_arr[9]+" "+line_arr[1]+",";
                            lines = map.get(car_id).append(newstr);
                        } else {
                            newstr =line_arr[5]+line_arr[9]+" "+line_arr[1]+"),";
                            lines = map.get(car_id).append(newstr);
                        }
                    int j = map_num.get(car_id)+1;
                    map.put(car_id,lines);
                    map_num.put(car_id,j);

                } else {
                    lines = new StringBuffer("\"MULTILINESTRING (");
                    newstr = "("+line_arr[5]+line_arr[9]+" "+line_arr[1]+",";
                    lines = lines.append(newstr);
                    map.put(car_id,lines);
                    map_num.put(car_id,1);
                }
            }

            List<String> num1 = new ArrayList<String>();  /*  存储数据中只有一个轨迹记录点的车的集合*/

            for(Map.Entry<String, StringBuffer> entry : map.entrySet()) {
                StringBuffer rep = new StringBuffer(entry.getValue());

                System.out.println(entry.getKey());
                System.out.println(map_num.get(entry.getKey()));
                int i = map_num.get(entry.getKey());
                if (i==1) {

                    num1.add(entry.getKey());  /*将数据中只有一个轨迹点的车辆的id放入集合*/
                    continue;
                }
                if(i%2==0) {
                    rep.setCharAt(rep.length()-1,')');
                    rep.append("\"");
                    map.put(entry.getKey(),rep);
                } else {
                   // System.out.println(map_num.get("1046529"));
                    int n = rep.lastIndexOf(")");
                    rep.deleteCharAt(n);

                    n = rep.lastIndexOf("(");
                    rep.deleteCharAt(n);
                    rep.setCharAt(rep.length()-1,')');
                    rep.append(")\"");
                    map.put(entry.getKey(),rep);
                    }



            }


            for(String numm:num1) {
                map.remove(numm);    //删除map中存储的轨迹只有一个点的数据
            }


            File outfile = new File("D:/OUT3.txt");
            FileOutputStream fop = new FileOutputStream(outfile);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fop));

            for(Map.Entry<String, StringBuffer> entry : map.entrySet()) {
                StringBuffer outline = entry.getValue();
                String yyy = outline.toString();
                bw.write(yyy);
                bw.newLine();

            }

           bw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}
