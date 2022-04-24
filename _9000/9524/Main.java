import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static String[] s;

	public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

		s = br.readLine().split(" ");

        int a = Integer.parseInt(s[0]);

        int res = 0;

        if(a == 1) {
            res = 1;
        }
        else if(a == 2) {
            res = 7;
        }
        else if(a == 3){
            res = 2;
        }
        else if(a == 4){
            res = 3;
        }

        // for(int i=0; i<3; i++) {
        //     bw.write(a[i]+" ");
        // }
        bw.write(res+"");
		bw.flush();
	}
}