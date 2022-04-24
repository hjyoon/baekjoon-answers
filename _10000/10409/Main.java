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
        int n = Integer.parseInt(s[0]);
        int T = Integer.parseInt(s[1]);

        s = br.readLine().split(" ");
        
        int res = 0;
        for(int i=0; i<n; i++) {
            int tmp = Integer.parseInt(s[i]);
            T -= tmp;
            if(T < 0) {
                break;
            }
            res++;
        }

        bw.write(res+"");

        bw.flush();
    }
}