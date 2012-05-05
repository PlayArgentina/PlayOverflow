package models;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
    
    @ManyToOne
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


