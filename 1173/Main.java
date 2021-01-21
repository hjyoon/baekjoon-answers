import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
import java.time.*;

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
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int res_time = 0;
        int now_pulse = m;
        int work_cnt = 0;

        if(m+T > M) {
            bw.write("-1");
            bw.newLine();
            bw.flush();
            return;
        }

        while(true) {
            res_time++;

            if(now_pulse < m) {
                now_pulse = m;
            }

            if(now_pulse+T > M) {
                now_pulse -= R;
                bw.write(res_time+" "+now_pulse+"\n");
                continue;
            }

            now_pulse += T;
            work_cnt++;

            bw.write(res_time+" "+now_pulse+" "+work_cnt+"\n");

            if(work_cnt == N) {
                break;
            }
        }

        bw.write(res_time+"");
        bw.newLine();
        bw.flush();
    }
}