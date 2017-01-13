package main.story;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yme on 13.01.2017.
 */


@RestController
//@RequestMapping("/main.story")
public class StoryController {

    @RequestMapping("/lol")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return "looool";
    }

    @RequestMapping("/all")
    public List<Story> allStories() {
        return Arrays.asList(new Story("descriptionfrom back"));
    }

}
