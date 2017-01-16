package main.story;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by yme on 16.01.2017.
 */
public interface StoryRepository extends MongoRepository<Story, String> {
}
