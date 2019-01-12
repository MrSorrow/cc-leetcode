package leetcode.mid;

import java.util.Comparator;
import java.util.List;

/**
 * @description: 56. 合并区间
 * @see: <a>https://leetcode-cn.com/problems/merge-intervals/</a>
 * @author: guoping wang
 * @date: 2019/1/12 15:52
 * @project: cc-leetcode
 */
public class MergeIntervals {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    /**
     * 个人常规解法：先排序，然后挨个进行merge
     * 21ms 77.56%
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        merge(intervals, 0);

        return intervals;
    }

    private void merge(List<Interval> intervals, int index) {
        if (index >= intervals.size()) return;
        Interval one = intervals.get(index);
        Interval sec = intervals.get(index + 1);
        if (sec.start > one.end) {
            merge(intervals, index + 1);
        } else {
            intervals.remove(index + 1);
            intervals.get(index).end = Math.max(one.end, sec.end);
            merge(intervals, index);
        }
    }
}
