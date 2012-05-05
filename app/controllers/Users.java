package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Users extends Controller {
  
  public static Result index() {
    return ok(index.render("Users."));
  }
  
  
}