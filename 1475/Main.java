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

        int N = 0;
        int max = 0;
        int[] arr = new int[10];

        N = Integer.parseInt(st.nextToken());

        while (N > 0) {
            arr[N % 10]++;
            N /= 10;
        }

        for (int i = 0; i < 10; i++) {
            if (i != 6 && i != 9) {
                max = Math.max(max, arr[i]);
            }
        }

        max = Math.max((arr[6] + arr[9] + 1) / 2, max);

        bw.write(max+"");
        bw.flush();
    }
}