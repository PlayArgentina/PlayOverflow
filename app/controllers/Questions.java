package controllers;

import helpers.*;
import models.*;
import play.*;
import play.data.*;
import play.mvc.*;

import views.html.*;

import java.util.Map;

import models.Answer;
import models.Question;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Questions extends Controller {
	private static Form<Question> localForm = form(Question.class);

	public static Result index() {
		return ok(views.html.questions.list.render(Question.find.all()));

	}
	
	public static Result newQuestion() {
		User user = ApplicationHelper.getCurrentUser();
		if (user == null) {
			flash("error", "You need to login!");
			return redirect(routes.Questions.index());
		}
		Form<Question> questionForm = localForm;
		
		return ok(views.html.questions.newquestion.render(questionForm));
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
		Form<Answer> answeForm = form(Answer.class).bindFromRequest();
		if (answeForm.hasErrors())
			 return badRequest(views.html.index.render("Hola"));
		
		answeForm.get().save();
		return redirect(routes.Questions.showQuestion(answeForm.get().question.id.toString()));
	}
	

	public static Result create() {
		
		Form<Question> questionForm = localForm.bindFromRequest();
		if (questionForm.hasErrors()) {
			return badRequest(views.html.index.render("Error"));
		}
		
		questionForm.get().save();
		
		return redirect(routes.Questions.showQuestion(questionForm.get().id.toString()));
	}

	public static Result voteAnswer(String answerId) {
	   Answer  answer = Answer.find.byId(Long.valueOf(answerId));
	   answer.votes +=1;
	   answer.save();
	return 	ok();
	}
	
}
