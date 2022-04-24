import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
import java.time.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine(), ":");
        int s_hour = Integer.parseInt(st.nextToken());
        int s_minute = Integer.parseInt(st.nextToken());
        int s_second = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), ":");
        int e_hour = Integer.parseInt(st.nextToken());
        int e_minute = Integer.parseInt(st.nextToken());
        int e_second = Integer.parseInt(st.nextToken());

        // LocalDate today = LocalDate.now();
        // LocalTime present = LocalTime.now();
        // System.out.println(today + " " + present);

        // // static LocalDate of(int year, int month, int dayOfMonth)
        // LocalDate birthDay = LocalDate.of(1982, 02, 19);
         
        // // static LocalTime of(int hour, int minute, int second, int nanoOfSecond)
        //LocalTime start = LocalTime.of(s_hour, s_minute, s_second);
        //LocalTime end = LocalTime.of(e_hour, e_minute, e_second);
        // System.out.println(birthDay + " " + birthTime);

        LocalDateTime start = LocalDateTime.of(1, 1, 1, s_hour, s_minute, s_second);
        LocalDateTime end = LocalDateTime.of(1, 1, 1, e_hour, e_minute, e_second);
        if(end.equals(start)) {
            bw.write("24:00:00");
            bw.newLine();
            bw.flush();
            return;
        }
        if(end.isBefore(start)) {
            end = end.plusDays(1);
        }

        Duration res = Duration.between(start, end);

        //bw.write(res+" ");
        //bw.newLine();

        String ress = String.format("%02d:%02d:%02d", res.toHoursPart(), res.toMinutesPart(), res.toSecondsPart());

        bw.write(ress+"");
        bw.newLine();

        //bw.write(s_hour+" "+s_minute+" "+s_second);
        //bw.newLine();
        //bw.write(e_hour+" "+e_minute+" "+e_second);
        //bw.newLine();

        bw.flush();
    }
}