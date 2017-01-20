package main.story;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by jpe on 19.01.2017.
 */
@Document
@Getter
@Setter
public class Picture
{
    private String path;
}