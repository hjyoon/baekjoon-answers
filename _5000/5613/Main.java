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

        int res = Integer.parseInt(br.readLine());
        while(true) {
            String op = br.readLine();
            if(op.equals("=")) {
                break;
            }
            if(op.equals("+")) {
                res += Integer.parseInt(br.readLine());
            }
            else if(op.equals("-")) {
                res -= Integer.parseInt(br.readLine());
            }
            else if(op.equals("*")) {
                res *= Integer.parseInt(br.readLine());
            }
            else {
                res /= Integer.parseInt(br.readLine());
            }
        }

        bw.write(res+"");

        bw.flush();
    }
}