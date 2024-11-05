package Array;
/**
 * 边界上如何处理：
 * 遵循循环不变量规则（二分法讲过）：左闭右开
 * 不去处理最后一个节点，作为下一条边的初始节点
 *
 * 代码：
 * startx = 0,starty = 0;
 * offset = 1;
 * count = 1;
 * while(n/2){
 *     for(j = starty;j < n - offset;j++){
 *         nums[startx][j] = count++;
 *     }
 *     for(i = startx;i < n -offset;i++){
 *         nums[i][j] = count++;
 *     }
 *     for(;j > starty;j--){
 *         nums[i][j] = count++;
 *     }
 *     for(;i > startx;i--){
 *         nums[i][j] = count++;
 *     }
 * }
 *
 * if(n%2 == 1){
 *     nums[i][j] = count;
 * }
 **/

/**
 * 59.螺旋矩阵II
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 **/

public class generateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int startX = 0, startY = 0;
        int offset = 1;
        int count = 1;
        int loop = 1;
        int i, j;

        while (loop <= n / 2) {
            //顶部
            for (j = startY; j < n - offset; j++) {
                nums[startX][j] = count++;
            }

            //右列
            for (i = startX; i < n - offset; i++) {
                nums[i][j] = count++;
            }

            //底部
            for(; j > startY; j--){
                nums[i][j] = count++;
            }

            //左列
            for(; i > startX; i--){
                nums[i][j] = count++;
            }
            startX++;
            startY++;
            offset++;
            loop++;
        }
        if(n % 2 == 1){
            nums[startX][startY] = count;
        }
        return nums;
    }
}