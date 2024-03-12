package database;

import java.util.List;

public class Survey {
	private String title;
    private List<Question> questions;

    public Survey(String title, List<Question> questions) {
        this.setTitle(title);
        this.setQuestions(questions);
}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}

