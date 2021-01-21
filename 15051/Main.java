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
        int a1 = Integer.parseInt(s[0]);

        s = br.readLine().split(" ");
        int a2 = Integer.parseInt(s[0]);

        s = br.readLine().split(" ");
        int a3 = Integer.parseInt(s[0]);

        int res1 = a2 * 2 + a3 * 4;
        int res2 = a1 * 2 + a3 * 2;
        int res3 = a1 * 4 + a2 * 2;

        bw.write(Math.min(res1, Math.min(res2, res3))+"");
		bw.flush();
	}
}