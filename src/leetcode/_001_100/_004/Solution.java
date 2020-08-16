package leetcode._001_100._004;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;
        if (length % 2 == 1 ) {
            return findK(nums1, 0, length1-1, nums2, 0, length2 - 1, length / 2 + 1);
        }
        int k1 = findK(nums1, 0, length1-1, nums2, 0, length2 - 1, length / 2 );
        int k2 = findK(nums1, 0, length1-1, nums2, 0, length2 - 1, length / 2 + 1);
        return (double) (k1 + k2) / 2;
    }

    // 从num[start1,end1] num2[start2,end2]找到第k大元素
    public int findK(int[] num1, int start1, int end1, int[] num2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        if (len1 == 0) {
            return num2[start2 + k -1];
        }

        if (len2 == 0) {
            return num1[start1 + k -1];
        }

        if (k == 1) {
            return Math.min(num1[start1], num2[start2]);
        }

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (num1[i] > num2[j]) {
            return findK(num1, start1, end1, num2, j+1, end2, k - (j - start2 + 1));
        }else {
            return findK(num1, i+1, end1, num2, start2, end2, k - (i - start1 + 1));
        }
    }

}
