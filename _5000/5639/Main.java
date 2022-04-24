import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static int upperBound_for_list(List<Integer> data, int front, int rear, int target) {      
        int mid = 0;
        while(front < rear) {
            mid = (front + rear) / 2;
            if(data.get(mid) <= target) {
                front = mid + 1;
            }
            else {
                rear = mid;
            }
        }
        return rear;
    }

    public static void solve(List<Integer> data, int start, int end) throws Exception {
        if(start > end) {
            return;
        }
        if(start < 0 || start > data.size()-1 || end < 0 || end > data.size()-1) {
            return;
        }
        if(end - start == 0) {
            //bw.write(start+" "+end+"\n");
            bw.write(data.get(start)+"\n");
            return;
        }
        else if(end - start == 1) {
            //bw.write(start+" "+end+"\n");
            bw.write(data.get(start+1)+"\n");
            bw.write(data.get(start)+"\n");
            return;
        }
        // else if(end - start == 2) {
        //     bw.write(start+" "+end+"\n");
        //     bw.write(data.get(start+1)+"\n");
        //     bw.write(data.get(start+2)+"\n");
        //     bw.write(data.get(start)+"\n");
        //     return;
        // }

        int tmp = data.get(start);
        int idx = upperBound_for_list(data, start, end, tmp);

        // left
        if(data.get(idx) < tmp) {
            solve(data, start+1, idx);
        }
        else {
            solve(data, start+1, idx-1);
            // right
            solve(data, idx, end);
        }

        // root
        solve(data, start, start);
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> al = new ArrayList<>();

        
        while(true) {
            String s = br.readLine();
            if(s == null) {
                break;
            }
            st = new StringTokenizer(s);
            if(st == null) {
                break;
            }
            int tmp = Integer.parseInt(st.nextToken());
            al.add(tmp);
        }

        solve(al, 0, al.size()-1);

        bw.flush();
    }
}