import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int k(int m) throws Exception {
        int first = 0;
        int second = 1;
        int tmp = first + second;
        int cnt = 0;
        while(true) {
            first = second;
            second = tmp;
            tmp = (first + second)%m;
            cnt++;
            if(first == 0 && second == 1) {
                break;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int res = k(M);
            bw.write(N + " " + res);
            bw.newLine();
        }

        bw.flush();
    }
}