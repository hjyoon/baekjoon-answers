import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[4];

        for(int i=0; i<4; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int mode = 4;
        if(arr[0] > arr[1]) {
            mode = 1;
        }
        else if(arr[0] < arr[1]) {
            mode = 2;
        }
        else {
            mode = 3;
        }

        for(int i=2; i<4; i++) {
            if(mode == 1) {
                if(arr[i-1] > arr[i]) {
                    continue;
                }
                else {
                    mode = 4;
                    break;
                }
            }
            else if(mode == 2) {
                if(arr[i-1] < arr[i]) {
                    continue;
                }
                else {
                    mode = 4;
                    break;
                }
            }
            else if(mode == 3) {
                if(arr[i-1] == arr[i]) {
                    continue;
                }
                else {
                    mode = 4;
                    break;
                }
            }
            else {
                break;
            }
        }

        if(mode == 1) {
            bw.write("Fish Diving");
        }
        else if(mode == 2) {
            bw.write("Fish Rising");
        }
        else if(mode == 3) {
            bw.write("Fish At Constant Depth");
        }
        else {
            bw.write("No Fish");
        }

        bw.flush();
    }
}