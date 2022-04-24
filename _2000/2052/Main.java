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

        //String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(br.readLine());

        BigDecimal res = new BigDecimal(0.5);
        res = res.pow(N);

        bw.write(res.toPlainString()+"");
        bw.flush();
    }
}