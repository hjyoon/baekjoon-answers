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

        int res = 0;
        int start = 1;
        int end = 1;
        int sum = 1;
        while(end <= N) {
            if(sum < N) {
                start++;
                sum += start;
            }
            else if(sum > N) {
                sum -= end;
                end++;
            }
            else {
                res++;
                sum -= end;
                end++;
                start++;
                sum += start;
            }
        }

        bw.write(res+"");
        bw.newLine();

        bw.flush();
    }
}