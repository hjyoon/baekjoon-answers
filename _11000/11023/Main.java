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
        int len = s.length;
        int sum = 0;
        for(int i=0; i<len; i++) {
            sum += Integer.parseInt(s[i]);
        }

        bw.write(sum+"\n");

        bw.flush();
    }
}