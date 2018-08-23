package leetcode.simple.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kingdompin@163.com
 * @link <a>https://leetcode-cn.com/problems/pascals-triangle/description/</a>
 * @date 2018/8/23 上午11:55
 */
public class PascalsTriangle {

	public static void main(String[] args) {
		new PascalsTriangle().generate(0);
	}

	/**
	 * 常规解法：递归生成
	 * 1ms 99.33%
	 * @param numRows
	 * @return
	 */
	public List<List<Integer>> generate(int numRows) {
		if (numRows == 1) {
			List<Integer> oneRow = new ArrayList<>();
			oneRow.add(1);
			List<List<Integer>> list = new ArrayList<>();
			list.add(oneRow);
			return list;
		} else if (numRows <= 0) {
			return new ArrayList<>();
		}
		
		List<List<Integer>> list = generate(numRows - 1);
		List<Integer> lastRow = list.get(numRows - 2);
		List<Integer> nextRow = new ArrayList<>();
		nextRow.add(1);
		for (int i = 0; i < lastRow.size() - 1; i++) {
			nextRow.add(lastRow.get(i)+ lastRow.get(i+1));
		}
		nextRow.add(1);
		// 下一行加入结果
		list.add(nextRow);
		return list;
	}
}
