package java8;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 将一个二维数组转换为一维数组
 *
 * @Author: wentao.wang@ly.com
 * @Date: 2018/11/15
 */
public class FlatMap {
    public static void main(String[] args) {
        List<Integer> nums =
                Stream.of(Arrays.asList(1,2,3),
                        Arrays.asList(1,4,9),
                        Arrays.asList(1,8,27)).
                        flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(nums);
    }
}
