package leetcode.simple.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kingdompin@163.com
 * @link <a>https://leetcode-cn.com/problems/pascals-triangle-ii/description/</a>
 * @date 2018/8/23 下午12:58
 */
public class PascalsTriangleII {

	public static void main(String[] args) {

	}

	/**
	 * 个人解法：递归
	 * 1ms 98.61%
	 * @param rowIndex
	 * @return
	 */
	public List<Integer> getRow(int rowIndex) {
		if (rowIndex == 0) {
			List<Integer> oneRow = new ArrayList<>();
			oneRow.add(1);
			return oneRow;
		} else if (rowIndex < 0) {
			return new ArrayList<>();
		}
		
		List<Integer> lastRow = getRow(rowIndex - 1);
		// 生成下一行
		List<Integer> nextRow = new ArrayList<>();
		nextRow.add(1);
		for (int i = 0; i < lastRow.size() - 1; i++) {
			nextRow.add(lastRow.get(i)+ lastRow.get(i+1));
		}
		nextRow.add(1);
		return nextRow;
	}
}
