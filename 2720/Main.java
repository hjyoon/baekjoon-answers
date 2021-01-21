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

        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            int C = Integer.parseInt(br.readLine());
            int q = C/25;
            int d = (C-(25*q))/10;
            int n = (C-(25*q)-(10*d))/5;
            int p = (C-(25*q)-(10*d)-(5*n))/1;
            bw.write(q+" "+d+" "+n+" "+p+" "+"\n");
        }

        bw.flush();
    }
}