import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.*;
import java.util.Map.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i=1; i<=T; i++) {
            String[] s = br.readLine().split(" ");
            int[] arr = new int[3];
            arr[0] = Integer.parseInt(s[0]);
            arr[1] = Integer.parseInt(s[1]);
            arr[2] = Integer.parseInt(s[2]);
            Arrays.sort(arr);
            if(arr[0]*arr[0] + arr[1]*arr[1] == arr[2]*arr[2]) {
                bw.write("Scenario #"+i+":\n");
                bw.write("yes\n\n");
            }
            else {
                bw.write("Scenario #"+i+":\n");
                bw.write("no\n\n");
            }
        }

        bw.flush();
    }
}