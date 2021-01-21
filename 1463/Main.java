import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
	static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

	static int solve(int n, int[] dp) throws Exception {
		if(n == 1) {
			return 0;
		}
		if(dp[n] != 0) {
			return dp[n];
		}
		int res1=100000000, res2=100000000, res3=100000000;
		if(n % 3 == 0) {
			res1 = solve(n/3, dp);
		}
		if(n % 2 == 0) {
			res2 = solve(n/2, dp);
		}
		res3 = solve(n-1, dp);
		int min = Math.min(res1, Math.min(res2,  res3));
		dp[n] = min + 1;
		return dp[n];
	}

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] dp = new int[1000001];

		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;

		int res = solve(N, dp);

		// test print
		for(int i=1; i<=N; i++) {
			bw.write("i = "+i+" "+dp[i]);
			bw.newLine();
		}

		bw.write(res+"");
		bw.flush();
	}
}