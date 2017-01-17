package main.story;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
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
       return storyRepository.findAll();
    }

    @RequestMapping("/text")
    public String getText() {
        return "just a simple text for now";
    }

    @RequestMapping("/one")
    public Story getOne() {
        return new Story("a short de", LocalDate.now());
    }

    @RequestMapping("/insert")
    public void insert(@RequestParam(value="description", defaultValue="descr. default value") String description) {
        storyRepository.save(new Story(description, LocalDate.now()));
    }

}
