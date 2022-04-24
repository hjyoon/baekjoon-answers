import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    //static String s;
    //static String[] sa;

    public static int cal(int[] square, int[] arr, int target) throws Exception {
        int min = 4;
        for(int i=1; (square[i]<=target && i<223); i++) {
            int tmp = arr[target-square[i]];
            if(tmp < min) {
                min = tmp;
            }
        }
        return min+1;
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //s = br.readLine();
        //sa = s.split(" +");
        int N = Integer.parseInt(br.readLine());    // 1 <= N <= 50,000

        int[] square = new int[224];
        for(int i=1; i<=223; i++) {
            square[i] = i*i;
        }

        int[] arr = new int[50001];
        for(int i=1; i<=50000; i++) {
            if(arr[i] == 0) {
                arr[i] = cal(square, arr, i);
            }
        }

        //print test
        // for(int i=1; i<=50000; i++) {
        //     // if(arr[i] != 0) {
        //     //     bw.write(i + " = " + arr[i] + "\n");
        //     // }
        //     bw.write(i + " = " + arr[i] + "\n");
        // }

        bw.write(arr[N] + "\n");
        bw.flush();
    }
}