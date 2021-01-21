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

        if(bi.remainder(new BigInteger("3")).compareTo(new BigInteger("0")) == 0) {
            bw.write("0");
        }
        else if(bi.remainder(new BigInteger("3")).compareTo(new BigInteger("1")) == 0) {
            bw.write("1");
        }
        else if(bi.remainder(new BigInteger("3")).compareTo(new BigInteger("2")) == 0) {
            bw.write("2");
        }

		bw.flush();
	}
}