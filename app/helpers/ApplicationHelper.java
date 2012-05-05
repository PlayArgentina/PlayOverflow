package helpers;

import models.*;
import play.cache.*;
import controllers.*;

public class ApplicationHelper {
	public static User getCurrentUser() {
		String id = Application.session("user_id");
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
}
