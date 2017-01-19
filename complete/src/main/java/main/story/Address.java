package main.story;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by yme on 18.01.2017.
 */
@Getter
@Setter
@Document
public class Address {

    @Id
    public Integer id;

    private String firstLine;

    public Address(String line) {
        this.firstLine=line;
    }
}
