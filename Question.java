package database;

enum QuestionType {
    MULTIPLE_CHOICE,
    TEXT_INPUT,
    RATING_SCALE
}
public class Question {
    private String questionText;
    private QuestionType questionType;

    public Question(String questionText, QuestionType questionType) {
        this.setQuestionText(questionText);
        this.setQuestionType(questionType);

}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}
}
