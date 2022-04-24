import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.*;
import java.util.Map.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String A = br.readLine();
            String B = br.readLine();

            A = A.substring(2);
            B = B.substring(2);

            A = A.replaceAll(" ", "");
            B = B.replaceAll(" ", "");

            char[] tmp_A = A.toCharArray();
            char[] tmp_B = B.toCharArray();

            Arrays.sort(tmp_A);
            Arrays.sort(tmp_B);

            StringBuilder sb_A = new StringBuilder(String.valueOf(tmp_A));
            StringBuilder sb_B = new StringBuilder(String.valueOf(tmp_B));

            sb_A = sb_A.reverse();
            sb_B = sb_B.reverse();

            A = sb_A.toString();
            B = sb_B.toString();

            int min = Math.min(A.length(), B.length());

            String n_A = A.substring(0, min);
            String n_B = B.substring(0, min);

            // bw.write(n_A+"\n");
            // bw.write(n_B+"\n");
            // bw.write(A+"\n");
            // bw.write(B+"\n");
            if(n_A.compareTo(n_B) == 0) {
                if(A.length() > B.length()) {
                    bw.write("A\n");
                }
                else if(A.length() < B.length()){
                    bw.write("B\n");
                }
                else {
                    bw.write("D\n");
                }
            }
            else {
                if(n_A.compareTo(n_B) > 0) {
                    bw.write("A\n");
                }
                else if(n_A.compareTo(n_B) < 0){
                    bw.write("B\n");
                }
                else {
                    bw.write("D\n");
                }
            }
        }

        bw.flush();
    }
}