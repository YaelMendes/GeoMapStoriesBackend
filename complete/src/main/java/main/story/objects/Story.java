package main.story.objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by YME on 09.01.2017.
 */
@Getter
@Setter
@NoArgsConstructor
@Document
public class Story {

    @Id
    public ObjectId id;

    @NotNull
    private String description;
    private Address address;
    private Date begin;

   /* private Set<Picture> pictures;
    @DBRef
    @JsonManagedReference
    private Set<Person> persons;*/

  //  public Story() {}

    public Story(String description, Address address, Date begin) {
        this.description = description;
        this.address = address;
        this.begin = begin;
    /*    this.pictures = new HashSet<>();
        this.persons = new HashSet<>();*/
    }
}
