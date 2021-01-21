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

        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int L = Integer.parseInt(s[1]);
        int D = Integer.parseInt(s[2]);

        boolean[] b = new boolean[1005001];

        int cnt = 0;
        int of = 0;
        while(true) {
            for(int i=0; i<L; i++) {
                b[of++] = true;
            }
            of += 5;
            cnt++;
            if(cnt == N) {
                break;
            }
        }

        int res = 0;
        while(true) {
            if(b[res] == false) {
                break;
            }
            res += D;
        }

        bw.write(res+" ");
        bw.flush();
    }
}