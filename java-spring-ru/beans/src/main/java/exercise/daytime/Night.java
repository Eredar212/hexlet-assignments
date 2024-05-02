package exercise.daytime;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

public class Night implements Daytime {
    private String name = "night";

    public String getName() {
        return name;
    }

    // BEGIN
    @PostConstruct
    @Scope("prototype")
    public void log() {
        System.out.println(String.format("Bean day is created at %s", LocalDateTime.now()));
    }
    // END
}
