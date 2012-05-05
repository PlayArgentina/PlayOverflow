package models;

import org.joda.time.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;


/**
 * Company entity managed by Ebean
 */
@Entity
public class Question extends Model {

    @Id
    public Long id;
    private long user_id;
    
    @Constraints.Required
    public String description;
    public String title;
    public String tags;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName="id")
    public User questionOwner;
    @Formats.DateTime(pattern="yyyy-MM-dd")
    public DateTime publish_date;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Answer> answers;
    
    
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


