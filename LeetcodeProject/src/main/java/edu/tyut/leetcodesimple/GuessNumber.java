package edu.tyut.leetcodesimple;

import java.util.Scanner;

public class GuessNumber {
    public void guessNumber(int n,int pick) {
        Scanner scanner = new Scanner(System.in);
        int left = 1;
        int right=n;
        int middle;
        int num;
        while (true){
            num= scanner.nextInt();
            middle = (left+right)>>1;
            if (num<pick){
                right = middle+1;
                System.out.println("小了");
            }else if (num>pick){
                left = middle-1;
                System.out.println("大了");
            }
            else {
                System.out.println("猜中了");
                break;
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        GuessNumber guessNumber = new GuessNumber();
        guessNumber.guessNumber(100,21);
    }
}
