import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    //static String[] s;

    public static void main(String args[]) throws Exception {
    	br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String s = br.readLine();
            boolean chk = false;
            if(s.equals("0")) {
                break;
            }

            int len = s.length() - 1;
            int end = len / 2;

            for(int i=0; i<=end; i++) {
                if(s.charAt(i) != s.charAt(len-i)) {
                    bw.write("no\n");
                    chk = true;
                    break;
                }
            }
            if(chk == false) {
                bw.write("yes\n");
            }
        }

		bw.flush();
    }
}