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

        while(true) {
            String s = br.readLine();
            if(s.equals("0 0 0")) {
                break;
            }
            String[] ss = s.split(" ");
            int[] line = new int[3];
            line[0] = Integer.parseInt(ss[0]);
            line[1] = Integer.parseInt(ss[1]);
            line[2] = Integer.parseInt(ss[2]);
            Arrays.sort(line);
            if(line[0] + line[1] <= line[2]) {
                bw.write("Invalid\n");
            }
            else {
                if(line[0] == line[1] && line[1] == line[2]) {
                    bw.write("Equilateral\n");
                }
                else if(line[0] == line[1] || line[1] == line[2]) {
                    bw.write("Isosceles\n");
                }
                else {
                    bw.write("Scalene\n");
                }
            }
        }

        bw.flush();
    }
}