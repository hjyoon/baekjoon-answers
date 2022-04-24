import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws Exception {
		//Scanner sc = new Scanner(new FileReader("../input.txt"));
        //Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new FileReader("../input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		//String[] s = br.readLine().split(" ");

		StringTokenizer birth = new StringTokenizer(br.readLine());

        int year = Integer.parseInt(birth.nextToken());
        int month = Integer.parseInt(birth.nextToken());
        int day = Integer.parseInt(birth.nextToken());

        StringTokenizer standard = new StringTokenizer(br.readLine());

        int s_year = Integer.parseInt(standard.nextToken());
        int yearAge = s_year - year;

        if(year < s_year) {
            if (month <= Integer.parseInt(standard.nextToken())) {
                if (day <= Integer.parseInt(standard.nextToken())) {
                    System.out.println(yearAge);
                } else {
                    System.out.println(yearAge - 1);
                }
            } else {
                System.out.println(yearAge-1);
            }
        }else{
            System.out.println(yearAge);
        }

        System.out.println(yearAge + 1);

        System.out.println(yearAge);
	}
}