package hello;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "Events")
public class Event {

    @CreationTimestamp
    private java.util.Date created_at;
    @UpdateTimestamp
    private java.util.Date updated_at;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Long userId;
    protected Event() {}

    public Event(String name, String description, Long userId) {
        this.name = name;
        this.description = description;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return String.format(
                "Event[id=%d, name='%s', description='%s', user = '%d']",
                id, name, description, userId);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getUserId() {
        return userId;
    }

    public Date getCreated_at() {
        return created_at;
    }
}
