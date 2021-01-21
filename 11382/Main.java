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

		String[] s = br.readLine().split(" ");

		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
        
		//System.out.print(n*m);

		//BigInteger nn = new BigInteger(s1);
		//BigInteger mm = new BigInteger(s2);

		//BigInteger aa = new BigInteger(s[0]);
		//BigInteger bb = new BigInteger(s[1]);
		//BigInteger cc = new BigInteger(s[2]);

		//System.out.println(nn.multiply(mm));
		bw.write(a+b+c+"");
		bw.flush();
	}
}