import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    //static String s;
    static String[] sa;

    public static <K, V> K getKey(Map<K, V> map, V value) {
        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //s = br.readLine();
        sa = br.readLine().split(" +");

        int N = Integer.parseInt(sa[0]);    // 1 <= N <= 100,000
        int M = Integer.parseInt(sa[1]);    // 1 <= M <= 100,000
        //HashMap<String, Integer> hm = new HashMap<>();
        TreeMap<String, String> tm = new TreeMap<>();
        for(int i=1; i<=N; i++) {
            String str = br.readLine();
            tm.put(str, i+"");
            tm.put(i+"", str);
        }

        for(int i=1; i<=M; i++) {
            String str = br.readLine();
            bw.write(tm.get(str)+"\n");
        }

        bw.flush();
    }
}