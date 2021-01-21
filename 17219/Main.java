import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static String s;
    static String[] sa;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s = br.readLine();
        sa = s.split(" +");
        int N = Integer.parseInt(sa[0]);    // 1 <= N <= 100,000
        int M = Integer.parseInt(sa[1]);    // 1 <= M <= 100,000

        HashMap<String, String> hm = new HashMap<>();
        //TreeMap<String, String> tm = new TreeMap<>();

        for(int i=0; i<N; i++) {
            s = br.readLine();
            sa = s.split(" +");
            hm.put(sa[0], sa[1]);
        }

        for(int i=0; i<M; i++) {
            s = br.readLine();
            bw.write(hm.get(s)+"\n");
        }

        bw.flush();
    }
}