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

        String s = br.readLine();

        if(s.charAt(0) == 'A') {
            if(s.charAt(1) == '+') {
                bw.write("4.3");
            }
            else if(s.charAt(1) == '0') {
                bw.write("4.0");
            }
            else {
                bw.write("3.7");
            }
        }
        else if(s.charAt(0) == 'B') {
            if(s.charAt(1) == '+') {
                bw.write("3.3");
            }
            else if(s.charAt(1) == '0') {
                bw.write("3.0");
            }
            else {
                bw.write("2.7");
            }
        }
        else if(s.charAt(0) == 'C') {
            if(s.charAt(1) == '+') {
                bw.write("2.3");
            }
            else if(s.charAt(1) == '0') {
                bw.write("2.0");
            }
            else {
                bw.write("1.7");
            }
        }
        else if(s.charAt(0) == 'D') {
            if(s.charAt(1) == '+') {
                bw.write("1.3");
            }
            else if(s.charAt(1) == '0') {
                bw.write("1.0");
            }
            else {
                bw.write("0.7");
            }
        }
        else {
            bw.write("0.0");
        }

        bw.flush();
    }
}