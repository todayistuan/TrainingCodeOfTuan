/**
 * 哈希法解题：
 * a到z ASCII连续---hash[26]
 * 数值小-数组 数值大-set k对应value-map
 * 这题数组
 *
 * 代码实现：
 * int hash[26] //默认数组里的值都是0
 * for(i = 0; i < ssize ; i++){
 *     hash[s[i] - 'a']++;
 *     }
 * for(i = 0;i < tsize ; i++){
 *         hash[t[i]-'a']--;
 *     }
 * for(i = 0; i < 26; i++){
 *          if(hash[i] != 0) return false;
 *  }
 * return true;
 *
 *
 **/

/**
 * 242.有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 示例 1: 输入: s = "anagram", t = "nagaram" 输出: true
 **/

package HashTable;

public class isAnagram {
    public boolean isAnagram(String s , String t){
        int[] record = new int[26];

        for(int i = 0 ; i < s.length() ; i++){
            record[s.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i < t.length() ; i++){
            record[t.charAt(i) - 'a']--;
        }

        for(int count:record){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
}
