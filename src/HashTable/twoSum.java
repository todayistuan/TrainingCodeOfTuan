/**
 * 需要查询一个元素是否出现过，或者一个元素是否在集合里的时候，就要第一时间想到哈希法
 * map存放访问过的元素
 * map中的存储结构为 {key：数据元素，value：数组元素对应的下标}。
 * 
 **/

/**
 * 1.两数之和
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 **/
package HashTable;

import java.util.HashMap;
import java.util.Map;
public class twoSum {
    //hash1
    public int[] twoSum(int[] nums , int target){
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                res[1] = i;
                res[0] = map.get(temp);
                break;
            }
            map.put(nums[i] , i);
        }
        return res;
    }

    //hash2
    public int[] twoSum1(int[] nums , int target){
        Map<Integer , Integer> indexMap = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++){
            int balance = target - nums[i];
            if(indexMap.containsKey(balance)){
                return new int[]{i , indexMap.get(balance)};
            }else{
                indexMap.put(nums[i] , i);
            }
        }
        return null;
    }
}
