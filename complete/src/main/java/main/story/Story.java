package main.story;

import org.springframework.data.annotation.Id;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Created by YME on 09.01.2017.
 */
@Getter
@Setter
public class Story {

    @Id
    public String id;

    private String description;
    private LocalDate begin;

    public Story(String description, LocalDate begin) {
        this.description = description;
        this.begin = begin;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Story story = (Story) o;

        if (description != null ? !description.equals(story.description) : story.description != null) return false;
        return begin.equals(story.begin);
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + begin.hashCode();
        return result;
    }
}
