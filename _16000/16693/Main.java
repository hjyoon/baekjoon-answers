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

        double a1 = Double.parseDouble(s[0]);
        double p1 = Double.parseDouble(s[1]);

        s = br.readLine().split(" ");

        double r1 = Double.parseDouble(s[0]);
        double p2 = Double.parseDouble(s[1]);

        double res1 = a1/p1;
        double res2 = (r1*r1*Math.PI)/p2;

        bw.write(res1 + "\n");
        bw.write(res2 + "\n");

        if(res1 > res2) {
            bw.write("Slice of pizza");
        }
        else {
            bw.write("Whole pizza");
        }

		bw.flush();
	}
}