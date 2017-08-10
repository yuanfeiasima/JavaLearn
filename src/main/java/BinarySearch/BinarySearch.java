package BinarySearch;

import java.util.Arrays;
import java.util.List;

/**
 * 二分查找
 * Created by grace on 17/3/18.
 */
public class BinarySearch {
    public static int rank(int key, int[] a){
        int low = 0;
        int high = a.length -1;
        while(low <= high){
            int mid = low + (high + low) / 2;
            if (key < a[mid]){
                high = mid -1;
            }else if (key > a[mid]){
                low = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static int rank2(int key, int low, int high, int[] a){
//        int length = a.length;
        int mid = (high - low) / 2 + low;
        if (key == a[mid]){
            return mid;
        }
        if (low > high){
            return -1;
        }else if (key < a[mid]){
            mid = mid - 1;
            return rank2(key, low, mid, a);
        }else if(key > a[mid]){
            mid = mid + 1;
            return rank2(key, mid, high, a);
        }
        return -1;
    }

//    public class Solution {
        public static int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];
            for(int i = 0; i < nums.length; i++){
                int num = nums[i];
                int[] tempArray = nums;
                for(int j =0;j < tempArray.length; j++){
                    int tempNum = tempArray[j];
                    if (i != j && num + tempNum == target) {
                        res =  new int[]{i, j};
                        return res;
                    }
                }

            }
            return res;
        }
//    }


    public static void main(String[] args) {
//        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
//        int index = rank(3, array);
//        int index = rank2(6, 0, array.length, array);
//        System.out.println("index is :" + index);
        int[] array = new int[]{3, 2, 4};
        long start = System.currentTimeMillis();
        int[] res = twoSum(array, 6);
        long end = System.currentTimeMillis();
        System.out.printf("used time:%d", end - start);
        System.out.println();
        System.out.printf("res is : [%d, %d]", res[0], res[1]);
    }
}
