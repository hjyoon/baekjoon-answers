import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("../input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");

        int min = Math.min(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        int max = Math.max(Integer.parseInt(s[0]), Integer.parseInt(s[1]));

        double res = 0;

        if(min * 3.0 < max) {
            res = min;
        }
        else {
            if(max/3.0 > min/2.0) {
                res = max/3.0;
            }
            else {
                res = min/2.0;
            }
        }

        bw.write(res + "");
        
        bw.flush();
    }
}