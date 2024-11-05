/**
 * 四数之和，和三数之和 是一个思路，都是使用双指针法, 基
 * 本解法就是在三数之和的基础上再套一层for循环。
 * 四数之和的双指针解法是两层for循环nums[k] + nums[i]为确定值，依然是循环内有left和right下标作为双指针，
 * 找出nums[k] + nums[i] + nums[left] + nums[right] == target的情况
 **/

/**
 * 18.四数之和
 * 题意：给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 **/
package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int k = 0 ; k < nums.length ; k++){
            if(nums[k] > target && nums[k] >= 0){
                break;
            }
            if(k > 0 && nums[k] == nums[k - 1]){
                continue;
            }
            for(int i = k + 1 ; i < nums.length ; i++){
                if(nums[k] + nums[i] > target && nums[k] + nums[i] >=0){
                    break;
                }
                if(i > k + 1 && nums[i] == nums[i - 1]){
                    continue;
                }
                int left = i + 1;
                int right = nums.length - 1;
                while(right > left){
                    long sum = (long)nums[k] + nums[i] + nums[left] + nums[right];
                    if(sum > target){
                        right--;
                    }else if(sum < target){
                        left++;
                    }else{
                        result.add(Arrays.asList(nums[k] , nums[i] , nums[left] , nums[right]));
                        while(right > left && nums[right] == nums[right - 1]) right--;
                        while(right > left && nums[left] == nums[left + 1])left++;

                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        fourSum solution = new fourSum();
        int[] nums = {1 , 0 , -1 , 0 , -2 , 2};
        int target = 0;
        List<List<Integer>> results = fourSum.fourSum(nums,target);
        for(List<Integer> result : results){
            System.out.println(result);
        }
    }
}
