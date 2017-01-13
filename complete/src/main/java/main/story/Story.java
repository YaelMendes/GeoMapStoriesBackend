package main.story;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by YME on 09.01.2017.
 */
@Getter
@Setter
public class Story {

    private String description;

    public Story(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Story story = (Story) o;

        return description != null ? description.equals(story.description) : story.description == null;
    }

    @Override
    public int hashCode() {
        return description != null ? description.hashCode() : 0;
    }
}
