import java.util.*;
import java.io.*;
import java.math.*;

public class Main_2 {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long sum = (N*(N+1))/2;

        for(int i=0; i<N; i++) {
            sum -= Long.parseLong(br.readLine());
        }

        sum = Math.abs(sum);

        // int[] arr = new int[N];
        // for(int i=0; i<N; i++) {
        //     arr[i] = Integer.parseInt(br.readLine());
        // }

        // Arrays.sort(arr);

        // long sum = 0;
        // for(int i=0; i<N; i++) {
        //     sum += Math.abs((i+1)-arr[i]);
        // }

        bw.write(sum+" ");
        bw.flush();
    }
}