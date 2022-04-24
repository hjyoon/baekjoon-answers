import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.*;
import java.util.Map.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static boolean[] res = {true, false, false};

    static void swap(int i, int j) {
        boolean tmp = res[i];
        res[i] = res[j];
        res[j] = tmp;
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int len = s.length();
        for(int i=0; i<len; i++) {
            if(s.charAt(i) == 'A') {
                swap(0, 1);
            }
            else if(s.charAt(i) == 'B'){
                swap(1, 2);
            }
            else {
                swap(0, 2);
            }
        }

        for(int i=0; i<res.length; i++) {
            if(res[i] == true) {
                bw.write((i+1)+"");
            }
        }

        bw.flush();
    }
}