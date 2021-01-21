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
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String S = st.nextToken();

        int[] res = new int[N];
        res[0] = 1;
        int max = 1;
        for(int i=1; i<N; i++) {
            if(S.charAt(i) == 'V') {
                res[i] = 1;
            }
            else if(S.charAt(i-1) == 'V') {
                res[i] = 1;
            }
            else if(S.charAt(i-1) == S.charAt(i)) {
                res[i] = 1;
            }
            else {
                res[i] = res[i-1]+1;
            }
            if(res[i] > max) {
                max = res[i];
            }
        }

        // for(int i : res) {
        //     bw.write(i+" ");
        // }
        // bw.newLine();

        bw.write(max+"");
        bw.newLine();

        bw.flush();
    }
}