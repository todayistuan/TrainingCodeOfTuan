/**
 * 赎金信
 * 空间换时间
 * 只有小写字母---长度26的数组记录magazine字母出现的次数 数组比起map简单高效
 * 再用ransomNote去验证数组里是否包含ransomNote所需要的所有字母
 **/

package HashTable;

public class canConstruct {
    public boolean canConstruct(String ransomNote , String magazine){
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        int[] record = new int[26];

        for(char c : magazine.toCharArray()){
            record[c - 'a'] += 1;
        }

        for(char c : ransomNote.toCharArray()){
            record[c - 'a'] -= 1;
        }

        for(int i : record){
            if(i < 0){
                return false;
            }
        }
        return true;
    }
}
