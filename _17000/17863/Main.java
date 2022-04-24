import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("../input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        if(s.substring(0, 3).equals("555")) {
            bw.write("YES\n");
        }
        else {
            bw.write("NO\n");
        }
        
        bw.flush();
    }
}