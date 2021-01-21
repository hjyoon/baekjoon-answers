import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static int solve(long start, long end, int cnt) throws Exception {
        //bw.write(start+" "+end+"\n");
        if(start > end) {
            //bw.write("out!!\n");
            return -1;
        }
        else if(start == end) {
            //bw.write("catch!!\n");
            return cnt;
        }
        
        int res = solve(start*2, end, cnt+1);
        if(res != -1) {
            return res;
        }

        res = solve(start*10+1, end, cnt+1);
        if(res != -1) {
            return res;
        }
        else {
            return -1;
        }
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int res = solve(A, B, 1);

        bw.write(res+"\n");
        bw.flush();
    }
}