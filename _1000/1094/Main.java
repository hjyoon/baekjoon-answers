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

    static int cal(int s, int e, int sum) {
        if(e == sum) {
            return 1;
        }
        else {
            if(sum-(s/2) >= e) {
                return cal(s/2, e, sum-(s/2));  // ¹Ý ¹ö¸²
            }
            else {
                return 1 + cal(s/2, e, sum);    // ¹ÝÀ¸·Î ÂÉ°·
            }
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());

        int res = cal(64, X, 64);
        bw.write(res+"");
        bw.flush();
    }
}