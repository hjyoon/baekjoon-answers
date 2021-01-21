import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.*;
import java.util.Map.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr_A = new int[501];
        int[] arr_B = new int[501];

        for(int i=1; i<=500; i++) {
            arr_A[i] = arr_B[i] = i*i;
        }

        int cnt = 0;
        for(int i=1; i<=500; i++) {
            for(int j=1; j<i; j++) {
                if(arr_B[j] + N == arr_A[i]) {
                    cnt++;
                }
            }
        }

        bw.write(cnt+"");
        bw.flush();
    }
}