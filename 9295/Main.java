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

        int n = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++) {
            String[] s = br.readLine().split(" ");
            int sum = Integer.parseInt(s[0]) + Integer.parseInt(s[1]);
            bw.write("Case "+i+": "+sum+"\n");
        }
        bw.flush();
    }
}