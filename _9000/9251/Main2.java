import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main2 {
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

        int l1=s1.length();
        int l2=s2.length();

        int[][] v = new int[l2+1][l1+1];
        for(int i=1; i<=l2; i++) {
            for(int j=1; j<=l1; j++) {
                if(s1.charAt(j-1) == s2.charAt(i-1)) {
                    v[i][j] = v[i-1][j-1]+1;
                }
                else {
                    v[i][j] = Math.max(v[i][j-1], v[i-1][j]);
                }
            }
        }

        bw.write(v[l2][l1]+"");
        bw.flush();
    }
}