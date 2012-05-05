package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints;
import play.db.ebean.Model;

@Entity
public class Answer extends Model{
	
	@Id
	public long id;
	
	@Constraints.Required
	public String description;
	
	@ManyToOne
	public User user;
	
	public static Model.Finder<Long,Answer> find = new Model.Finder<Long,Answer>(Long.class, Answer.class);
    
	
	
}
