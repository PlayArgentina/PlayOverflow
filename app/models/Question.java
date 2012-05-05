package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;


import com.avaje.ebean.*;


/**
 * Company entity managed by Ebean
 */
@Entity
@Table(name = "questions")
public class Question extends Model {

    @Id
    public Long id;
    private long userId;
    
    @Constraints.Required
    public String description;
    public String title;
    public String tags;
    @ManyToOne(optional = false)
      @JoinColumn(name = "userId", referencedColumnName="id")
    public User questionOwner;
    
    
    /**
     * Generic query helper for entity Company with id Long
     */
    public static Model.Finder<Long,Question> find = new Model.Finder<Long,Question>(Long.class, Question.class);

    public static Map<String,Question> options() {
        LinkedHashMap<String,Question> options = new LinkedHashMap<String,Question>();
        for(Question c: Question.find.orderBy("title").findList()) {
            options.put(c.id.toString(), c);
        }
        return options;
    }

}

