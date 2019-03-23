package readme;

/**
 * @description: 获取leetcode-cn官网题目信息的实体类
 * @author: guoping wang
 * @date: 2018/9/13 13:10
 * @project: cc-leetcode
 */
public class LeetcodeQuestionInfo {

    /**
     * questionId : 717
     * questionFrontendId : 717
     * questionTitle : 1-bit and 2-bit Characters
     * questionTitleSlug : 1-bit-and-2-bit-characters
     * translatedTitle : 1比特与2比特字符
     * difficulty : Easy
     */

    private String questionId;
    private String questionFrontendId;
    private String questionTitle;
    private String questionTitleSlug;
    private String translatedTitle;
    private String difficulty;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionFrontendId() {
        return questionFrontendId;
    }

    public void setQuestionFrontendId(String questionFrontendId) {
        this.questionFrontendId = questionFrontendId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionTitleSlug() {
        return questionTitleSlug;
    }

    public void setQuestionTitleSlug(String questionTitleSlug) {
        this.questionTitleSlug = questionTitleSlug;
    }

    public String getTranslatedTitle() {
        return translatedTitle;
    }

    public void setTranslatedTitle(String translatedTitle) {
        this.translatedTitle = translatedTitle;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "LeetcodeQuestionInfo{" +
                "questionId='" + questionId + '\'' +
                ", questionFrontendId='" + questionFrontendId + '\'' +
                ", questionTitle='" + questionTitle + '\'' +
                ", questionTitleSlug='" + questionTitleSlug + '\'' +
                ", translatedTitle='" + translatedTitle + '\'' +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }
}
