import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static private int[] nextPermute(int[] nums) throws Exception {
        int[] copies = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copies[i] = nums[i];
        }
        int idx = -1;
        for (int i = 0; i < copies.length - 1; i++) {
            if (copies[i] < copies[i + 1]) {
                idx = i;
            }
        }
        if (idx < 0) {
            //Last Permutation
            return null;
        }
        for (int i = copies.length - 1; i > idx; i--) {
            if (copies[idx] < copies[i]) {
                int tmp = copies[idx];
                copies[idx] = copies[i];
                copies[i] = tmp;
                break;
            }
        }
        for (int i = idx + 1; i < (copies.length + idx + 1) / 2; i++) {
            int tmp = copies[i];
            copies[i] = copies[copies.length - (i - idx)];
            copies[copies.length - (i - idx)] = tmp;
        }
        return copies;
    }

    static private int[] prevPermute(int[] nums) throws Exception {
        int[] copies = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copies[i] = nums[i];
        }
        int idx = -1;
        for (int i = copies.length - 1; i > 0; i--) {
            if (copies[i] < copies[i - 1]) {
                idx = i-1;
                break;
            }
        }
        if (idx < 0) {
            //Last Permutation
            return null;
        }
        for (int i = copies.length - 1; i > idx; i--) {
            if (copies[idx] > copies[i]) {
                int tmp = copies[idx];
                copies[idx] = copies[i];
                copies[i] = tmp;
                break;
            }
        }
        for (int i = idx + 1; i < (copies.length + idx + 1) / 2; i++) {
            int tmp = copies[i];
            copies[i] = copies[copies.length - (i - idx)];
            copies[copies.length - (i - idx)] = tmp;
        }
        return copies;
    }

    static public List<List<Integer>> permute(int[] nums) throws Exception {
        List<List<Integer>> permutations = new ArrayList<>();
        Arrays.sort(nums);
        int[] curArray = nums;
        while (true) {
            List<Integer> integerList = new ArrayList<>();
            for (int i = 0; i < curArray.length; i++) {
                integerList.add(curArray[i]);
            }
            permutations.add(integerList);
            int[] nextPermutation = nextPermute(curArray);
            if (nextPermutation == null) {
                break;
            }
            curArray = nextPermutation;
        }
        return permutations;
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<String> al = new ArrayList<>();
        ArrayList<ArrayList<String>> al_2 = new ArrayList<>();
        ArrayList<ArrayList<String>> al_3 = new ArrayList<>();
        ArrayList<String> al_res = new ArrayList<>();

        for(int i=0; i<6; i++) {
            al.add(br.readLine());
        }

        int[] flag = new int[]{0,0,0,1,1,1};
        int[] flag2 = new int[]{0,1,2};

        List<List<Integer>> list = permute(flag);
        List<List<Integer>> list2 = permute(flag2);

        for(List<Integer> tmp : list) {
            ArrayList<String> tmp_al = new ArrayList<>();
            for(int i=0; i<tmp.size(); i++) {
                if(tmp.get(i) == 0) {
                    tmp_al.add(al.get(i));
                }
            }
            al_2.add(tmp_al);
        }

        // for(ArrayList<String> tmp : al_2) {
        //     for(String tmp_s : tmp) {
        //         bw.write(tmp_s+" ");
        //     }
        //     bw.write("\n");
        // }

        for(ArrayList<String> tmp : al_2) {
            for(List<Integer> tmp2 : list2) {
                ArrayList<String> tmp_al = new ArrayList<>();
                for(int i=0; i<tmp2.size(); i++) {
                    tmp_al.add(tmp.get(tmp2.get(i)));
                }
                String s = "";
                s+=tmp_al.get(0).charAt(0);
                s+=tmp_al.get(1).charAt(0);
                s+=tmp_al.get(2).charAt(0);
                tmp_al.add(s);

                s = "";
                s+=tmp_al.get(0).charAt(1);
                s+=tmp_al.get(1).charAt(1);
                s+=tmp_al.get(2).charAt(1);
                tmp_al.add(s);

                s = "";
                s+=tmp_al.get(0).charAt(2);
                s+=tmp_al.get(1).charAt(2);
                s+=tmp_al.get(2).charAt(2);
                tmp_al.add(s);

                al_3.add(tmp_al);
            }
        }

        for(ArrayList<String> tmp : al_3) {
            ArrayList<String> tmp_res = new ArrayList<>(tmp);
            Collections.sort(tmp);
            if(tmp.equals(al) == true) {
                al_res.add(tmp_res.get(0)+tmp_res.get(1)+tmp_res.get(2));
            }
        }

        // for(String tmp_s : al_res) {
        //     bw.write(tmp_s+" ");
        //     bw.write("\n");
        // }

        if(al_res.size() > 0) {
            Collections.sort(al_res);
            bw.write(al_res.get(0).substring(0,3)+"\n"+al_res.get(0).substring(3,6)+"\n"+al_res.get(0).substring(6,9));
        }
        else {
            bw.write("0");
        }

        bw.flush();
    }
}