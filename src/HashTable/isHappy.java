/**
 * 202.快乐数
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，
 * 也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 **/

package HashTable;

import java.util.HashSet;
import java.util.Set;
public class isHappy {
    public boolean isHappy(int n){
        Set<Integer> record = new HashSet<>();
        while(n != 1 && !record.contains(n)){
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    private int getNextNumber(int n){
        int res = 0;
        while(n > 0){
            int temp = n % 10;
            res += temp * temp;
            n = n / 10; //去掉当前最低位，以便在下一次循环中继续处理更高位。
        }
        return res;
    }
}
