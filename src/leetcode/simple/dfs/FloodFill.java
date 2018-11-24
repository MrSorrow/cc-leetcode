package leetcode.simple.dfs;

import leetcode.utils.ArrayUtils;

/**
 * @description: 733. 图像渲染
 * @see: <a>https://leetcode-cn.com/problems/flood-fill/</a>
 * @author: guoping wang
 * @date: 2018/11/24 19:44
 * @project: cc-leetcode
 */
public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {{0, 0, 0}, {0, 1, 0}};
        ArrayUtils.printInt2DArray(new FloodFill().floodFill(image, 1, 1, 2));
    }

    /**
     * 个人常规解法：递归DFS
     * 12ms 97.45%
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        return image[sr][sc] == newColor ? image : floodFillCir(image, sr, sc, image[sr][sc], newColor);
    }

    /**
     * 个人常规解法: 递归解法，代码比较冗余，执行流程其实就是DFS
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFillCir(int[][] image, int sr, int sc, int oldColor, int newColor) {
        image[sr][sc] = newColor;
        if (sr < image.length - 1 && sr > 0) {
            // 内部
            if (sc < image[0].length - 1 && sc > 0) {
                // 内部
                if (image[sr][sc-1] == oldColor) {
                    image[sr][sc-1] = newColor;
                    image = floodFillCir(image, sr, sc - 1, oldColor, newColor);
                }
                if (image[sr+1][sc] == oldColor) {
                    image[sr+1][sc] = newColor;
                    image = floodFillCir(image, sr + 1, sc, oldColor, newColor);
                }
                if (image[sr][sc+1] == oldColor) {
                    image[sr][sc+1] = newColor;
                    image = floodFillCir(image, sr, sc + 1, oldColor, newColor);
                }
                if (image[sr-1][sc] == oldColor) {
                    image[sr-1][sc] = newColor;
                    image = floodFillCir(image, sr - 1, sc, oldColor, newColor);
                }
            } else if (sc == 0) {
                // 左边界
                if (image[sr+1][sc] == oldColor) {
                    image[sr+1][sc] = newColor;
                    image = floodFillCir(image, sr + 1, sc, oldColor, newColor);
                }
                if (image[sr][sc+1] == oldColor) {
                    image[sr][sc+1] = newColor;
                    image = floodFillCir(image, sr, sc + 1, oldColor, newColor);
                }
                if (image[sr-1][sc] == oldColor) {
                    image[sr-1][sc] = newColor;
                    image = floodFillCir(image, sr - 1, sc, oldColor, newColor);
                }

            } else if (sc == image[0].length - 1) {
                // 右边界
                if (image[sr][sc-1] == oldColor) {
                    image[sr][sc-1] = newColor;
                    image = floodFillCir(image, sr, sc - 1, oldColor, newColor);
                }
                if (image[sr+1][sc] == oldColor) {
                    image[sr+1][sc] = newColor;
                    image = floodFillCir(image, sr + 1, sc, oldColor, newColor);
                }
                if (image[sr-1][sc] == oldColor) {
                    image[sr-1][sc] = newColor;
                    image = floodFillCir(image, sr - 1, sc, oldColor, newColor);
                }
            }

        } else if (sr == 0) {
            // 上边界
            if (sc < image[0].length - 1 && sc > 0) {
                // 内部
                if (image[sr][sc-1] == oldColor) {
                    image[sr][sc-1] = newColor;
                    image = floodFillCir(image, sr, sc - 1, oldColor, newColor);
                }
                if (image[sr+1][sc] == oldColor) {
                    image[sr+1][sc] = newColor;
                    image = floodFillCir(image, sr + 1, sc, oldColor, newColor);
                }
                if (image[sr][sc+1] == oldColor) {
                    image[sr][sc+1] = newColor;
                    image = floodFillCir(image, sr, sc + 1, oldColor, newColor);
                }
            } else if (sc == 0) {
                // 左边界
                if (image[sr+1][sc] == oldColor) {
                    image[sr+1][sc] = newColor;
                    image = floodFillCir(image, sr + 1, sc, oldColor, newColor);
                }
                if (image[sr][sc+1] == oldColor) {
                    image[sr][sc+1] = newColor;
                    image = floodFillCir(image, sr, sc + 1, oldColor, newColor);
                }

            } else if (sc == image[0].length - 1) {
                // 右边界
                if (image[sr][sc-1] == oldColor) {
                    image[sr][sc-1] = newColor;
                    image = floodFillCir(image, sr, sc - 1, oldColor, newColor);
                }
                if (image[sr+1][sc] == oldColor) {
                    image[sr+1][sc] = newColor;
                    image = floodFillCir(image, sr + 1, sc, oldColor, newColor);
                }
            }
        } else if (sr == image.length - 1) {
            // 下边界
            if (sc < image[0].length - 1 && sc > 0) {
                // 内部
                if (image[sr][sc-1] == oldColor) {
                    image[sr][sc-1] = newColor;
                    image = floodFillCir(image, sr, sc - 1, oldColor, newColor);
                }
                if (image[sr][sc+1] == oldColor) {
                    image[sr][sc+1] = newColor;
                    image = floodFillCir(image, sr, sc + 1, oldColor, newColor);
                }
                if (image[sr-1][sc] == oldColor) {
                    image[sr-1][sc] = newColor;
                    image = floodFillCir(image, sr - 1, sc, oldColor, newColor);
                }
            } else if (sc == 0) {
                // 左边界
                if (image[sr][sc+1] == oldColor) {
                    image[sr][sc+1] = newColor;
                    image = floodFillCir(image, sr, sc + 1, oldColor, newColor);
                }
                if (image[sr-1][sc] == oldColor) {
                    image[sr-1][sc] = newColor;
                    image = floodFillCir(image, sr - 1, sc, oldColor, newColor);
                }

            } else if (sc == image[0].length - 1) {
                // 右边界
                if (image[sr][sc-1] == oldColor) {
                    image[sr][sc-1] = newColor;
                    image = floodFillCir(image, sr, sc - 1, oldColor, newColor);
                }
                if (image[sr-1][sc] == oldColor) {
                    image[sr-1][sc] = newColor;
                    image = floodFillCir(image, sr - 1, sc, oldColor, newColor);
                }
            }
        }
        return image;
    }
}
