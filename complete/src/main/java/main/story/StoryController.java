package main.story;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yme on 13.01.2017.
 */


@RestController
@RequestMapping("/story")
//@CrossOrigin(origins = "http://localhost:3000/stories", maxAge = 3600)
public class StoryController {

    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/all")
    public List<Story> allStories() {
        List<Story> all = storyRepository.findAll();
        return all;
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
    public Story insert(@RequestParam(value="description", defaultValue="descr. default value") String description) {
        // Create Story
        Story entity = new Story(description, LocalDate.now());

        // Create address
        final Address address = new Address();
        address.setFirstLine("Toulon");
        // Add embeddable address to story
        entity.setAddress(address);

        // Create pictures
        final Picture picture1 = new Picture();
        picture1.setPath("toto.jpg");
        final Picture picture2 = new Picture();
        picture2.setPath("tata.jpg");

        // Add persisted pictures to story
        entity.getPictures().add(picture1);
        entity.getPictures().add(picture2);

        // Persist story
        storyRepository.save(entity);

        // Create persons
        Person person1 = new Person();
        Person person2 = new Person();
        person1.setFirstName("John");
        person1.setLastName("Bob");
        person2.setFirstName("Bob");
        person2.setLastName("Rene");

        person1.getStories().add(entity);
        person2.getStories().add(entity);

        // Persist persons
        personRepository.save(person1);
        personRepository.save(person2);

        // Update story with persons persisted
        entity.getPersons().add(person1);
        entity.getPersons().add(person2);

        storyRepository.save(entity);

        return entity;
    }

}