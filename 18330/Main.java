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
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        int limit = 60+K;

        int a = 0;
        int b = 0;

        if(limit > N) {
            a = N;
        }
        else {
            a = limit;
            b = N-limit;
        }

        int res = a*1500 + b*3000;
            
        bw.write(res+"");
        bw.newLine();
        bw.flush();
    }
}