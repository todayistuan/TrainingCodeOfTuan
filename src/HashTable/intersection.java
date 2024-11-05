/**
 * 解题思路：
 * 数值很大/数值很分散--不用数组，用set
 * nums1转为hash nums2遍历每一个元素查询hash是否出现 放进result去重
 *
 * set解决:
 * unorderset result
 * unorderset num.set(nums1)
 * for(i = 0 ; i < sum2.size ; i++){
 *     if(nums_set.find(nums[i]) != nums_set.end()){
 *         result.insert(nums2[i])
 *     }
 * }
 * return vector(result)
 *
 * 数组解决
 * int hash(1005) = {0}
 * for(i = 0 ; i < nums.size ; i++){
 *     hash[nusm[i]] = 1;
 *     for(i = 0 ; i < nums2.size ; i++){
 *         if(hash[nums2[i]] == 1){
 *             result.insert(nums2[i])
 *         }
 *     }
 *     return vector(result)
 * }
 **/

/**
 * 349.两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集
 **/

package HashTable;
import java.util.HashSet;
import java.util.Set;
public class intersection {
    //hashset
    public int[] intersection(int [] nums1 , int[] nums2){
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for(int i : nums1){
            set1.add(i);
        }

        for(int i : nums2){
            if(set1.contains(i)){
                result.add(i);
            }
        }

        return result.stream().mapToInt(x -> x).toArray();
    }
}
