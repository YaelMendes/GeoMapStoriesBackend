package main.story;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by jpe on 19.01.2017.
 */
public interface PersonRepository extends MongoRepository<Person, ObjectId>
{
}
