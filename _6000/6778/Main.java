import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int Antenna = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int Eyes = Integer.parseInt(st.nextToken());

        if(Antenna >= 3 && Eyes <= 4) {
            bw.write("TroyMartian");
            bw.newLine();
        }

        if(Antenna <= 6 && Eyes >= 2) {
            bw.write("VladSaturnian");
            bw.newLine();
        }

        if(Antenna <= 2 && Eyes <= 3) {
            bw.write("GraemeMercurian");
            bw.newLine();
        }
        
        bw.flush();
    }
}