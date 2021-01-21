import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[] arr = new int[N];
        int max = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        int start = max;
        int end = 1000000000;
        int mid = (start + end) / 2;
        while(true) {
            mid = (start + end) / 2;
            if(start >= end) {
                break;
            }

            int current = 0;
            int cnt = 0;
            for(int i=0; i<N; i++) {
                if(arr[i] > current) {
                    cnt++;
                    current = mid;
                }
                current -= arr[i];
            }

            //bw.write("start : " + start + "\n");
            //bw.write("mid : " + mid + "\n");
            //bw.write("end : " + end + "\n\n");

            if(cnt > M) {
                start = mid+1;
            }
            else if(cnt < M) {
                end = mid;
            }
            else {
                end = mid;
            }
        }

        bw.write(mid+"");
        bw.flush();
    }
}