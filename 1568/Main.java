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

        int N = Integer.parseInt(br.readLine());

        int sub = 1;
        int t = 0;
        while(true) {
            if(N == 0) {
                break;
            }
            else if(N < sub) {
                sub = 1;
            }
            N -= sub;
            sub++;
            t++;
        }

        bw.write(t+"");
        bw.flush();
    }
}