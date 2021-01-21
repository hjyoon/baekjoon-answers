import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static String reverseArrayString(String s) {
        String tmp = "";
        int len = s.length();
        for(int i=0; i<len; i++) {
            tmp += s.charAt(len-1-i);
        }
        return tmp;
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[100];
        arr[0] = 1;
        for(int i=1; i<100; i++) {
            arr[i] = arr[i-1] + (i+1)*(i+1);
        }

        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            bw.write(arr[n-1]+"\n");
        }

        bw.flush();
    }
}