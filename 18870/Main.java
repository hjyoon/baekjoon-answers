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

    public static int lowerBound(int arr[], int front, int rear, int key){
        int mid = 0;
        while(front < rear){
            mid = (front + rear) / 2;
            if(arr[mid] < key) {
                front = mid + 1;
            }
            else rear = mid;
        }
        return rear;
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //s = br.readLine();
        sa = br.readLine().split(" +");
        int N = Integer.parseInt(sa[0]);    // 1 <= N <= 1,000,000
        sa = br.readLine().split(" +");

        int arr[] = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }

        // print test
        // for(int tmp : arr) {
        //     bw.write(tmp + " ");
        // }
        // bw.write("\n");

        int[] n_arr = Arrays.stream(arr).sorted().distinct().toArray();

        // print test
        // for(int tmp : n_arr) {
        //     bw.write(tmp + " ");
        // }
        // bw.write("\n");


        for(int i=0; i<N; i++) {
            int cnt = lowerBound(n_arr, 0, n_arr.length-1, arr[i]);
            bw.write(cnt + " ");
        }

        bw.write("\n");
        bw.flush();
    }
}