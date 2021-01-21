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
            String ss = br.readLine();
            if(ss.equals("0 0")) {
                break;
            }
            String[] s = ss.split(" ");
            int cnt = 0;
            int carry = 0;

            int i = s[0].length()-1;
            int j = s[1].length()-1;
            while(true) {
                if(i<0 && j<0) {
                    break;
                }
                else if(i>=0 && j>=0) {
                    if(s[0].charAt(i)-'0' + s[1].charAt(j)-'0' + carry >= 10) {
                        cnt++;
                        carry = 1;
                    }
                    else {
                        carry = 0;
                    }
                    i--;
                    j--;
                }
                else if(i>=0) {
                    if(s[0].charAt(i)-'0' + carry >= 10) {
                        cnt++;
                        carry = 1;
                    }
                    else {
                        carry = 0;
                    }
                    i--;
                }
                else {
                    if(s[1].charAt(j)-'0' + carry >= 10) {
                        cnt++;
                        carry = 1;
                    }
                    else {
                        carry = 0;
                    }
                    j--;
                }
            }

            bw.write(cnt+"\n");
        }

        bw.flush();
    }
}