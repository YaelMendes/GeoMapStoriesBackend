package main.story.controller;

import main.story.objects.Address;
import main.story.objects.Story;
import main.story.repository.PersonRepository;
import main.story.repository.PictureRepository;
import main.story.repository.StoryRepository;
import org.bson.types.ObjectId;
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
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
public class StoryController {

    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/all/count")
    public long countStories() {
        return storyRepository.count();
    }

    @GetMapping("/all")
    public List<Story> allStories() {
        return storyRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public Story getById(@PathVariable ObjectId id) {
        return storyRepository.findById(id);
    }

    @GetMapping("/getByDescription/{description}")
    public List<Story> getById(@PathVariable String description) {
        return storyRepository.findByDescription(description);
    }

    @GetMapping("/text")
    public String getText() {
        return "just a simple text for now";
    }

    @GetMapping("/one")
    public Story getOne() {
        return new Story("a short de", new Address("an address"), Date.from(Instant.now()));
    }

    @PostMapping("/insert")
    public Story insertWithBody(@RequestBody Story story) {
        storyRepository.save(story);
        return story;
    }

    @Deprecated
    @GetMapping("/insertOLD")
    public Story insert(@RequestParam(value="description", defaultValue="descr. default value") String description) {
        // Create Story
        Story entity = new Story(description, new Address("a deprecated address"), Date.from(Instant.now()));

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