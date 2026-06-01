package walmart;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class BST {

    public static void main(String[] args) {

        String str = "walmart";

        String s = longestSubstring(str);
        System.out.println(s);
    }

    private static String longestSubstring(String str) {
        int left =0; int right =0 ; int maxLength =0;//
        HashMap<Character,Integer> map = new HashMap<>();
        int start=0;//
        while (right <str.length()){
            char ch = str.charAt(right);
            if(map.containsKey(ch) && map.get(ch) >=left){
                left = map.get(ch) +1;
            }
            map.put(ch,right);

            if(right - left + 1 >maxLength){
                maxLength = right - left +1;
                start = left;
            }
            right ++;
        }
        return str.substring(start , start+maxLength);
    }
}
