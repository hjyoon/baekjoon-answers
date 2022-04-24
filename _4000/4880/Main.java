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

        while(true) {
            String ss = br.readLine();
            if(ss.equals("0 0 0")) {
                break;
            }

            String[] s = ss.split(" ");

            int[] arr = new int[3];
            arr[0] = Integer.parseInt(s[0]);
            arr[1] = Integer.parseInt(s[1]);
            arr[2] = Integer.parseInt(s[2]);

            int a = arr[1] - arr[0];
            
            if(arr[1] + a == arr[2]) {
                bw.write("AP "+(arr[2]+a)+"\n");
            }
            else {
                int b = arr[1] / arr[0];
                bw.write("GP "+(arr[2]*b)+"\n");
            }
        }
        bw.flush();
    }
}