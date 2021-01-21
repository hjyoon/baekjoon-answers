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

        int N = Integer.parseInt(br.readLine());
        int A=0, B=0;
        for(int i=0; i<N; i++) {
            String[] s = br.readLine().split(" ");
            if(Integer.parseInt(s[0])>Integer.parseInt(s[1])) {
                A++;
            }`
            else if(Integer.parseInt(s[0])<Integer.parseInt(s[1])) {
                B++;
            }

        }
        bw.write(String.format(A+" "+B));

        bw.flush();
    }
}