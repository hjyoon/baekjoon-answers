import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        double per_minute = 0;
        if(p >= 20) {
            per_minute = (double)(100-p)/t;
        } 
        else {
            per_minute = (double)(80+(100-p-80)*2)/t;
        }

        int a = 0;
        int b = 0;
        if(p-20 > 0) {
            a = p-20;
            b = 20;
        }
        else {
            a = 0;
            b = p;
        }

        double ans = a/per_minute + b/(per_minute/2);
        bw.write(ans+"");
        bw.newLine();

        bw.flush();
    }
}