package main.story;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * Created by yme on 13.01.2017.
 */

@RestController
@RequestMapping("/story")
@CrossOrigin(origins = "http://localhost:3000")
public class StoryController {

    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/all")
    public List<Story> allStories() {
        List<Story> all = storyRepository.findAll();
        return all;
    }

    @GetMapping("/text")
    public String getText() {
        return "just a simple text for now";
    }

    @GetMapping("/one")
    public Story getOne() {
        return new Story("a short de", new Address("an address"), Date.from(Instant.now()));
    }

    @PostMapping(path="/insert")
    public Story insertWithBody(@RequestBody Story story) {
    /*    final Address address = new Address("Paname");
        story.setAddress(address);*/

        storyRepository.save(story);

        return story;
    }

    @Deprecated
    @RequestMapping(path="/insertOLD")
    public Story insert(@RequestParam(value="description", defaultValue="descr. default value") String description) {
        // Create Story
        Story entity = new Story(description, new Address("a deprecated address"), Date.from(Instant.now()));

        // Create address
        final Address address = new Address("Toulon");
        // Add embeddable address to story
        entity.setAddress(address);

        // Create pictures
      /*  final Picture picture1 = new Picture();
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
*/
        storyRepository.save(entity);

        return entity;
    }

}