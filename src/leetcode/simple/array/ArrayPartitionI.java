package leetcode.simple.array;

import java.util.Arrays;

/**
 * @description: 561. 数组拆分 I
 * @link: <a>https://leetcode-cn.com/problems/array-partition-i/description/</a>
 * @author: guoping wang
 * @date: 2018/8/29 16:56
 * @project: cc-leetcode
 */
public class ArrayPartitionI {

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        System.out.println(new ArrayPartitionI().arrayPairSumSort(nums));
        System.out.println(new ArrayPartitionI().arrayPairSum(nums));
    }

    /**
     * 个人常规解法：排序完按顺序输出奇数和
     * 34ms 64.27%
     * @param nums
     * @return
     */
    public int arrayPairSumSort(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i = i + 2) {
            sum += nums[i];
        }
        return sum;
    }

    /**
     * 最优算法：注意题目条件范围
     * 先构造出一个大数组，数组下标对应就是要排序的数的值，数组的值则存放有多少重复的数
     * 然后每奇数次取一次值相加，取的时候把大数组中的每一个值全部取到减为0为止
     * 14ms 99.77%
     */
    public int arrayPairSum(int[] nums) {
        // 最大给定长度可以达到2n，即20000
        int[] newArray = new int[20001];
        for(int i = 0; i < nums.length; i++)
            // newArray对应索引 - 10000即为原始值
            newArray[nums[i] + 10000]++;

        int sum = 0;
        // odd的作用是每隔一个数便加一次
        boolean odd = true;

        for(int i = 0; i < newArray.length; i++){
            while(newArray[i] > 0){
                if(odd)
                    sum += i - 10000;
                odd = !odd;
                newArray[i]--;
            }
        }
        return sum;
    }

}
