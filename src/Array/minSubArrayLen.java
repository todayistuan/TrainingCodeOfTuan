package Array;

/**
 * 暴力：
 * 双for遍历把所有区间情况列举出来 O(n²)
 *
 * 滑动窗口（所谓滑动窗口，就是不断的调节子序列的起始位置和终止位置，从而得出我们要想的结果)：
 * for(j=0;j<=numsize;j++）{ #j是终止位置
 *     sum += nums[j];
 *     while(sum >= s){#不用if，因为这是一个持续地向后移动的过程，可能会有一直大于的情况
 *         subL = j - i + 1;#i是起始位置
 *         result = min(result,subL);
 *         sum = sum - nums[i];
 *         i++;
 *     }
 *     return result;
 * }
 **/


/**209. 给定一个含有n个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续
 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。**/
public class minSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for(int right = 0;right < nums.length;right++){
            sum += nums[right];
            while(sum >= s){
                result = Math.min(result,right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}