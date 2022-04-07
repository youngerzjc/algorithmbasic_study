package org.zjc.day3;

/**
 * @author: zhangjunchai
 * @Date: 2022/4/7 21:10
 * @Description: 查分数组工具类
 */
public class Difference {
    /**
     * 原始数组
     */
    private int[] array;
    /**
     * 含义：diff[i] = array[i] - array[i - 1]
     * 默认：diff[0] = array[0]
     */
    private int[] diff;

    /**
     * 根据 array 初始化出 diff
     *
     * @param array 原始数组
     */
    public Difference(int[] array) {
        this.array = array;
        diff = new int[array.length];
        diff[0] = array[0];
        for (int i = 1; i < diff.length; i++) {
            diff[i] = array[i] - array[i - 1];
        }
    }

    /**
     * 在[i, j]区间增加value
     *
     * @param i     i
     * @param j     j
     * @param value value
     */
    public void increase(int i, int j, int value) {
        diff[i] += value;
        if (j + 1 < diff.length) {
            diff[j + 1] -= value;
        }
    }

    /**
     * 根据diff还原出数组
     *
     * @return int[]
     */
    public int[] result() {
        int[] array = new int[diff.length];
        array[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            array[i] = array[i - 1] + diff[i];
        }
        return array;
    }
}
