import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int score_1 = 0;
        int score_2 = 0;
        int res_time_1 = 0;
        int res_time_2 = 0;
        int last_time = 0;
        boolean sw_1 = false;
        boolean sw_2 = false;
        for(int i=0; i<N; i++) {
            String[] s = br.readLine().split(" ");
            int goal_now = Integer.parseInt(s[0]);
            String[] time = s[1].split(":");
            int time_now = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);

            if(goal_now == 1) {
                score_1++;
            }
            else {
                score_2++;
            }

            if(sw_1 == true && score_1 == score_2) {
                res_time_1 += time_now - last_time;
                sw_1 = false;
            }
            else if(sw_1 == true && score_1 > score_2) {
                res_time_1 += time_now - last_time;
            }
            else if(sw_2 == true && score_1 == score_2) {
                res_time_2 += time_now - last_time;
                sw_2 = false;
            }
            else if(sw_2 == true && score_1 < score_2) {
                res_time_2 += time_now - last_time;
            }

            if(score_1 > score_2) {
                sw_1 = true;
            }
            else if(score_1 < score_2) {
                sw_2 = true;
            }
            else {
                sw_1 = false;
                sw_2 = false;
            }

            last_time = time_now;
        }

        if(sw_1 == true) {
            res_time_1 += 48*60 - last_time;
        }
        else if(sw_2 == true) {
            res_time_2 += 48*60 - last_time;
        }


        bw.write(String.format("%02d:%02d\n",res_time_1/60, res_time_1%60));
        bw.write(String.format("%02d:%02d\n",res_time_2/60, res_time_2%60));
        bw.flush();
    }
}