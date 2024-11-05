/**
 * 整体思路
 * 分组：a + b 和 c + d来匹配
 * a+b是否出现过(key)，出现过的次数（value） ---> map
 * 0-(c+d)    = a+b
 * ↑找这个↑
 *
 * count += value所存的值
 *
 **/

/**
 * 454.四数相加II
 * 给定四个包含整数的数组列表 A , B , C , D ,
 * 计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 **/

package HashTable;
import java.util.Map;
import java.util.HashMap;
public class fourSumCount {
    public int fourSumCount(int[] nums1 , int[] nums2 , int[] nums3 , int[] nums4){
        int res = 0;
        Map<Integer , Integer> map = new HashMap<Integer , Integer>();

        for(int i : nums1){
            for(int j : nums2){
                int sum = i + j;
                map.put(sum , map.getOrDefault(sum , 0) + 1);
            }
        }

        for(int i : nums3){
            for(int j : nums4){
                res += map.getOrDefault(0 - i - j , 0);
            }
        }
        return res;
    }
}
