package controllers;

import models.*;
import play.*;
import play.cache.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
	
	public static User getCurrentUser() {
		String id = session("user_id");
		if (id == null) {
			return null;
		}
		User u = (User) Cache.get(id);
		if (u == null) {
			Integer idVal = Integer.valueOf(id);
			u = User.find.where().idEq(idVal).findUnique();
			Cache.set("user_" + id, u);
		}
		return u;
	}
	
	/**
	 * This result directly redirect to application home.
	 */
	public static Result GO_HOME = redirect(routes.Application.index());

	public static Result index() {
		
		return ok(index.render("Your new application is ready."));
	}

  
}