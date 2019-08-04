package Easy;

import java.util.*;

/**
 * create by: Hugo
 * description:给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 思路：转成set没有重复值
 * create time: 11:46 2019/8/4
 *
 * @Param: null
 * @return
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(String.valueOf(nums[i]));
        }
        Set<String> staffsSet = new HashSet(list);
        return staffsSet.size();
    }
}
