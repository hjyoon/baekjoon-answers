import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int W = Integer.parseInt(s[1]);

        ArrayList<Integer> three = new ArrayList<>();
        ArrayList<Integer> five = new ArrayList<>();

        for(int i=0; i<N; i++) {
            s = br.readLine().split(" ");
            int type = Integer.parseInt(s[0]);
            int p = Integer.parseInt(s[1]);
            if(type == 3) {
                three.add(p);
            }
            else {
                five.add(p);
            }
        }

        Collections.sort(three, Comparator.reverseOrder());
        Collections.sort(five, Comparator.reverseOrder());

        while(true) {
            
        }



        bw.write(" ");
        bw.flush();
    }
}