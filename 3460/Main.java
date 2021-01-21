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

            int i=1, cnt=0;
            while(true) {
                if((n&i) != 0) {
                    bw.write(cnt+" ");
                }
                if(i>1000000) {
                    break;
                }
                i<<=1;
                cnt++;
            }

            bw.write("\n");
        }
        
        bw.flush();
    }
}