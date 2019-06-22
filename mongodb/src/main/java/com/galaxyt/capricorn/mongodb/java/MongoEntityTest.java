package com.galaxyt.capricorn.mongodb.java;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

public class MongoEntityTest {


    public static void main(String[] args) {

        //打开与数据库的链接
        MongoClient client = new MongoClient("localhost",27017);

        //得到数据库
        MongoDatabase database = client.getDatabase("test");

        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(CodecRegistries.fromCodecs(new UserCodec()));
        MongoCollection<User> collection = database.getCollection("test2", User.class).withCodecRegistry(codecRegistry);


        User user = new User();

        user.setName("张三");
        //collection.insertOne(user);

        User user1 = collection.find().first();

        System.out.println(user1.getName());


    }



}
