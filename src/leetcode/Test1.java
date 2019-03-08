package leetcode;

import java.util.Stack;

public class Test1 {

    public static void main(String[] args) {

        int sumClosest = threeSumClosest(new int[]{0, 2, 1, -3}, 2);
        System.out.println(sumClosest);
    }

    public static int threeSumClosest(int[] nums, int target) {
        sort(nums);
        int firstSum = nums[0] + nums[1] + nums[2];
        int sum;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 == nums.length) {
                return firstSum;
            } else if (i + 2 == nums.length) {
                return firstSum;
            } else {
                sum = nums[i] + nums[i + 1] + nums[i + 2];
            }

            if (sum == target) return sum;

            if (firstSum < target && sum < target) {
                firstSum = sum;
            } else if (firstSum >= target && sum >= target) {
                return Math.min(firstSum, sum);
            } else {
                return Math.abs(firstSum - target) > Math.abs(sum - target) ? sum : firstSum;
            }
        }
        return firstSum;
    }


    //失败的例子
    public static void sort(int[] array) {

        Stack<int[]> pool = new Stack<>();

        pool.push(new int[]{0, array.length - 1});

        while (!pool.empty()) {

            int[] pop = pool.pop();
            int left = pop[0];
            int right = pop[1];
            int base = array[left];

            while (left < right) {

                while (array[left] < base && left<right) {
                    left++;
                }



                while (array[right] >= base && left<right) {
                    right--;
                }

                if (left < right) {
                    int temp = array[left];
                    array[left] = array[right];
                    array[right] = temp;

                    left++;
                    right--;
                }
            }

            if (pop[0] < left) {
                pool.push(new int[]{pop[0], left});
            }


            if (pop[1] > right) {
                pool.push(new int[]{right, pop[1]});
            }

        }

        System.out.println(array);
    }
}
