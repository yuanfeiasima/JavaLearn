package findInArray;

/**
 * Created by grace on 17/3/20.
 */
public class FindInArray {

    public static boolean find(int[][] array, int target){
        int len = array.length -1;
        int i = 0;
        while((len >= 0)&&(i < array[0].length)){
            if (array[len][i] > target){
                len--;
            }else if (array[len][i] < target){
                i++;
            }else {
                return true;
            }
        }
        return false;
    }
}
