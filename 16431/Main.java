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

        int bx = Integer.parseInt(s[0]);
        int by = Integer.parseInt(s[1]);

        s = br.readLine().split(" ");

        int dx = Integer.parseInt(s[0]);
        int dy = Integer.parseInt(s[1]);

        s = br.readLine().split(" ");

        int jx = Integer.parseInt(s[0]);
        int jy = Integer.parseInt(s[1]);

        int res_d = Math.abs(jx-dx) + Math.abs(jy-dy);
        int res_b = Math.min(Math.abs(jx-bx), Math.abs(jy-by)) + Math.abs(Math.abs(jx-bx)-Math.abs(jy-by));

        //bw.write(bx + " " + by + '\n');
        //bw.write(dx + " " + dy + '\n');
        //bw.write(jx + " " + jy + '\n');

        //bw.write("bessie : " + res_b + "\n");
        //bw.write("daisy : " + res_d + "\n");

        if(res_b > res_d) {
            bw.write("daisy");
        }
        else if(res_b < res_d) {
            bw.write("bessie");
        }
        else {
            bw.write("tie");
        }

		bw.flush();
	}
}