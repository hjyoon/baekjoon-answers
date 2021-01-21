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

        BigInteger A = new BigInteger(br.readLine());
        String op = br.readLine();
        BigInteger B = new BigInteger(br.readLine());

        BigInteger res = BigInteger.ZERO;
        if(op.equals("+")) {
            res = A.add(B);
        }
        else {
            res = A.multiply(B);
        }

        bw.write(res+"");
        bw.flush();
    }
}