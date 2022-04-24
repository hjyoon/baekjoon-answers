import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("../input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
	        String s = br.readLine();
	        if(s == null) {
	        	break;
	        }
	        else {
	        	bw.write(s+"\n");
	        }
	    }

        bw.flush();
        //bw.close();
	}
}