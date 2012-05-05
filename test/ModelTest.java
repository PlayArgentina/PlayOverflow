import org.junit.*;

import java.util.*;

import play.mvc.*;
import play.test.*;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

import models.*;

import com.avaje.ebean.*;

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
               assertThat(formatted(macintosh.publish_date)).isEqualTo("1984-01-24");
           }
        });
    }
    
}
