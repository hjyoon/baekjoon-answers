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
        
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int tmp_M = (M+1)/2;
        int cnt = 0;
        for(int i=0; i<N; i++) {
            if(A[i] >= tmp_M) break;
            for(int j=i+1; j<N; j++) {
                //bw.write(A[i]+" "+A[j]+"\n");
                if(A[i] + A[j] == M) {
                    //bw.write("++\n");
                    cnt++;
                    break;
                }
                else if(A[i] + A[j] > M) {
                    break;
                }
            }
        }

        // int cnt = 0;
        // int l = 0;
        // int r = 1;
        // while(r < N) {
        //     bw.write(A[l]+" "+A[r]+"\n");
        //     if(A[l]+A[r] < M) {
        //         r++;
        //         if(r == N) break;
        //     }
        //     else if(A[l]+A[r] > M) {
        //         l++;
        //         if(l == N) break;
        //     }
        //     else {
        //         cnt++;
        //         bw.write("++\n");
        //         l++;
        //         r++;
        //         if(l == N || r == N) break;
        //     }
        // }

        bw.write(cnt+"");
        bw.newLine();

        bw.flush();
    }
}