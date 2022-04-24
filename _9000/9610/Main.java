import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int q1=0, q2=0, q3=0, q4=0, axis=0;
        for(int i=0; i<n; i++) {
            String[] s = br.readLine().split(" ");
            int tmp_x = Integer.parseInt(s[0]);
            int tmp_y = Integer.parseInt(s[1]);

            if(tmp_x == 0 || tmp_y == 0) {
                axis++;
            }
            else if(tmp_x > 0 && tmp_y > 0) {
                q1++;
            }
            else if(tmp_x < 0 && tmp_y > 0) {
                q2++;
            }
            else if(tmp_x < 0 && tmp_y < 0) {
                q3++;
            }
            else if(tmp_x > 0 && tmp_y < 0) {
                q4++;
            }
        }

        bw.write("Q1: "+q1+"\n");
        bw.write("Q2: "+q2+"\n");
        bw.write("Q3: "+q3+"\n");
        bw.write("Q4: "+q4+"\n");
        bw.write("AXIS: "+axis+"\n");

        bw.flush();
    }
}