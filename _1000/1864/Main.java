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
            if(s.equals("#")) {
                break;
            }
            int res = 0;
            int len = s.length();
            for(int i=0; i<len; i++) {
                if(s.charAt(i) == '-') {
                    res += Math.pow(8, len-(i+1)) * 0;
                }
                else if(s.charAt(i) == '\\') {
                    res += Math.pow(8, len-(i+1)) * 1;
                }
                else if(s.charAt(i) == '(') {
                    res += Math.pow(8, len-(i+1)) * 2;
                }
                else if(s.charAt(i) == '@') {
                    res += Math.pow(8, len-(i+1)) * 3;
                }
                else if(s.charAt(i) == '?') {
                    res += Math.pow(8, len-(i+1)) * 4;
                }
                else if(s.charAt(i) == '>') {
                    res += Math.pow(8, len-(i+1)) * 5;
                }
                else if(s.charAt(i) == '&') {
                    res += Math.pow(8, len-(i+1)) * 6;
                }
                else if(s.charAt(i) == '%') {
                    res += Math.pow(8, len-(i+1)) * 7;
                }
                else if(s.charAt(i) == '/') {
                    res += Math.pow(8, len-(i+1)) * -1;
                }
            }
            bw.write(res+"\n");
        }

        bw.flush();
    }
}