package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String nums="1024*10021-6946314-64*563+987*782578+782-87";
        List<Integer> list = new ArrayList<>();
        char ch;
        int end=0;
        int num;
        int i = 0;
        while (i<nums.length()) {
            ch=nums.charAt(i);
            while (ch >= '0' && ch <= '9' && end<(nums.length()-1)) {
                end++;
                ch=nums.charAt(end);
            }
            if (i!=end) {
                num = Integer.valueOf(nums.substring(i, end));
                list.add(num);
            }
            i=end+1;
        }
        System.out.println(list);
    }
}