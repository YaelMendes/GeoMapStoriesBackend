package main.story;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by yme on 13.01.2017.
 */


@RestController
@RequestMapping("/story")
public class StoryController {

    @Autowired
    private StoryRepository storyRepository;

    @RequestMapping("/all")
    public List<Story> allStories() {
      /*  return Arrays.asList(
                new Story("a story -description-  from back", LocalDate.of(1979, 05, 24)),
                new Story("another story -description-  from back", LocalDate.of(1976, 06, 07)));
     */
       return storyRepository.findAll();
    }

    @RequestMapping("/one")
    public String getOne() {
        return "just a simple text for now";
    }

    @RequestMapping("/insert")
    public void insert(@RequestParam(value="description", defaultValue="descr. default value") String description) {
        storyRepository.save(new Story(description, LocalDate.now()));
    }

}
