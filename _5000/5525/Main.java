import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static String s;
    static String[] sa;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //s = br.readLine();
        //sa = s.split(" +");
        int N = Integer.parseInt(br.readLine()); // 1 <= N <= 1,000,000
        int M = Integer.parseInt(br.readLine()); // 2N+1 <= M <= 1,000,000
        s = br.readLine();

        int idx = s.indexOf('I');
        int cnt = 0;
        int tmp_n = 0;
        while(true) {
            if(idx >= M-2 || idx == -1) {
                break;
            }
            if(s.charAt(idx) == 'I' && s.charAt(idx+1) == 'O' && s.charAt(idx+2) == 'I') {
                tmp_n++;
                if(tmp_n == N) {
                    cnt++;
                    tmp_n--;
                }
                idx += 2;
            }
            else {
                idx = s.indexOf('I', idx+1);    // not found : return -1
                //idx++;
                tmp_n = 0;
            }
        }

        bw.write(cnt+"\n");
        bw.flush();
    }
}