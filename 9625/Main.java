import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static BufferedReader br;
    //static BufferedReader br;
    static BufferedWriter bw;

    static int K = 0;
    static ArrayList<String[]> al = new ArrayList<>();

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());

        int a=1, b=0;

        for(int i=0; i<K; i++) {
            int tmp = b;
            b += a;
            a = tmp;
        }

        bw.write(a+" "+b);

        bw.flush();
    }
}