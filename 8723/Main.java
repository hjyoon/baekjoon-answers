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

        int[] a = new int[3];

        a[0] = Integer.parseInt(s[0]);
        a[1] = Integer.parseInt(s[1]);
        a[2] = Integer.parseInt(s[2]);

        Arrays.sort(a);

        int res = 0;

        if(a[0] == a[1] && a[0] == a[2]) {
            res = 2;
        }
        else if(a[0]*a[0] + a[1]*a[1] == a[2]*a[2]) {
            res = 1;
        }
        else {
            res = 0;
        }

        // for(int i=0; i<3; i++) {
        //     bw.write(a[i]+" ");
        // }
        bw.write(res+"");
		bw.flush();
	}
}