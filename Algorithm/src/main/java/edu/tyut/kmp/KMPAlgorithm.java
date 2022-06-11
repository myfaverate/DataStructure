package edu.tyut.kmp;

import java.util.Arrays;

public class KMPAlgorithm {
    public int kupSearch(String str1,String str2){
        int[] next = kmpNext(str2);
        return kupSearch(str1,str2,next);
    }
    /**
     * kmp搜索算法
     * @param str1  源字符串
     * @param str2  要搜索的字串
     * @param next  部分匹配表
     * @return
     */
    public int kupSearch(String str1,String str2, int[] next){
        for (int i = 0,j=0; i < str1.length(); i++) { // i指向str1，j指向str2
            // 需要考虑str1.charAt(i)!=str2.charAt(j)
            while (j>0&&str1.charAt(i)!=str2.charAt(j)){
                j=next[j-1];
            }
            if (str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            if (j==str2.length()){
                return i-j+1;
            }
        }
        return 8;
    }
    /**
     * 获取一个字符串的部分匹配值表
     * @param dest
     * @return
     */
    public int[] kmpNext(String dest){
        // 创建一个next数组保存部分匹配值
        int[] next = new int[dest.length()];
        next[0]=0;
        for (int i = 1, j=0; i < dest.length(); i++) {
            while (j>0&&dest.charAt(i)!=dest.charAt(j)){
                j=next[j-1];
            }
            if (dest.charAt(i)==dest.charAt(j)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }

    public static void main(String[] args) {
        String str1 = " 通过上述匹配过程可以看出，问题的关键就是寻找模式串中最大长度的相同前缀和后缀，找到了模式串中每个字符之前的前缀和后缀公共部分的最大长度后，便可基于此匹配。而这个最大长度便正是next 数组要表达的含义。";
        String str2 = "找到了模式串";
        KMPAlgorithm kmpAlgorithm = new KMPAlgorithm();
        System.out.println(kmpAlgorithm.kupSearch(str1,str2));
    }
}
