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

        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            int n = Integer.parseInt(br.readLine());
            int p1 = 0, p2 = 0;
            for(int i=0; i<n; i++) {
                String[] s = br.readLine().split(" ");
                if(s[0].equals("R")) {
                    if(s[1].equals("S")) {
                        p1++;
                    }
                    else if(s[1].equals("P")) {
                        p2++;
                    }
                    else {
                        ;
                    }
                }
                else if(s[0].equals("S")) {
                    if(s[1].equals("R")) {
                        p2++;
                    }
                    else if(s[1].equals("P")) {
                        p1++;
                    }
                    else {
                        ;
                    }
                }
                else {
                    if(s[1].equals("R")) {
                        p1++;
                    }
                    else if(s[1].equals("S")) {
                        p2++;
                    }
                    else {
                        ;
                    }
                }
            }
            if(p1 > p2) {
                bw.write("Player 1\n");
            }
            else if(p1 < p2) {
                bw.write("Player 2\n");
            }
            else {
                bw.write("TIE\n");
            }
        }
        
        bw.flush();
    }
}