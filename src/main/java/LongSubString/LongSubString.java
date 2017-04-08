package LongSubString;

import sun.org.mozilla.javascript.internal.regexp.SubString;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by grace on 17/3/19.
 */
public class LongSubString {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] charArray = s.toCharArray();
        int resInt = 0;
        for (int i = 0; i < charArray.length; i++) {
            char temp = charArray[i];
            if (map.containsKey(temp)) {
                int newLong = map.size();
                if (newLong > resInt) {
                    resInt = newLong;
                }
                i = map.get(temp);
                map = new HashMap<Character, Integer>();
            } else {
                map.put(temp, i);
            }
        }
        return resInt < map.size()? map.size():resInt;
    }

    public static int leng2(String s){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }

    public static void main(String[] args) {
//        String str = "pwwkew";
//        String str = "abcabcbb";
//        String str = "a";
        String str = "dvdf";
        int longest = leng2(str);
        System.out.printf("longest is:%d", longest);
    }
}
