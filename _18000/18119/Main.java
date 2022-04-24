import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static final String NEW_LINE = "\n";

    static int initBit() {
        int res = 0;
        int tmp = 1;
        for(int i=0; i<26; i++) {
            res |= tmp;
            tmp <<= 1;
        }
        return res;
    }

    static int toBit(String s) {
        int res = 0;
        int l = s.length();
        for(int i=0; i<l; i++) {
            int tmp = 1;
            tmp <<= s.charAt(i)-'a';
            res |= tmp;
        }
        return res;
    }

    static int setMem(int o, String x, int prev) {
        int tmp = 1;
        if(o == 1) {
            tmp <<= x.charAt(0)-'a';
            tmp = ~tmp;
            prev &= tmp;
        }
        else {
            tmp <<= x.charAt(0)-'a';
            prev |= tmp;
        }
        return prev;
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        //bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] num_list = new int[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp = toBit(st.nextToken());
            num_list[i] = tmp;
        }

        int cur = initBit();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            String x = st.nextToken();

            cur = setMem(o, x, cur);

            for(int j=0; j<N; j++) {
                if((num_list[j] & cur) == num_list[j]) {
                    cnt++;
                }
            }

            //bw.write(cnt+"");
            //bw.newLine();
            sb.append(cnt+"").append(NEW_LINE);
        }

        System.out.print(sb.toString());
        //bw.write(sb.toString());
        //bw.flush();
    }
}