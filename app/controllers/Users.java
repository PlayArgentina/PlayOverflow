package controllers;

import models.*;
import play.data.*;
import play.mvc.*;

public class Users extends Controller {
  private static Form<User> localForm = form(User.class);
  
	public static Result list() {
		return ok(views.html.users.list.render(User.find.all()));
	}

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
		Form<User> userForm = localForm;
		
		return ok(views.html.users.login.render(userForm));
	}

	public static Result doLogin() {		
		Form<User> userForm = localForm.bindFromRequest();
        if(userForm.hasErrors()) {
            return badRequest(views.html.users.signup.render(userForm));
        }
        
        User u = User.find.where().eq("username", userForm.get().username)
        				 .eq("password", userForm.get().password).findUnique();

        if (u != null) {
        	flash("success", "You have logged in!");
        	
        	System.out.println("user login" + u.id);
        	session().put("user_id", u.id.toString());
        	
        	return redirect("/");
        } else {
        	flash("error", "You have NOT logged in!");
        	return redirect("/login");
        }
	}

	public static Result doLogout() {
		flash("success", "You have logged out!");
		session().remove("user_id");
		return redirect("/");
	}

}