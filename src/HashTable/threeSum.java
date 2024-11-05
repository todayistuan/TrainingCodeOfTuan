/**
 * 三数之和 这道题目使用双指针法 要比哈希法高效一些
 * a + b + c = 0 三元组去重
 * for a / for b / 0 - (a-b)即c
 *
 * abc三个数都要去重
 *
 *不能有重复的三元组，但三元组内的元素是可以重复的！所以要判断前一位是不是一样的元素，而不是后一位
 **/

/**
 * 15.三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意： 答案中不可以包含重复的三元组。
 **/

package HashTable;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class threeSum {
    //双指针
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > 0){
                return result;
            }

            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while(right > left){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum > 0){
                    right--;
                }else if(sum < 0){
                    left++;
                }else{
                    result.add(Arrays.asList(nums[i] , nums[left] , nums[right]));

                    while(right > left && nums[right] == nums[right - 1]) right--;
                    while(right > left && nums[left] == nums[left + 1])left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
