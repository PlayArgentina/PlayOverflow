import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

import java.util.Date;
import java.util.List;

import models.Answer;
import models.Question;

import org.joda.time.*;
import org.junit.Test;

public class ModelTest {
    
    private String formatted(Date date) {
        return new java.text.SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    @Test
    public void findById() {
        running(fakeApplication(), new Runnable() {
           public void run() {
               Question macintosh = Question.find.byId(1l);
               assertThat(macintosh.title).isEqualTo("Macintosh");
               assertThat(formatted(macintosh.publish_date)).isEqualTo("1991-01-01");
           }
        });
    }
    @Test
    public void findAnswer(){
    	running(fakeApplication(), new Runnable(){
    		public void run(){
    			Question quest = Question.find.byId(1l);
    			List<Answer> ans = quest.answers;
    			assertThat(ans.size()>0);
    			
    		}
    	});
    }
    
}
