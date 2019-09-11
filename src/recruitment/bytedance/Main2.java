package recruitment.bytedance;

/**
 * @description:
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/7/18 4:51 PM
 * @project: cc-leetcode
 */
public class Main2 {

    public boolean find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) return false;
        return find2(target, array, 0, 0, array.length - 1, array[0].length - 1);
    }

    private boolean find(int target, int[][] array, int startR, int startC, int endR, int endC) {
        if (startR == endR && startC == endC) return array[startR][startC] == target;
        if (startR > endR || startC > endC) return false;
        if (startR + 1 >= endR && startC + 1 >= endC) return array[startR][startC] == target || array[startR][endC] == target || array[endR][endC] == target|| array[endR][startC] == target;

        int midR = (startR + endR) / 2, midC = (startC + endC) / 2;

        // 根据对比元素递归查找
        boolean isTrue = find(target, array, startR, midC + 1, midR, endC) || find(target, array, midR + 1, startC, endR, midC);
        if (isTrue) return true;
        else if (array[midR][midC] < target) return find(target, array, midR, midC, endR, endC);
        else if (array[midR][midC] > target) return find(target, array, startR, startC, midR, midC);
        else return true;
    }



    private boolean find2(int target, int[][] array, int startR, int startC, int endR, int endC) {
        // 如果已经超越边界，就可以返回
        if (startR > endR || startC > endC) return false;

        //
        if (array[startR][endC] < target) {
            return find2(target, array, startR + 1, startC, endR, endC);
        } else if (array[startR][endC] > target) {
            return find2(target, array, startR, startC, endR, endC - 1);
        } else {
            return true;
        }
    }


    public static void main(String[] args) {

    }
}
