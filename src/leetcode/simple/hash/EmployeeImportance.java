package leetcode.simple.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @description: 690. 员工的重要性
 * @see: <a>https://leetcode-cn.com/problems/employee-importance/</a>
 * @author: guoping wang
 * @date: 2018/10/10 20:30
 * @project: cc-leetcode
 */
public class EmployeeImportance {

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    /**
     * 个人常规解法：hashSet保存已经加过的员工，递归计算
     * 24ms 55.75%
     * @param employees
     * @param id
     * @return
     */
    public int getImportance(List<Employee> employees, int id) {
        HashSet<Integer> askSet = new HashSet<>();
        return getImportanceCir(employees, id, askSet);
    }

    private int getImportanceCir(List<Employee> employees, int id, HashSet<Integer> askSet) {
        // 已计数过
        if (askSet.contains(id)) {
            return 0;
        }

        Employee parent = null;
        for (Employee employee : employees) {
            if (employee.id == id) {
                parent = employee;
                break;
            }
        }
        if (parent == null) {
            return 0;
        }

        int importance = parent.importance;
        for (Integer subordinate : parent.subordinates) {
            importance += getImportanceCir(employees, subordinate, askSet);
        }

        // 标记已计数
        askSet.add(id);

        return importance;
    }

    /**
     * 实际上根本没有重复的子员工，那么就要存储hashMap来加速根据id查找对应的Employee
     * 13ms 81.32%
     * @param employees
     * @param id
     * @return
     */
    public int getImportanceWithoutHashset(List<Employee> employees, int id) {
        HashMap<Integer, Employee> employeesMap = new HashMap<>();
        for (Employee employee : employees) {
            employeesMap.put(employee.id, employee);
        }
        return getImportanceCir(employeesMap, id);
    }

    private int getImportanceCir(HashMap<Integer, Employee> employeesMap, int id) {
        Employee employee = employeesMap.get(id);
        if (employee == null) {
            return 0;
        }

        int importance = employee.importance;
        for (Integer subordinate : employee.subordinates) {
            importance += getImportanceCir(employeesMap, subordinate);
        }

        return importance;
    }
}
