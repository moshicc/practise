package com.zcc.algorithm_practise.leetcode;

/**
 * 一个有序数组nums，原地删除重复出现的元素，使每个元素只出现一次，返回删除后数组的新长度，
 * 不能使用额外的数组空间
 * 例：[0,1,2,2,3,3,4]  输出 5
 *
 * 提示，采用双指针，一个慢，一个快，当i,j元素不同，则同时下移动，相同，则移动j，
 * 然后再遇到不同就把 j赋值给i+1
 *
 * (i j 相等时 j往下移动，不相等时，把j赋值给i+1（这两个本来就是一个值）)
 */
public class DelSortNumsPre {
    public static int delNums(int[] nums) {
        if (nums.length == 0)
            return 0;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,3,4};
        int i = delNums(nums);
        System.out.println(i);
    }
}
