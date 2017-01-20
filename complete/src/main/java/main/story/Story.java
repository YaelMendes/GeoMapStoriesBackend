package main.story;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by YME on 09.01.2017.
 */
@Getter
@Setter
@Document
public class Story {

    @Id
    public ObjectId id;
    private String description;
    private LocalDate begin;
    private Address address;
    private Set<Picture> pictures;
    @DBRef
    @JsonManagedReference
    private Set<Person> persons;

    public Story(String description, LocalDate begin) {
        this.description = description;
        this.begin = begin;
        this.pictures = new HashSet<>();
        this.persons = new HashSet<>();
    }
}
