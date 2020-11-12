package binarysearch;

public class TwoSortedArrayMedian {

    /* Description: Given two sorted arrays nums1 and nums2 of size m and n respectively,
    return the median of the two sorted arrays. */

    /* Data Structure: Arrays, Binary Search */

    /* Time Complexity:
    *
    * Brute Force: O(m + n) where m is the length of nums1 and n is the length of nums2
    * Binary Search: O(log(m + n)) */

    /* Brute Force Approach: bruteForce(nums1, num2)
    * Combine the 2 sorted arrays (nums1 and nums2) in a single sorted array (temp)
    * Once everything is in place, simply get the middle element if length of temp array is odd
    * if the length of temp array is even, get the average of both middle elements */

    /* Binary Search Approach: logarithmicComplexity(nums1, nums2)
    * A better way to explain this is through examples:
    *
    * Given: nums1 = [1]
    *        nums2 = [2, 3, 4, 5]
    *
    * For this example, the combined length of nums1 and nums2 is odd.
    *
    * findKthHelper([1], 0, [2,3,4,5], 0, 3) - First call: len is odd
    *   findKthHelper([1], 1, [2,3,4,5], 0, 2) - Second call: aVal(1) is less than bVal(2)
    *   returns 3 - aStart is now 1, and A.length is 1.
    *
    *
    * Another example:
    *
    * Given: nums1 = [1]
    *        nums2 = [2, 3, 4, 5, 6 ,7]
    *
    * findKthHelper([1], 0, [2,3,4,5,6,7], 0, 4) - First call: len is odd
    *   findKthHelper([1], 0, [2,3,4,5,6,7], 2, 2) - initially both aMid and bMid is 1, aVal (max value) is greater than bVal(3)
    *       findKthHelper([1], 1, [2,3,4,5,6,7], 2, 1) - aVal(1) is less than bVal(4)
    *       returns 4 - aStart is now 1, and A length is 1.   */

    public static void main(String[] args) {
        TwoSortedArrayMedian solution = new TwoSortedArrayMedian();
        double median = solution.logarithmicComplexity(new int[] {1}, new int[] {2,3,4,5});
        System.out.println(median);
    }

    public double logarithmicComplexity(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 0) {
            int left  = findKthHelper(nums1, 0, nums2, 0, len/2);
            int right = findKthHelper(nums1, 0, nums2, 0, len/2 + 1);
            return (double) (left + right) / 2;
        } else {
            return findKthHelper(nums1, 0, nums2, 0, len/2 + 1);
        }
    }

    public int findKthHelper(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart >= A.length) {
            return B[bStart + k - 1];
        }

        if (bStart >= B.length) {
            return A[aStart + k - 1];
        }

        if (k == 1) {
            return Math.min(A[aStart], B[bStart]);
        }

        int aMid = aStart + k/2 - 1;
        int aVal = aMid >= A.length ? Integer.MAX_VALUE : A[aMid];

        int bMid = bStart + k/2 - 1;
        int bVal = bMid >= B.length ? Integer.MAX_VALUE : B[bMid];

        return aVal <= bVal
                ? findKthHelper(A, aMid + 1, B, bStart, k - k/2)
                : findKthHelper(A, aStart, B, bMid + 1, k - k/2);
    }

    public double bruteForce(int[] nums1, int[] nums2) {
        double[] temp = new double[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;

        while(i < nums1.length && j < nums2.length) {
            temp[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }

        while(i < nums1.length) {
            temp[k++] = nums1[i++];
        }

        while(j < nums2.length) {
            temp[k++] = nums2[j++];
        }

        if (temp.length % 2 == 0) {
            return (temp[temp.length / 2] + temp[temp.length / 2 - 1]) / 2;
        } else {
            return temp[temp.length / 2];
        }
    }



}
