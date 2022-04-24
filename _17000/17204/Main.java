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
        int K = Integer.parseInt(s[1]);

        int[] arr = new int[N];
        boolean[] chk = new boolean[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int res = 0;
        int pos = 0;
        while(true) {
            if(chk[pos] == true) {
                res = -1;
                break;
            }
            chk[pos] = true;
            pos = arr[pos];
            res++;
            if(pos == K) {
                break;
            }
        }

        bw.write(res+"");
        bw.flush();
    }
}