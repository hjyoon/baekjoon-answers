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

        int n = Integer.parseInt(br.readLine());

        while(true) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                break;
            }

            if(num % n == 0) {
                bw.write(num+" is a multiple of "+n+".\n");
            }
            else {
                bw.write(num+" is NOT a multiple of "+n+".\n");
            }
        }
        
        bw.flush();
    }
}