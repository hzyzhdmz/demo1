package main;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/20 0020.
 */
public class FileCreate {
    public static void main(String[] args) {

        String path = "F:\\ShenZhen_FCD_MM_100.txt";
        //StringBuffer lines = null;
        Map<Integer,String> map = new LinkedHashMap<Integer, String>();
        int i = 1;


        try {
            File file = new File(path);
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(file));
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line ;

            while ((line =br.readLine())!= null) {
                line = ","+line;
                map.put(i++,line);
            }

            File outfile = new File("D:/OUT1.txt");
            FileOutputStream fop = new FileOutputStream(outfile);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fop));

            for(Map.Entry<Integer, String> entry : map.entrySet()) {
                String outline = entry.getValue();
                //  byte[] contentInBytes = outline.toString().getBytes();
                String yyy = entry.getKey().toString()+outline;
                bw.write(yyy);
                bw.newLine();

            }

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
