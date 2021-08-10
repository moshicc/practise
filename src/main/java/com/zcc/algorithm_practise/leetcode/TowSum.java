package com.zcc.algorithm_practise.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PrimitiveIterator;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TowSum {

    public static int[] towSum1(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        for (int j = 0; j < nums.length; j++) {
            int temp = target - nums[j];
            if (map.containsKey(temp) && map.get(temp) != j) {
                return new int[]{j,map.get(temp)};
            }
        }
        return new int[0];
    }

    public static int[] towSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int temp = target - nums[j];
                if (map.containsKey(temp) && map.get(temp) != j) {
                    return new int[]{j,map.get(temp)};
                }
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }




    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] ints = towSum2(nums, 9);
        PrimitiveIterator.OfInt iterator = Arrays.stream(ints).iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
