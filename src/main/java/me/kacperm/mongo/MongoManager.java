package me.kacperm.mongo;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoManager {

    private final MongoCollection<Document> profiles;

    public MongoManager() {
        MongoClient mongoClient = MongoClients.create(new ConnectionString(""));
        MongoDatabase mongoDatabase = mongoClient.getDatabase("minefarm");

        this.profiles = mongoDatabase.getCollection("profiles");
    }

    public MongoCollection<Document> getProfiles() {
        return profiles;
    }
}
