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

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] chk = new int[M+1];

        for(int i=0; i<M; i++) {
            chk[i] = Integer.parseInt(br.readLine());
        }
        chk[M] = N+1;

        int[] fibo = new int[41];
        fibo[1] = 1;
        fibo[2] = 2;

        for(int i=3; i<41; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
        }

        ArrayList<Integer> al = new  ArrayList<>();

        int pos = 0;
        for(int tmp : chk) {
            if(tmp-pos-1 > 0) {
                al.add(fibo[tmp-pos-1]);
            }
            pos = tmp;
        }

        int res = 1;
        for(int tmp : al) {
            res *= tmp;
        }

        bw.write(res+"");
        bw.flush();
    }
}