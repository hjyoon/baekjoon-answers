import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String s = br.readLine();
            if(s.equals("0")) {
                break;
            }
            while(true) {
                int len = s.length();
                if(len == 1) {
                    break;
                }
                int sum = 0;
                for(int i=0; i<len; i++) {
                    sum += Integer.parseInt(s.charAt(i)+"");
                }
                s = sum+"";
            }
            bw.write(s+"\n");
        }

        bw.flush();
    }
}