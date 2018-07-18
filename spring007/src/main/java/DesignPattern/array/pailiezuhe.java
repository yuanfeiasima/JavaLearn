package DesignPattern.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by grace on 17/3/16.
 */
public class pailiezuhe {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>(5);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);

        List<List<Integer>> aa = cal(a);
        for (List<Integer> intList : aa){
            for (Integer i : intList){
                System.out.print(i + ", ");
            }
            System.out.println();

        }
    }
    private static List<List<Integer>> cal(List<Integer> a){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int size = a.size();
        List<Integer> temp = null;
        if (size == 2){
            temp = new ArrayList<Integer>(2);
            temp.add(a.get(0));
            temp.add(a.get(1));
            res.add(temp);
            temp = new ArrayList<Integer>(2);
            temp.add(a.get(1));
            temp.add(a.get(0));
            res.add(temp);
        }else if (size > 2){
            List<List<Integer>> tempRes = null;
            Integer firstNum = null;
            List<Integer> tempPar = null;
        for (int i = 0; i < a.size(); i++) {
            firstNum = a.get(i);
            tempPar = new ArrayList<Integer>(a);
            tempPar.remove(i);
            tempRes = cal(tempPar);
            if (tempRes != null && tempRes.size() > 0){
                for (List<Integer> intList:tempRes){
                    intList.add(0, firstNum);
                    res.add(intList);
                }

            }
        }

        }
        return res;
    }
}
