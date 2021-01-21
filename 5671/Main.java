import java.io.*;
import java.math.*;     
import java.util.*;
import java.util.regex.*;
import java.util.Map.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static boolean check(String s) {
        HashSet<Character> hs = new HashSet<>();
        int len = s.length();
        for(int i=0; i<len; i++) {
            if(hs.contains(s.charAt(i))) {
                return true;
            }
            else {
                hs.add(s.charAt(i));
            }
        }
        return false;
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] arr = new boolean[5001];

        for(int i=1; i<=5000; i++) {
            arr[i] = check(i+"");
        }

        while(true) {
            String s = br.readLine();
            if(s == null) {
                break;
            }
            String[] ss = s.split(" ");
            int N = Integer.parseInt(ss[0]);
            int M = Integer.parseInt(ss[1]);

            int res = 0;
            for(int i=N; i<=M; i++) {
                if(!arr[i]) {
                    res++;
                }
            }
            bw.write(res+"\n");
        }
        

        bw.write("");
        bw.flush();
    }
}