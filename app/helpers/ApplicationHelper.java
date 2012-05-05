package helpers;

import models.*;

import org.joda.time.*;

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
	
	public static String time_ago_in_words(DateTime time) {
		if (time == null) {
			return "Unknown time ago";
		}
		DateTime now = DateTime.now();
		Days d = Days.daysBetween(time, now);
		return d.getDays() + " days ago";
	}
}
