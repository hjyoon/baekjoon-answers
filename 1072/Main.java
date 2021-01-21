import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static String source;
    static String[] s;

    public static void main(String args[]) throws Exception {
    	br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            source = br.readLine();
            if(source == null) {
                break;
            }
            s = source.split(" ");
            long X = Integer.parseInt(s[0]); // 1 <= X <= 1,000,000,000  °ÔÀÓÈ½¼ö
            long Y = Integer.parseInt(s[1]); // 0 <= Y <= X  ÀÌ±ä°ÔÀÓ
            long Z = (long)((double)Y * 100.0) / X;	// ½Â·ü
            if(Z >= 99) {
                bw.write("-1\n");
                bw.flush();
            }
            else {
                long start = 0;
                long end = X;
                long res = 0;
                long tmp_Z = 0;
                //bw.write("Z=" + Z + "\n");
                while(true) {
                    long c = (start+end)/2;
                    tmp_Z = (long)(((double)Y+c) * 100.0) / (X+c);
                    //bw.write("start=" + start + "  end=" + end + "  c=" + c + "  z=" + tmp_Z + "\n");
                    if(start > end) {
                        break;
                    }
                    if(Z > tmp_Z) {
                        start = c+1;
                    }
                    else if(Z == tmp_Z) {
                        start = c+1;
                    }
                    else if(Z < tmp_Z) {
                        end = c-1;
                        res = c;
                    }
                    bw.flush();
                }
                bw.write(res + "\n");
            }
        }

		bw.flush();
    }
}