package edu.tyut.kmp;

public class ViolenceMatch {
    public int ViolenceMatch(String str1,String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int s1Len = s1.length;
        int s2Len = s2.length;
        int i = 0; // i索引指向s1
        int j = 0; // j索引指向s2
        while (i<s1Len&&j<s2Len){
            if (s1[i]==s2[j]){
                i++;
                j++;
            }else {
                i=i-(j-1);
                j=0;
            }
        }
        // 判断是否匹配成功
        if (j==s2Len){
            return i-j;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        ViolenceMatch violenceMatch = new ViolenceMatch();
//        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
//        String str2 = "尚硅谷你尚硅你";
        String str1 = " 通过上述匹配过程可以看出，问题的关键就是寻找模式串中最大长度的相同前缀和后缀，找到了模式串中每个字符之前的前缀和后缀公共部分的最大长度后，便可基于此匹配。而这个最大长度便正是next 数组要表达的含义。";
        String str2 = "找到了模式串";
        System.out.println("index="+violenceMatch.ViolenceMatch(str1,str2));
    }
}
