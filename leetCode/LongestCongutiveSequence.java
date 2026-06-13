package leetCode;

import java.util.HashSet;

public class LongestCongutiveSequence {

    public static void main(String[] args) {

        LongestCongutiveSequence longestCongutiveSequence = new LongestCongutiveSequence();
        int [] nums = {100, 4, 200, 1, 3, 2};
        int result = longestCongutiveSequence.longestConsecutive(nums);
        System.out.println(result); // Output: 4
    }

    public int longestConsecutive(int [] nums){

        HashSet<Integer> hashSet = new HashSet<>();

        for(int num : nums){
            hashSet.add(num);
        }

        int longestStreak = 0;
        for(int num : hashSet){
            if(!hashSet.contains(num -1)){
                int currentNum = num;
                int currentStreak = 1;

                while(hashSet.contains(currentNum +1)){
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;

    }
}
