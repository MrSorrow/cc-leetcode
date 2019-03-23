package readme;

/**
 * @description: 剑指Offer的题解表格bean
 * @author: guoping wang
 * @date: 2019/3/23 12:03
 * @project: cc-leetcode
 */
public class Sword2OfferQInfo {

    /**
     * questionId : 题号
     * questionTitle : 题目名称地址
     * date : 2018-09-09
     * answerAddress : 答案
     */

    private String questionId;
    private String questionTitle;
    private String date;
    private String answerAddress;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAnswerAddress() {
        return answerAddress;
    }

    public void setAnswerAddress(String answerAddress) {
        this.answerAddress = answerAddress;
    }

    @Override
    public String toString() {
        return "Sword2OfferQInfo{" +
                "questionId='" + questionId + '\'' +
                ", questionTitle='" + questionTitle + '\'' +
                ", date='" + date + '\'' +
                ", answerAddress='" + answerAddress + '\'' +
                '}';
    }
}
