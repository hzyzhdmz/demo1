package main;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/27 0027.
 */
public class FileExam {
    public static void main(String[] args) {
        File file =new File("D:/OUT3.txt");
        StringBuffer lines = null;
        Map<Integer,String> map = new HashMap<Integer, String>();
        int i= 1;
        //String regs = "\\b\\)\\)\"\\b";

        try {
            InputStreamReader reader = reader = new InputStreamReader(
                    new FileInputStream(file));
            BufferedReader br = new BufferedReader(reader);

            String line ;

            while ((line =br.readLine())!= null) {
                lines = new StringBuffer(line);

                if(lines.toString().indexOf("))\"")==-1){
                    map.put(i,line);

                }
                i++;

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(" ");


    }
}
