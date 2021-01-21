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

        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            String[] s = br.readLine().split(" ");
            int sum = 0;
            int min = 100;      // 입력 값중 100이 가장 큰 값이므로

            for(int i=0; i<7; i++) {
                int tmp = Integer.parseInt(s[i]);
                if(tmp % 2 == 0) {
                    sum += tmp;
                    if(min > tmp) {
                        min = tmp;
                    }
                }
            }

            bw.write(sum+" "+min+"\n");
        }
        
        bw.flush();
    }
}