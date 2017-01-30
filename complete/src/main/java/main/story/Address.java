package main.story;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by yme on 18.01.2017.
 */
@Getter
@Setter
@NoArgsConstructor
public class Address {

    public Address(String firstLine) {
        this.firstLine=firstLine;
    }

    private String firstLine;
}
