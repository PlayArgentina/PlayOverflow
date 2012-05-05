package controllers;

import models.*;
import play.*;
import play.cache.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
	
	
	
	/**
	 * This result directly redirect to application home.
	 */
	public static Result GO_HOME = redirect(routes.Questions.index());

	public static Result index() {
		
		return ok(index.render("Your new application is ready."));
	}

  
}