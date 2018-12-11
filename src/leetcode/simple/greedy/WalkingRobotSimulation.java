package leetcode.simple.greedy;

import java.util.HashSet;
import java.util.Objects;

/**
 * @description: 874. 模拟行走机器人
 * @see: <a>https://leetcode-cn.com/problems/walking-robot-simulation/</a>
 * @author: guoping wang
 * @date: 2018/12/11 20:54
 * @project: cc-leetcode
 */
public class WalkingRobotSimulation {

    static class Coordinate {
        private int x;
        private int y;

        public Coordinate(int[] coordinate) {
            this.x = coordinate[0];
            this.y = coordinate[1];
        }

        public Coordinate goLeft() {
            this.x--;
            return this;
        }

        public Coordinate goRight() {
            this.x++;
            return this;
        }

        public Coordinate goUp() {
            this.y++;
            return this;
        }

        public Coordinate goDown() {
            this.y--;
            return this;
        }

        public int getEdu() {
            return this.x * this.x + this.y * this.y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    /**
     * 个人常规解法：每走一步判断是否碰撞，用HashSet存储碰撞点
     * 31ms 89.52%
     * @param commands
     * @param obstacles
     * @return
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<Coordinate> obstacleSet = new HashSet<>(obstacles.length);
        int orientation = 2;
        Coordinate position = new Coordinate(new int[2]); // 保存当前位置
        int max = 0;

        // 先遍历所有的障碍点
        for (int[] obstacle : obstacles) {
            obstacleSet.add(new Coordinate(obstacle));
        }

        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2) {
                orientation--;
                orientation = orientation < 0 ? 3 : orientation;
            } else if (commands[i] == -1) {
                orientation++;
                orientation = orientation > 3 ? 0 : orientation;
            } else {
                // 移动步数
                switch (orientation) {
                    case 1:
                        // 向左
                        for (int j = 0; j < commands[i]; j++) {
                            if (obstacleSet.contains(position.goLeft())) {
                                position.goRight();
                                break;
                            }
                        }
                        break;
                    case 2:
                        // 向上
                        for (int j = 0; j < commands[i]; j++) {
                            if (obstacleSet.contains(position.goUp())) {
                                position.goDown();
                                break;
                            }
                        }
                        break;
                    case 3:
                        // 向右
                        for (int j = 0; j < commands[i]; j++) {
                            if (obstacleSet.contains(position.goRight())) {
                                position.goLeft();
                                break;
                            }
                        }
                        break;
                    case 0:
                        // 向下
                        for (int j = 0; j < commands[i]; j++) {
                            if (obstacleSet.contains(position.goDown())) {
                                position.goUp();
                                break;
                            }
                        }
                        break;
                }
                if (position.getEdu() > max) {
                    max = position.getEdu();
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] obstacles = {{41,18},{9,-53},{57,-11},{-96,73},{23,37},{71,13},{69,-14},{-12,80},{-23,-51},{29,62},{-39,30},{70,-37},{-24,-1},{-2,-17},{-35,68},{14,60},{-8,-100},{81,-84},{-55,67},{-71,34},{-70,21},{41,-33},{-92,61},{-96,-10},{45,8},{-86,2},{39,5},{-85,-87},{-21,76},{-17,89},{51,-20},{-31,80},{-55,91},{-76,-63},{-82,-33},{-88,16},{86,-80},{87,79},{3,60},{49,83},{86,-20},{-10,-42},{-87,-13},{71,64},{94,-10},{60,-38},{-63,46},{0,96},{46,24},{98,-11},{-21,28},{-58,-43},{58,-88},{-34,-42},{66,-100},{-10,99},{-75,-21},{-24,-12},{81,48},{10,25},{32,47},{40,54},{5,43},{-34,-33},{-64,93},{32,75},{48,-51},{-35,22},{-44,-33},{-33,16},{-12,-63},{-60,-24},{-42,93},{45,-15},{-50,19},{-78,-55},{85,8},{70,-58},{-96,80},{-68,-74},{83,-82},{-59,-64},{76,45},{84,-45},{-49,47},{-21,-76},{-80,64},{98,11},{36,-25},{-75,91},{70,-11},{2,-6},{32,-90},{37,6},{-21,19},{84,29},{56,-62},{-98,3},{-2,-26},{-27,-87},{73,80},{11,89},{-93,45},{17,89},{54,-32},{-83,41},{-59,-61},{-23,2},{-54,-84},{-13,89},{61,54},{24,-24},{-38,96},{6,37},{-99,-91},{-54,43},{-38,70},{-78,9},{-19,-55},{-95,-75},{-19,25},{-7,55},{-74,-27},{18,18},{97,81},{-29,75},{11,62},{-77,99},{-65,-1},{81,-30},{-26,50},{89,16},{98,6},{97,7},{-19,-41},{50,31},{16,-68},{96,-92},{-70,39},{-61,-53},{55,-42},{-80,11},{59,-9},{-78,-7},{-14,14},{-100,-59},{50,-82},{-85,43},{52,10},{-10,-79},{-1,39},{-23,23},{54,12},{-65,-87},{20,-37},{-85,-65},{22,10},{-58,-8},{-76,54},{-18,-34},{-68,39},{1,-5},{-41,24},{-28,75},{-42,87},{54,-21},{94,-11},{-4,-83},{16,-76},{-11,17},{5,27},{77,-56},{24,-87},{-67,82},{51,-65},{-25,-2},{56,36},{39,-79},{-37,-19},{-95,9},{-9,75},{24,74},{91,-11},{14,92},{-34,-31},{-61,-24},{89,-20},{48,-76},{33,-19},{-47,91},{-86,67},{-3,-36},{-1,-33},{-20,-37},{-69,-14},{-79,21},{-100,85},{49,-16},{-91,-38},{-80,-21}};
        int[] commands = {6,-2,-2,-2,4,3,-1,-2,1,-1,5,-1,8,8,1,2,7,3,4,7,8,7,5,-2,3,4,-1,-1,3,8,6,-2,7,7,3,5,-1,2,-2,-2,5,-1,-1,7,8,5,-1,1,-1,-2,5,4,2,1,1,6,-1,-1,-2,1,3,3,5,5,6,-1,2,-2,4,-1,-2,-2,1,5,-1,7,4,7,7,6,5,5,9,-1,-2,8,-1,-1,8,-1,6,8,4,-2,-2,-2,1,3,9,4};
        System.out.println(new WalkingRobotSimulation().robotSim(commands, obstacles));
    }
}
