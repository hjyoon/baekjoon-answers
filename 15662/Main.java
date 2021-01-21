import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] al = new ArrayList[T];

        for(int i=0; i<T; i++) {
            al[i] = new ArrayList<>();
        }

        for(int i=0; i<T; i++) {
            String s = br.readLine();
            //bw.write(s+"\n");
            int len = s.length();
            for(int j=0; j<len; j++) {
                if(s.charAt(j) == '0') {
                    al[i].add(0);
                }
                else {
                    al[i].add(1);
                }
            }
        }

        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            boolean[] b = new boolean[T];
            for(int i=a-1; i<T-1; i++) {
                if(al[i].get(2) != al[i+1].get(6)) {
                    b[i+1] = true;
                }
            }

        }

        //Collections.rotate(al[0], 1);
        for(int i=0; i<T; i++) {
            for(int t : al[i]) {
                bw.write(t+"");
            }
            bw.write("\n");
        }




        int res = 0;
        for(int i=0; i<T; i++) {
            if(al[i].get(0) == 1) {
                res++;
            }
        }

        bw.write(res+"");
        bw.flush();
    }
}