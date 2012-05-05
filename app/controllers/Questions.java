package controllers;

import models.Question;
import play.*;
import play.mvc.*;

import views.html.*;

public class Questions extends Controller {
  
  public static Result index() {
    return ok(views.html.questions.list.render(Question.find.all()));
  }
  
  
}