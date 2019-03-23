package readme;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/9/13 13:37
 * @project: cc-leetcode
 */
public class LeetcodeReadmeQInfo extends LeetcodeQuestionInfo {

    /**
     * date : 2018-09-09
     * answerAddress : 答案
     */

    private String date;
    private String answerAddress;

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
        return "LeetcodeReadmeQInfo{" +
                "date='" + date + '\'' +
                ", answerAddress='" + answerAddress + '\'' +
                "} " + super.toString();
    }
}
