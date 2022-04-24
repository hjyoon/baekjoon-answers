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

        int A = Integer.parseInt(br.readLine());

        int res = 0;

        while(true) {
            if(A != 1 && A%2 == 1) {
                bw.write("0");
                break;
            }

            A /= 2;

            if(A == 0) {
                bw.write("1");
                break;
            }
        }

        bw.flush();
    }
}