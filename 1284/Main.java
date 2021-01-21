import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] a = new int[10];
        Arrays.fill(a, 3); 
        a[0] = 4;
        a[1] = 2;

        while(true) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("0")) {
                break;
            }

            int sum = s.length()+1;
            for(int i=0; i<s.length(); i++) {
                sum += a[s.charAt(i)-'0'];
            }
            bw.write(sum+"");
            bw.newLine();
        }

        bw.flush();
    }
}