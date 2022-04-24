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

        String s = br.readLine();

        String A = s + "0000";
        String B = "0000" + s;

        String res = "";
        int len = A.length();
        boolean carry = false;
        for(int i=len-1; i>=0; i--) {
            if(A.charAt(i) == '0' && B.charAt(i) == '0' && carry == false) {
                res += '0';
            }
            else if(A.charAt(i) == '1' && B.charAt(i) == '0' && carry == false) {
                res += '1';
            }
            else if(A.charAt(i) == '0' && B.charAt(i) == '1' && carry == false) {
                res += '1';
            }
            else if(A.charAt(i) == '1' && B.charAt(i) == '1' && carry == false) {
                res += '0';
                carry = true;
            }
            else if(A.charAt(i) == '0' && B.charAt(i) == '0' && carry == true) {
                res += '1';
                carry = false;
            }
            else if(A.charAt(i) == '1' && B.charAt(i) == '0' && carry == true) {
                res += '0';
            }
            else if(A.charAt(i) == '0' && B.charAt(i) == '1' && carry == true) {
                res += '0';
            }
            else if(A.charAt(i) == '1' && B.charAt(i) == '1' && carry == true) {
                res += '1';
            }
        }

        if(carry == true) {
            res += '1';
        }

        len = res.length();
        for(int i=len-1; i>=0; i--) {
            bw.write(res.charAt(i));
        }
        bw.flush();
    }
}