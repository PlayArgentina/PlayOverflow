package controllers;

import models.*;
import play.data.*;
import play.mvc.*;

public class Users extends Controller {
  private static Form<User> localForm = form(User.class);

	public static Result signUp() {
		Form<User> userForm = localForm;
		return ok(views.html.users.signup.render(userForm));
	}

	public static Result doSignUp() {
    Form<User> userForm = localForm.bindFromRequest();
        if(userForm.hasErrors()) {
            return badRequest(views.html.users.signup.render(userForm));
        }
        userForm.get().save();
        flash("success", "Computer " + userForm.get().username + " has been created");
        return Application.GO_HOME;
	}

	public static Result login() {
		return null;
	}

	public static Result doLogin() {
		return null;
	}

	public static Result doLogout() {
		// return ok(index.render("Users."));
		return null;
	}

}