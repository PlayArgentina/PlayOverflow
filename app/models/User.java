package models;

import java.util.*;

import javax.persistence.*;

import play.data.validation.*;
import play.db.ebean.*;

/**
 * Computer entity managed by Ebean
 */
@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames="username"))
public class User extends Model {

    @Id
    public Long id;
    
    
    @Constraints.Required
    public String username;
    
    @Constraints.Required
    public String password;
    
    
    // TODO: esto es horrible, ver como sacar
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@OneToMany
    public List<Question> questions;
    
    public static Finder<Long,User> find = new Finder<Long,User>(Long.class, User.class); 

    public static List<User> getAll() {
    	return find.all();
    }
    
    
    
    
}

