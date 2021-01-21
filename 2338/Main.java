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

		//long a = sc.nextLong();
		//long b = sc.nextLong();
		//long c = sc.nextLong();

		String s1 = sc.next();
		String s2 = sc.next();
        
		//System.out.print(n*m);

		BigInteger a = new BigInteger(s1);
		BigInteger b = new BigInteger(s2);

		//BigInteger aa = new BigInteger(s[0]);
		//BigInteger bb = new BigInteger(s[1]);
		//BigInteger cc = new BigInteger(s[2]);

		System.out.println(a.add(b));
		System.out.println(a.subtract(b));
		System.out.println(a.multiply(b));
		//bw.write(a+b+c+"");
		//bw.flush();
	}
}