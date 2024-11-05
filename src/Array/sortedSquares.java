package Array;

/**
 *双指针思路：
 * 如果有负数
 * 比如[-5,1,2,3]
 * 所有元素平方后最大元素肯定在两边
 * 两个指针逐渐向中间靠拢
 * 下标由大到小来进行更新
 *
 * 代码实现：
 * int[] result;
 * k = nums.size - 1 //下标
 * for(i = 0 ; j = nums.size - 1 ; i <= j){
 *      if(nums[i] * nums[i] > nums[j] * nums[j]){
 *          result[k] = nums[i] * nums[i];
 *          k--;
 *          i++;
 *      }
 *      else{
 *          result[k] = nums[j] * nums[j];
 *          k--;
 *          j--;
 *      }
 * }
 **/

/**977.有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。**/
import java.util.Arrays;

public class sortedSquares {
    //排序法
    public int[] sortedSquares(int[] nums){
        for(int i = 0 ; i < nums.length ; i++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    //双指针法
    public int[] sortSquares2(int[] nums){
        int right = nums.length - 1;
        int left = 0;
        int [] result = new int[nums.length];
        int index = result.length - 1;
        while(left <= right){
            if(nums[left] * nums[left] > nums[right] * nums[right]){
                result[index--] = nums[left] * nums[left];
                ++left;
            }else{
                result[index--] = nums[right] * nums[right];
                --right;
            }
        }
        return result;
    }
}
