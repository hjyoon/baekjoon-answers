import java.util.*;
import java.io.*;
public class Main{
	public static void main(String args[]) throws Exception {
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new FileReader("../input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int a, b;
        String[] s = br.readLine().split(" ");
		//a = sc.nextInt();
		//b = sc.nextInt();
        a = Integer.parseInt(s[0]);
        b = Integer.parseInt(s[1]);
        
		//System.out.println(a+b);
        bw.write(a+b+"");
        bw.flush();
	}
}