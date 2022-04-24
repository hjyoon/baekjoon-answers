import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int f1(int n) {
        if(n == 0) {
            return 0;
        }
        int res = 2;
        for(int i=1; i<=n; i++) {
            res += f2(i-1);
        }
        return res;
    }

    static int f2(int n) {
        if(n == 0) {
            return 0;
        }

        if(n%2==0) {
            return 2;
        }
        else {
            return 5;
        }
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[1000];

        int i=1;
        while(true) {
            int tmp = f1(i);
            if(tmp > 1000) {
                break;
            }
            arr[tmp-1] = true;
            i++;
        }

        String s = (arr[n-1]==true)?"CY":"SK";

        bw.write(s+"");

        bw.flush();
    }
}