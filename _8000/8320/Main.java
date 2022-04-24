import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int cal(int n) {
        int res = 0;
        int limit = (int)Math.sqrt(n);
        for(int i=1; i<=limit; i++) {
            if(n%i==0) {
                res++;
            }
        }
        return res;
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        for(int i=1; i<=n; i++) {
            int tmp = cal(i);
            sum += tmp;
        }

        bw.write(sum+"");
        bw.flush();
    }
}