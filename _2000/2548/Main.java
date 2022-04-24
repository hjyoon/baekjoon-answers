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

        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(arr);

        int res = 0;
        if(N%2==1) {
            res = N/2;
        }
        else {
            res = N/2-1;
        }

        bw.write(arr[res]+"");
        bw.flush();
    }
}