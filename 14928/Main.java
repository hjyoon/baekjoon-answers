import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static String[] s;

	public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

		s = br.readLine().split(" ");

        BigInteger bi = new BigInteger(s[0]);
        BigInteger bi_2 = new BigInteger("20000303");

        bw.write(bi.mod(bi_2) + "\n");

        bw.write(4.5%-3+"");

		bw.flush();
	}
}