package controllers;

import models.Answer;
import models.Question;
import play.mvc.Controller;
import play.mvc.Result;

public class Questions extends Controller {

	public static Result index() {
		return ok(views.html.questions.list.render(Question.find.all()));

	}

	public static Result showQuestion(String questionId) {

		Question question = Question.find.byId(Long.valueOf(questionId));

		if (question == null) {
			return notFound("Question not found");
		} else {
			return ok(views.html.questions.view.render(question, form(Answer.class)));
		}
	}
	
	public static Result answerQuestion() {
		return null;
	}
	
	
	
}
