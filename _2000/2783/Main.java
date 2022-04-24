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

        String[] s = br.readLine().split(" ");

        int X = Integer.parseInt(s[0]);
        int Y = Integer.parseInt(s[1]);

        double min = (double)X / Y;

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            String[] ss = br.readLine().split(" ");
            int tmp_X = Integer.parseInt(ss[0]);
            int tmp_Y = Integer.parseInt(ss[1]);
            if(min > (double)tmp_X / tmp_Y) {
                min = (double)tmp_X / tmp_Y;
            }
        }

        bw.write(min*1000+"");
        bw.flush();
    }
}