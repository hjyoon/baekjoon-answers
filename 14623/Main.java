import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("../input.txt"));
        //Scanner sc = new Scanner(System.in);

        //BufferedReader br = new BufferedReader(new FileReader("../input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		//String[] s = br.readLine().split(" ");

		String B1 = sc.next();
		String B2 = sc.next();

		long b1 = Long.parseLong(B1,2);
		long b2 = Long.parseLong(B2,2);
        
		//System.out.print(n*m);

		//BigInteger nn = new BigInteger(s1);
		//BigInteger mm = new BigInteger(s2);

		//BigInteger aa = new BigInteger(s[0]);
		//BigInteger bb = new BigInteger(s[1]);
		//BigInteger cc = new BigInteger(s[2]);

		System.out.println(Long.toBinaryString(b1*b2));
		//bw.write(a+b+c+"");
		//bw.flush();
	}
}