import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        String s1 = st.nextToken();

        st = new StringTokenizer(br.readLine());
        String s2 = st.nextToken();

        if(s1.length() < s2.length()) {
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
        }

        int longer = Math.max(s1.length(), s2.length());
        int shorter = Math.min(s1.length(), s2.length());

        int[][] dp = new int[shorter+1][longer+1];

        for(int i=1; i<=shorter; i++) {
            for(int j=1; j<=longer; j++) {
                if(s2.charAt(i-1) == s1.charAt(j-1)) {
                    dp[i][j] = Math.min(dp[i-1][j]+1, dp[i][j-1]+1);
                    //dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // print test
        for(int i=0; i<=shorter; i++) {
            for(int j=0; j<=longer; j++) {
                bw.write(dp[i][j]+" ");
            }
            bw.newLine();
        }

        // bw.write(longer+"\n"+shorter+"\n");
        // bw.write(s1+"\n"+s2+"\n");
        bw.write(dp[shorter][longer]+"\n");
        bw.flush();
    }
}