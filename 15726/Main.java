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

        double a = Integer.parseInt(s[0]);
        double b = Integer.parseInt(s[1]);
        double c = Integer.parseInt(s[2]);

        double res1 = Math.max(a*b/c, a*(b/c));
        double res2 = Math.max(a/b*c, a/(b*c));
        int res3 = (int)Math.max(res1, res2);

        bw.write(res3+"");
		bw.flush();
	}
}