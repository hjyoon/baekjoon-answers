import java.io.*;
import java.math.*;     
import java.util.*;
import java.util.regex.*;
import java.util.Map.*;

class Section implements Comparable<Section> {
    int start;
    int end;
    Section(int start, int end) {
        this.start = start;
        this.end = end;
    }
    Section(Section s) {
        this.start = s.start;
        this.end = s.end;
    }

    public int compareTo(Section s) {
        if(this.start > s.start) {
            return 1;
        }
        else if(this.start == s.start) {
            if(this.end > s.end) {
                return 1;
            }
        }
        return -1;
    }
}

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static void print_al(ArrayList<Section> al) throws Exception {
        for(Section s : al) {
            bw.write(s.start + " " + s.end + "\n");
        }
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int L = Integer.parseInt(s[1]);

        ArrayList<Section> al = new ArrayList<>();

        for(int i=0; i<N; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            al.add(new Section(start, end));
        }

        Collections.sort(al);

        ArrayList<Section> al_2 = new ArrayList<>();

        Section tmp_s = new Section(al.get(0));
        if((tmp_s.end - tmp_s.start) % L != 0) {
            tmp_s.end += L - ((tmp_s.end - tmp_s.start) % L);
        }
        for(int i=1; i<N; i++) {
            Section tmp_s2 = new Section(al.get(i));

            if(tmp_s2.start <= tmp_s.end && tmp_s2.end >= tmp_s.end) {
                tmp_s.end = tmp_s2.end;
            }
            else if(tmp_s2.end < tmp_s.end) {
                continue;
            }
            else {
                al_2.add(tmp_s);
                tmp_s = tmp_s2;
            }

            if((tmp_s.end - tmp_s.start) % L != 0) {
                tmp_s.end += L - ((tmp_s.end - tmp_s.start) % L);
            }
        }

        al_2.add(tmp_s);

        //print_al(al);
        //print_al(al_2);

        int res = 0;
        for(Section tmp : al_2) {
            res += (tmp.end - tmp.start) / L;
        }


        bw.write(res+"");
        bw.flush();
    }
}