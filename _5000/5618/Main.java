import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] num = new int[n];
        for(int i=0; i<n; i++) {
            num[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(num);

        TreeMap<Integer, Integer> tm = new TreeMap<>();

        for(int i=0; i<n; i++) {
            int tmp = Math.min(num[0], (int)Math.sqrt(num[i]));
            for(int j=1; j<=tmp; j++) {
                if(num[i]%j == 0) {
                    if(tm.containsKey(j)) {
                        int ttmp = tm.get(j);
                        tm.put(j, ttmp+1);
                    }
                    else {
                        tm.put(j, 1);
                    }
                    if(j == num[i]/j) {
                        continue;
                    }
                    if(tm.containsKey(num[i]/j)) {
                        int ttmp = tm.get(num[i]/j);
                        tm.put(num[i]/j, ttmp+1);
                    }
                    else {
                        tm.put(num[i]/j, 1);
                    }
                }
            }
        }

        for(Integer ss : tm.keySet()) {
            if(tm.get(ss) == n) {
                bw.write(ss+"\n");
            }
            //bw.write(tm.get(ss)+" "+ss+"\n");
        }

        bw.flush();
    }
}