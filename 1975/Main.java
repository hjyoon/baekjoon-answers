import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int f(int n, int b) {
        int cnt = 0;
        while(true) {
            if(n % b == 0) {
                n /= b;
                cnt++;
            }
            else {
                break;
            }
        }
        return cnt;
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //String[] s = br.readLine().split(" ");
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        for(int i=1; i<=1000; i++) {
            for(int j=2; j<=i; j++) {
               arr[i] += f(i, j);
            }
        }

        while(T-->0) {
            int tmp = Integer.parseInt(br.readLine());
            bw.write(arr[tmp]+"\n");
        }

        bw.flush();
    }
}