package Array;

/**
 *  Ⅰ二分法易错点:
 *  1.小于or小于等于[ while(left <= right) ]
 *  2.middle or middle-1[ if(nums[middle] > target ]
 *
 *  Ⅱ循环不变量:
 *  1.对区间的定义：通常是左闭右开or左闭右闭
 *
 *  Ⅲ左闭右闭写法：
 *  left = 0;
 *  right = numsize - 1;
 *  while(left <= right){
 *      middle = (left + right) / 2;
 *      if(nums[middle] > target){
 *          right = middle - 1;
 *      }
 *      else if(nums[middle] < target){
 *          left = middle + 1;
 *      }
 *      else return middle;
 *  }
 *  return -1;
 *
 *  Ⅳ左闭右开写法：
 *  left = 0;
 *  right = numsize;
 *  while(left < right){
 *      middle = (left + right) / 2;
 *      if(nums[middle] > target){
 *          right = middle;
 *      }
 *      else if(nums[middle < target){
 *          left = middle + 1;
 *      }
 *      else return middle;
 *  }
 *  return -1;

 **/

/**704.给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target
 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1**/
public class BinarySearchAlgorithm {
    //左闭右闭
    public int search(int[] nums,int target){
        if(target < nums[0] || target > nums[nums.length - 1]){
            return -1;
        }
        int left = 0 , right = nums.length - 1;
        while(left <= right){
            int mid = left + ((right - left) >> 1);//>>为右移运算符，右移一位相当于除2，右移n位相当于除以2的n次方，此处防止溢出，等同于(left + right)/2
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }

    //左闭右开
    public int search2(int[] nums,int target){
        int left = 0 , right = nums.length;
        while(left < right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return -1;
    }
}
