package Array;

/**
 *Ⅰ数组理论基础：
 * 数组上的删除实际是覆盖，内存空间实际并没有变
 *
 * Ⅱ库函数使用：
 * 能一下解决的不用，步骤所需要的用
 * 暴力解法：双for循环
 *
 * Ⅲ双指针思路：
 * 用双指针解决了一个for循环
 * 快指针指向新数组所需要的元素（删除val后剩下的元素）
 * 慢指针就是新数组的下标值
 * 因此将快指针的值赋给慢指针就可以了
 *
 * Ⅳ代码实现：
 * slow = 0;
 * for(fast = 0;fast < nums.size;fast++){ //快指针移动操作
 *     if(nums[fast] != val){
 *         nums[slow] = nums[fast];
 *         slow++;
 *     }
 * }
 * return slow; //返回新数组的大小
 *
 **/

/**27.给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
 返回 k**/
public class RemoveElement {
    public int removeElement(int[] nums, int val){
        //快慢指针
        int slow = 0;
        for(int fast = 0 ; fast < nums.length; fast++){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public int removeElement2(int[] nums , int val){
        //相向双指针
        int left = 0;
        int right = nums.length - 1;
        while(right >= 0 && nums[right] == val){
            right --;
        }
        while(left <= right){
            if(nums[left] == val){
                nums[left] = nums[right];
                right--;
            }
            left++;
            while(right >= 0 && nums[right] == val){
                right--;
            }
        }
        return left;
    }

    public int removeElement3(int[] nums , int val){
        // 相向双指针法2
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            if(nums[left] == val){
                nums[left] = nums[right];
                right--;
            }else{
                //兼容right指针指向的值与val相等的情况
                left++;
            }
        }
        return left;
    }
}
