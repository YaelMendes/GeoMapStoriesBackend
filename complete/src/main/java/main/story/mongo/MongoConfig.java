package main.story.mongo;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "main")
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${mongo.url}")
    private String mongoUrl;

    @Value("${mongo.port}")
    private String mongoPort;

    @Value("${mongo.database}")
    private String mongoDatabase;

    @Value("${mongo.user}")
    private String user;

    @Value("${mongo.password}")
    private String password;

    @Override
    protected String getDatabaseName() {
        return "nowandhere";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(new MongoClientURI("mongodb://"+user+":"+password+"@"+mongoUrl+":"+mongoPort+"/" + getDatabaseName()));
    }

}