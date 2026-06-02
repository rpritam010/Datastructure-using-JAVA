package leetCode;
/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.


Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianOfArray {
    public static void main(String[] args) {
        MedianOfArray medianOfArray = new MedianOfArray();
        int[] nums1 = {1, 2};
        int[] nums2 = {3,4};
        System.out.println(medianOfArray.findMedianSortedArrays(nums1, nums2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> ls = new ArrayList<>();
        for(int i:nums1){
            ls.add(i);
        }
        for(int i:nums2) {
            ls.add(i);
        }
        Collections.sort(ls);

        if(ls.size() %2  !=0){
            return ls.get(ls.size()/2);
        }else{
            return (ls.get(ls.size()/2)+ls.get(ls.size()/2-1))/2.0;
        }


    }
}
