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

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String S = st.nextToken();

        int cnt_2 = 0;
        int cnt_e = 0;
        for(int i=0; i<N; i++) {
            if(S.charAt(i) == '2') {
                cnt_2++;
            }
            else {
                cnt_e++;
            }
        }

        if(cnt_2 == cnt_e) {
            bw.write("yee");
        }
        else if(cnt_2 > cnt_e) {
            bw.write("2");
        }
        else {
            bw.write("e");
        }

        bw.flush();
    }
}