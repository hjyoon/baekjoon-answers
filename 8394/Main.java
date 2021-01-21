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

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int first = 1;
        int second = 2;
        int tmp = 3;

        if(N == 1) {
            bw.write(first + " ");
        }
        else if(N == 2) {
            bw.write(second + " ");
        }
        else if(N == 3) {
            bw.write(tmp + " ");
        }
        else {
            for(int i=4; i<=N; i++) {
                first = second;
                second = tmp;
                tmp = (first + second)%10;
            }
            bw.write(tmp + " ");
        }
        
        bw.flush();
    }
}