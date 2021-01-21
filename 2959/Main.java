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

        String[] s = br.readLine().split(" ");
        int[] arr = new int[4];

        arr[0] = Integer.parseInt(s[0]);
        arr[1] = Integer.parseInt(s[1]);
        arr[2] = Integer.parseInt(s[2]);
        arr[3] = Integer.parseInt(s[3]);

        Arrays.sort(arr);

        bw.write(arr[0]*arr[2]+"");
        bw.flush();
    }
}