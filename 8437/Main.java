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

        //String[] s = br.readLine().split(" ");

        //long sum = Long.parseLong(br.readLine());
        //long sub = Long.parseLong(br.readLine());

        BigInteger sum = new BigInteger(br.readLine());
        BigInteger sub = new BigInteger(br.readLine());

        //double a = (sum+sub)/2.0;
        //double b = (sum-sub)/2.0;

        BigInteger a = sum.add(sub).divide(new BigInteger("2"));
        BigInteger b = sum.subtract(sub).divide(new BigInteger("2"));

        bw.write(a+"\n"+b);
        bw.flush();
    }
}