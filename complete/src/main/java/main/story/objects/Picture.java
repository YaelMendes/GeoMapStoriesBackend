package main.story.objects;

import lombok.Getter;
import lombok.Setter;
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