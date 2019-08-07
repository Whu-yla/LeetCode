package Easy;

import java.util.Arrays;

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);// 将nums2中的数据从0开始拷贝到nums1中索引为m的位置，复制的元素个数为n个
        Arrays.sort(nums1);
    }
}
