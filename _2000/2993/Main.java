import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static String reverseArrayString(String s) {
        String tmp = "";
        int len = s.length();
        for(int i=0; i<len; i++) {
            tmp += s.charAt(len-1-i);
        }
        return tmp;
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int len = s.length();

        String[] ss = new String[3];
        //bw.write(len+"\n");

        //int first=0;
        //int second=0;

        //char tmp = s.charAt(0);

        String s1 = new String(s);
        for(int i=0; i<len-2; i++) {
            for(int j=i+1; j<len-1; j++) {
                String tmp1 = s.substring(0, i+1);
                String tmp2 = s.substring(i+1, j+1);
                String tmp3 = s.substring(j+1, len);
                String tmp5 = reverseArrayString(tmp1) + reverseArrayString(tmp2) + reverseArrayString(tmp3);

                if(s1.compareTo(tmp5) > 0) {
                    s1 = new String(tmp5);
                }
            }
        }

        // if("ABC".compareTo("DEF") < 0) {
        //     bw.write("aaaaa");
        // }

        bw.write(s1+"\n");

        bw.flush();
    }
}