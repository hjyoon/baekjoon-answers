import java.util.*;
import java.io.*;
import java.math.*;

public class Main_2 {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[1000];
        arr[1] = true;

        for(int i=4; i<n; i++) {
            if(arr[i-1] == false && arr[i-3] == false && arr[i-4] == false) {
                arr[i] = true;
            }

        }

        String s = (arr[n-1]==true)?"CY":"SK";

        bw.write(s+"");

        bw.flush();
    }
}