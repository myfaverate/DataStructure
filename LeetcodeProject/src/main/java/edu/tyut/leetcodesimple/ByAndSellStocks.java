package edu.tyut.leetcodesimple;
public class ByAndSellStocks {
    public static void main(String[] args) {

        int[] prices = {7,1,5,3,6,4};
        int sum = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i+1]>prices[i]){
                sum += (prices[i+1]-prices[i]);
            }
        }
        System.out.println(sum);
    }
}
