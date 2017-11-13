package main.story.objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jpe on 19.01.2017.
 */
@Document
@Getter
@Setter
public class Person
{
    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
    @DBRef
    @JsonBackReference
    private Set<Story> stories;

    public Person()
    {
        this.stories = new HashSet<>();
    }
}