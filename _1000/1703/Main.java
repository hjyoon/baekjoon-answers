import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            if(A == 0) {
                break;
            }
            int base = 1;
            for(int i=0; i<A; i++) {
                int splitting_factor = Integer.parseInt(st.nextToken());
                int branch = Integer.parseInt(st.nextToken());
                base *= splitting_factor;
                base -= branch;
            }
            bw.write(base+"");
            bw.newLine();
        }

        bw.flush();
    }
}