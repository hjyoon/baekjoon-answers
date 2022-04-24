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

        int C_one = Integer.parseInt(br.readLine());
        int C_next = 0;

        int i = 1;
        while(true) {
            if(C_one == 1) {
                break;
            }

            if(C_one % 2 == 0) {
                C_next = C_one/2;
            }
            else {
                C_next = C_one*3 + 1;
            }

            C_one = C_next;
            i++;
        }

        bw.write(i+"");
        bw.flush();
    }
}