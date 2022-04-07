package org.zjc.day2;

import java.util.HashMap;

/**
 * @author: zhangjunchai
 * @Date: 2022/4/6 21:04
 * @Description:
 */
public class PreSumDemo {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix numMatrix = new NumMatrix(matrix);

    }
}


// https://leetcode-cn.com/problems/subarray-sum-equals-k/
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rest = sum - k;
            boolean restContains = map.containsKey(rest);
            if (restContains) {
                ans += map.get(rest);
            }
//            boolean sumContains = map.containsKey(sum);
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
        return ans;

    }
}

// https://leetcode-cn.com/problems/range-sum-query-2d-immutable/submissions/
class NumMatrix {
    //int[i][j] 代表 (0, 0) 到 (i, j) 之间的区域累加和
    int[][] preRegionSum;
    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int x = matrix.length + 1;
        int y = matrix[0].length + 1;
        preRegionSum = new int[x][y];
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                preRegionSum[i][j] = preRegionSum[i - 1][j] + preRegionSum[i][j - 1] + matrix[i - 1][j - 1] - preRegionSum[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preRegionSum[row2 + 1][col2 + 1] + preRegionSum[row1][col1] - preRegionSum[row1][col2 + 1] - preRegionSum[row2 + 1][col1];
    }
}


// https://leetcode-cn.com/problems/range-sum-query-immutable/submissions/
// 前缀和数组。preSum[i] 代表 nums[0 ... i-1]的和
class NumArray {
    int[] preSum;

    public NumArray(int[] nums) {
        this.preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}