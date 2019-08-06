package Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * create by: Hugo
 * description:删除数组中某一个值
 * create time: 9:21 2019/8/6
 *
 * @Param: nums
 * @Param: val
 * @return int
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            temp.add(nums[i]);
        }
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).equals(val)) {
                temp.remove(i);
            }
        }
        Object[] result = temp.toArray();
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        return temp.size();
    }

    public static class Solution {
        public static int removeElement(int[] nums, int val) {
            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != val) {
                    nums[i++] = nums[j];
                }
            }
            return i;
        }
    }
}
