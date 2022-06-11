package search;

import java.util.Arrays;

public class FibonacciSearch {
    // 递归产生斐波那契数列
    public int[] FibonacciArray(int size){
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = Fibonacci(i);
        }
        return array;
    }

    public int Fibonacci(int size){
        if(size==0||size==1){
            return 1;
        }else {
            return Fibonacci(size-2)+Fibonacci(size-1);
        }
    }

    public int[] noRecursionFibonacci(int maxSize){
        int[] array = new int[maxSize];
        array[0]=1;
        array[1]=1;
        for (int i = 2; i < maxSize; i++) {
            array[i] = array[i-1] + array[i-2];
        }
        return array;
    }

    /**
     * 编写斐波那契查找算法(非递归)
     * @param array      数组
     * @param findValue  我们要找的值
     * @return           返回下标，如果未找到返回-1
     */
    public int fibSearch(int[] array, int findValue){
        int low = 0;
        int high = array.length-1;
        int k = 0; // 表示斐波那契分割数值的下标
        int middle; // 存放middle的值
        int[] fib = FibonacciArray(20); // 获取斐波那契数组
        // 获取到斐波那契额分割数值的下标
        while (high>fib[k]-1){
            k++;
        }
        //System.out.println("k: "+k);
        // 构造新数组
        int[] tmp = Arrays.copyOf(array,fib[k]);
        // tmp多出来的部分以array[high]填充
        for (int i = high+1; i < tmp.length; i++) {
            tmp[i]=array[high];
        }
        // 找findValue
        while (low<=high){
            middle = low + fib[k-1] - 1;
            //System.out.println("middle:"+middle);
            if (findValue<tmp[middle]){
                // 往左查找
                high = middle-1;
                k--;
            }else if (findValue>tmp[middle]){
                low = middle + 1;
                k-=2;
            }else {
                if (middle<=high){
                    return middle;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FibonacciSearch search = new FibonacciSearch();
        int[] array = search.FibonacciArray(40);
        System.out.println(Arrays.toString(array));
        int[] nums = {1,8,10,89,1000,1234};
        System.out.println(search.fibSearch(nums, 88));
    }
}
