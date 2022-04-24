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

        long l = Long.parseLong(s[0]);

        if(l % 2 == 1) {
            bw.write("0");
        }
        else if(l % 4 == 2) {
            bw.write("1");
        }
        else {
            bw.write("2");
        }

		bw.flush();
	}
}