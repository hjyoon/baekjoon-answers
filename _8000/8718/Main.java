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

        long x = Integer.parseInt(s[0]) * (long)1000;
        long k = Integer.parseInt(s[1]) * (long)1000;

        long res = 0;

        if(k + k*2 + k*4 <= x) {
            res = k + k*2 + k*4;
        }
        else if(k/2 + k + k*2 <= x) {
            res = k/2 + k + k*2;
        }
        else if(k/4 + k/2 + k <= x) {
            res = k/4 + k/2 + k;
        }
        else {
            res = 0;
        }

        bw.write(res+"");
		bw.flush();
	}
}