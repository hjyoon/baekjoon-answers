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

        while(true) {
            String s = br.readLine();
            if(s.equals("0")) {
                break;
            }
            String[] ss = s.split(" ");
            int N = Integer.parseInt(ss[0]);
            int P = Integer.parseInt(ss[1]);

            int pages = N/4;
            int[] res = new int[3];

            if(P%2 == 0) {
                res[0] = P-1;
                res[1] = N+1-res[0];
                res[2] = N+1-P;
            }
            else {
                res[0] = P+1;
                res[1] = N+1-res[0];
                res[2] = N+1-P;
            }

            Arrays.sort(res);
            for(int i : res) {
                bw.write(i+" ");
            }
            bw.write("\n");
        }

        bw.flush();
    }
}