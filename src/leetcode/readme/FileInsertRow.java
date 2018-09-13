package leetcode.readme;

import java.io.*;

public class FileInsertRow {

    /**
     * 在文件里面的指定行插入一行数据
     *
     * @param inFile           文件
     * @param lineno           行号
     * @param lineToBeInserted 要插入的数据
     * @throws Exception IO操作引发的异常
     */
    public static void insertStringInFile(File inFile, int lineno, String lineToBeInserted)
            throws Exception {
        // 临时文件
        File outFile = File.createTempFile("name", ".tmp");
        // 输入
        FileInputStream fis = new FileInputStream(inFile);
        BufferedReader in = new BufferedReader(new InputStreamReader(fis));
        // 输出
        FileOutputStream fos = new FileOutputStream(outFile);
        PrintWriter out = new PrintWriter(fos);
        // 保存一行数据
        String thisLine;
        // 行号从1开始
        int i = 1;
        while ((thisLine = in.readLine()) != null) {
            // 如果行号等于目标行，则输出要插入的数据
            if (i == lineno) {
                out.println(lineToBeInserted);
            }
            // 输出读取到的数据
            out.println(thisLine);
            // 行号增加
            i++;
        }
        out.flush();
        out.close();
        in.close();
        // 删除原始文件
        inFile.delete();
        // 把临时文件改名为原文件名
        outFile.renameTo(inFile);
    }

    /**
     * 检查在哪一行插入
     * @param id
     * @param inFile
     * @return
     */
    public static int checkInsertPosition(Integer id, File inFile) {
        // 输入
        FileInputStream fis = null;
        BufferedReader in = null;
        try {
            fis = new FileInputStream(inFile);
            in = new BufferedReader(new InputStreamReader(fis));
            String thisLine = null;
            int insertLine = 1;
            boolean beyondTable = false;
            int questionId = 0;
            while ((thisLine = in.readLine()) != null) {
                if ("".equals(thisLine)) {
                    System.out.println("跳过第" + insertLine + "行，空行...");
                    if (!beyondTable) {
                        insertLine++;
                    }
                    continue;
                }
                try {
                    questionId = Integer.valueOf(thisLine.substring(1, 6).trim());
                } catch (NumberFormatException e) {
                    System.out.println("跳过第" + insertLine + "行，非表格区域...");
                    if (!beyondTable) {
                        insertLine++;
                    }
                    continue;
                }
                // 正常解析到questionId
                if (questionId > 0) {
                    beyondTable = true;
                    if (questionId < id) {
                        insertLine++;
                    } else if (questionId == id) {
                        return -2;
                    } else {
                        break;
                    }
                }
            }
            return insertLine;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }
}