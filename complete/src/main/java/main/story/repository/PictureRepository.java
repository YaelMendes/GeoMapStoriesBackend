package main.story.repository;

import main.story.objects.Picture;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by jpe on 19.01.2017.
 */
public interface PictureRepository extends MongoRepository<Picture, ObjectId>
{
}
