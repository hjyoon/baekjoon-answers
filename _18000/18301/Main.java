import java.io.*;
import java.math.*;     
import java.util.*;
import java.util.regex.*;
import java.util.Map.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");

        int n1 = Integer.parseInt(s[0]);
        int n2 = Integer.parseInt(s[1]);
        int n12 = Integer.parseInt(s[2]);

        //double res = Math.floor(((n1+1)*(n2+1))/(double)(n12+1)-1);
        double res = ((n1+1)*(n2+1))/(double)(n12+1)-1;

        bw.write((int)res+"");
        bw.flush();
    }
}