import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
import java.time.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    final static Double PI = 3.1415927;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i = 1;
        while(true) {
            st = new StringTokenizer(br.readLine());
            double L = Double.parseDouble(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            double T = Double.parseDouble(st.nextToken());
            if(C == 0) {
                break;
            }
            double res1 = ((L * PI * C)/12)/5280;
            double res2 = res1 * (3600/T);
            bw.write(String.format("Trip #%d: %.2f %.2f", i++, res1, res2));
            bw.newLine();
        }

        //bw.write("");
        //bw.newLine();
        bw.flush();
    }
}