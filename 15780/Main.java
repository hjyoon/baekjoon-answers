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

        s = br.readLine().split(" ");
        int sum = 0;
        for(int i=0; i<K; i++) {
            int tmp = Integer.parseInt(s[i]);
            sum += (tmp+1)/2;
        }

        if(N <= sum) {
            bw.write("YES");
        }
        else {
            bw.write("NO");
        }

        bw.flush();
    }
}