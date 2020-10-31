import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /* Desription:
    * Given an array of integers NUMS an integer TARGET, return INDICES OF THE TWO NUMBERS such as that they
    * add up to TARGET */

    /* Data Structure: HashTable */
    /* Hint:
    *   key: each element value - nums[i]
    *   value: num index */

    /* Time Complexity: O(n) - Linear
    * where n is the number of elements in NUMS */

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndicesMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (numIndicesMap.containsKey(difference)) {
                return new int[] { i, numIndicesMap.get(difference) };
            }
            numIndicesMap.put(nums[i], i);
        }

        throw new RuntimeException("Invalid input.");
    }

    /* Demo */

    public static void main(String[] args) {
        final int[] nums = { 1, 2, 3, 4, 5 };
        final int target = 7;

        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

}
