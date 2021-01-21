import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static String[] s;
    static String P;
    static int K;
    static boolean[] primeList = new boolean[1000001];
    static int[] al = new int[1000001];

    static int mod(String big, int i) {
        int ret = 0;
        int len = big.length();
        for (int j=0; j<len; j++) {
            ret = (ret*10 + big.charAt(j)-'0') % i;
        }
        return ret;
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s = br.readLine().split(" ");
        //BigInteger P = new BigInteger(s[0]);
        P = s[0];
        K = Integer.parseInt(s[1]);

        //primeList = new boolean[K];
        //Arrays.fill(primeList, true);
        primeList[0] = true;
        primeList[1] = true;


        //al = new ArrayList<>();
        int cnt = 0;
        for(int i=2; i<K; i++) {
            if(primeList[i] == false) {
                al[cnt++] = i;
                for(int j=i*2; j<K; j+=i) {
                    primeList[j] = true;
                }
            }
        }

        // int size = primeList.length;
        // for(int i=0; i<size; i++) {
        //     if(primeList[i] == true) {
        //         al.add(i);
        //     }
        // }

        for(int i=0; i<cnt; i++) {
            if(mod(P, al[i]) == 0) {
                bw.write("BAD "+al[i]);
                bw.flush();
                return;
            }
        }
        bw.write("GOOD");
        bw.flush();
    }
}