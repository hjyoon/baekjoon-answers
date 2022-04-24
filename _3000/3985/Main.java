import java.io.*;
import java.math.*;     
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int[] d = new int[L+1];

        int max = 0;
        int max_idx = 0;
        for(int i=1; i<=N; i++) {
            String[] s = br.readLine().split(" ");
            int p = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);

            if(k-p+1 > max) {
                max = k-p+1;
                max_idx = i;
            }

            for(int j=p; j<=k; j++) {
                if(d[j] == 0) {
                    d[j] = i;
                }
            }
        }

        int max_cnt = 0;
        int max_cnt_idx = 0;
        for(int i=1; i<=L; i++) {
            int tmp = 0;
            for(int j=1; j<=L; j++) {
                if(d[j] == i) {
                    tmp++;
                }
            }
            if(tmp > max_cnt) {
                max_cnt = tmp;
                max_cnt_idx = i;
            }
        }

        bw.write(max_idx+"\n");
        bw.write(max_cnt_idx+"\n");
        bw.flush();
    }
}