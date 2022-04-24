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

        int x1 = Integer.parseInt(s[0]);
        int y1 = Integer.parseInt(s[1]);
        int x2 = Integer.parseInt(s[2]);
        int y2 = Integer.parseInt(s[3]);

        s = br.readLine().split(" ");

        int x3 = Integer.parseInt(s[0]);
        int y3 = Integer.parseInt(s[1]);
        int x4 = Integer.parseInt(s[2]);
        int y4 = Integer.parseInt(s[3]);

        long w = 0;
        long h = 0;

        if(x2 <= x3 || x1 >= x4) {
            w = 0;
        }
        else {
            if(x1 >= x3 && x2 <= x4) {
                w = x2 - x1;
            }
            else if(x1 <= x3 && x2 >= x4) {
                w = x4 - x3;
            }
            else if(x1 <= x3 && x2 <= x4) {
                w = x2 - x3;
            }
            else if(x1 >= x3 && x2 >= x4) {
                w = x4 - x1;
            }
        }


        if(y2 >= y3 || y1 <= y4) {
            h = 0;
        }
        else {
            if(y1 <= y3 && y2 >= y4) {
                h = y1 - y2;
            }
            else if(y1 >= y3 && y2 <= y4) {
                h = y3 - y4;
            }
            else if(y1 >= y3 && y2 >= y4) {
                h = y3 - y2;
            }
            else if(y1 <= y3 && y2 <= y4) {
                h = y1 - y4;
            }
        }

        //bw.write(w+"\n");
        //bw.write(h+"\n");

        bw.write(w*h+"");
		bw.flush();
	}
}