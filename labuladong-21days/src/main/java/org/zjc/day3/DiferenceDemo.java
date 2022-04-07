package org.zjc.day3;

/**
 * @author: zhangjunchai
 * @Date: 2022/4/7 21:23
 * @Description:
 */
public class DiferenceDemo {


}

class Solution_corpFlightBookings {
    /**
     * @param bookings bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi个座位。
     * @param n        这里有 n 个航班，它们分别从 1 到 n 进行编号。
     * @return 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] array = new int[n];
        Difference difference = new Difference(array);
        for (int i = 0; i < bookings.length; i++) {
            int[] booking = bookings[i];
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];
            difference.increase(first - 1, last - 1, seats);
        }
        return difference.result();
    }
}

/**
 * https://leetcode-cn.com/problems/car-pooling/submissions/
 */
class Solution_carPooling {
    /**
     * 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/car-pooling
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param trips    [numPassengersi, fromi, toi]
     * @param capacity
     * @return
     */
    public boolean carPooling(int[][] trips, int capacity) {
        int[] array = new int[1001];
        Difference difference = new Difference(array);
        for (int i = 0; i < trips.length; i++) {
            int[] trip = trips[i];
            int person = trip[0];
            int from = trip[1];
            // 减一是因为，在to位置已经下车了
            int to = trip[2] - 1;
            difference.increase(from, to, person);
        }
        int[] result = difference.result();
        for (int i = 0; i < result.length; i++) {
            if (result[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}
