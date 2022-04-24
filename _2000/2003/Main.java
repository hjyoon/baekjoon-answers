import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // int sum = 0;
        // int cnt = 0;
        // for(int i=0; i<N; i++) {
        //     for(int j=i; j<N; j++) {
        //         sum += A[j];
        //         if(sum == M) {
        //             cnt++;
        //             break;
        //         }
        //         else if(sum > M) {
        //             break;
        //         }
        //     }
        //     sum = 0;
        // }

        int cnt = 0;
        int r = 0;
        int l = 0;
        int sum = A[0];
        while(r < N) {
            //bw.write(sum+" "+l+" "+r+"\n");
            if(sum < M) {
                r++;
                if(r == N) break;
                sum += A[r];
            }
            else if(sum > M) {
                sum -= A[l];
                l++;
                if(l == N) break;
            }
            else {
                cnt++;
                sum -= A[l];
                l++;
                r++;
                if(l == N || r == N) break;
                sum += A[r];
            }
        }

        bw.write(cnt+"");
        bw.newLine();

        bw.flush();
    }
}