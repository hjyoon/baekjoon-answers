import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.*;
import java.util.Map.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static Scanner sc;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //sc = new Scanner("../input.txt");


        while(true) {
            String s = br.readLine();
            if(s == null) {
                break;
            }
            if(s.equals("")) {
                continue;
            }
            String[] ss = s.split(" +");
            int n = Integer.parseInt(ss[0]);

            int[] arr = new int[3000];
            boolean[] chk = new boolean[10000];
            boolean res = true;

            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(ss[i+1]);
                //bw.write(arr[i]+" ");
            }
            //bw.write("\n");

            // for(String sss : ss) {
            //     bw.write(sss+" ");
            // }
            // bw.write("\n");

            for(int i=0; i<n-1; i++) {
                int tmp = Math.abs(arr[i+1]-arr[i]);
                if(tmp > n-1) {
                    res = false;
                    break;
                }
                if(chk[tmp] == false) {
                    chk[tmp] = true;
                }
                else {
                    res = false;
                    break;
                }
            }

            for(int i=1; i<=n-1; i++) {
                if(chk[i] == false) {
                    res = false;
                    break;
                }
                //bw.write(i+" "+chk[i]+"\n");
            }

            if(res == false) {
                bw.write("Not jolly\n");
            }
            else {
                bw.write("Jolly\n");
            }

        }

        bw.flush();
    }
}