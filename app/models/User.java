package models;

import java.util.List;
import java.util.*;
import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.data.validation.Constraints;
import play.db.ebean.Model;

/**
 * Computer entity managed by Ebean
 */
@Entity
public class User extends Model {

    @Id
    public Long id;
    
    @Constraints.Required
    public String username;
    
    @Constraints.Required
    public String password;
    
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
    
//    /**
//     * Generic query helper for entity Computer with id Long
//     */
//    public static Finder<Long,Computer> find = new Finder<Long,Computer>(Long.class, Computer.class); 
//    
//    /**
//     * Return a page of computer
//     *
//     * @param page Page to display
//     * @param pageSize Number of computers per page
//     * @param sortBy Computer property used for sorting
//     * @param order Sort order (either or asc or desc)
//     * @param filter Filter applied on the name column
//     */
//    public static Page<Computer> page(int page, int pageSize, String sortBy, String order, String filter) {
//        return 
//            find.where()
//                .ilike("name", "%" + filter + "%")
//                .orderBy(sortBy + " " + order)
//                .fetch("company")
//                .findPagingList(pageSize)
//                .getPage(page);
//    }
    
}

