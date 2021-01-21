import java.util.*;
import java.io.*;
import java.math.*;

public class Main_3 {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String s = (n%7==0 || n%7==2)?"CY":"SK";

        bw.write(s+"");

        bw.flush();
    }
}