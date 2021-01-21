import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int[] parsing_source(String s) {
        int[] res = new int[3];
        String[] sa = s.split(":");
        res[0] = Integer.parseInt(sa[0]);
        res[1] = Integer.parseInt(sa[1]);
        res[2] = Integer.parseInt(sa[2]);
        return res;
    }

    static int make_full_num(int[] a) {
        return a[0]*10000 + a[1]*100 + a[2];
    }

    static void print_hhmmss(int[] a) throws Exception {
        bw.write(a[0]+" "+a[1]+" "+a[2]);
        bw.newLine();
    }

    static void after_one_second(int[] a) {
        a[2]++;
        if(a[2] == 60) {
            a[2] = 0;
            a[1]++;
        }
        if(a[1] == 60) {
            a[1] = 0;
            a[0]++;
        }
        if(a[0] == 24) {
            a[0] = 0;
        }
    }

    static int cnt_num(int[] start, int[] end) throws Exception {
        int cnt = 0;
        while(true) {
            int tmp_start = make_full_num(start);
            if(tmp_start % 3 == 0) {
                cnt++;
            }
            if(tmp_start == make_full_num(end)) {
                break;
            }
            after_one_second(start);
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));


        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            String start = st.nextToken();
            String end = st.nextToken();
            int[] start_hhmmss = parsing_source(start);
            int[] end_hhmmss = parsing_source(end);
            int f_start = make_full_num(start_hhmmss);
            int f_end = make_full_num(end_hhmmss);

            int res = 0;
            if(f_start > f_end) {
                res = cnt_num(start_hhmmss, new int[] {23, 59, 59});
                res += cnt_num(new int[] {0, 0, 0}, end_hhmmss);
            }
            else {
                res = cnt_num(start_hhmmss, end_hhmmss);
            }


            // print_hhmmss(start_hhmmss);
            // print_hhmmss(end_hhmmss);
            // bw.write(make_full_num(start_hhmmss)+"");
            // bw.newLine();
            // bw.write(make_full_num(end_hhmmss)+"");

            bw.write(res+"");
            bw.newLine();
        }

        bw.flush();
    }
}