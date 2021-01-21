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

        String[] s = br.readLine().split(" ");
        ArrayList<Integer> al = new ArrayList<>();

        for(String ss : s) {
            al.add(Integer.parseInt(ss));
        }

        Collections.sort(al);

        if(al.get(1)-al.get(0) > al.get(2)-al.get(1)) {
            bw.write(al.get(0)+(al.get(2)-al.get(1))+"");
        }
        else if(al.get(1)-al.get(0) < al.get(2)-al.get(1)) {
                bw.write(al.get(1)+(al.get(1)-al.get(0))+"");
        }
        else {
            bw.write(al.get(2)+(al.get(1)-al.get(0))+"");
        }
        
        
        bw.flush();
    }
}