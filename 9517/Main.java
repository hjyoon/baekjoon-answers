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

        int k = Integer.parseInt(br.readLine()) - 1;
        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        for(int i=0; i<n; i++) {
            String[] s = br.readLine().split(" ");
            int t = Integer.parseInt(s[0]);
            sum += t;
            if(sum >= 210) {
                bw.write(k+1+"\n");
                break;
            }
            if(s[1].equals("T")) {
                k++;
            }

            k = k % 8;
        }

        bw.flush();
    }
}