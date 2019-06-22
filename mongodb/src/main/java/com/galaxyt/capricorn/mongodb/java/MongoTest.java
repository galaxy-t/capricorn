package com.galaxyt.capricorn.mongodb.java;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import org.bson.Document;

/**
 * JAVA驱动操作Mongodb
 * @author zhouqi
 * @date 2019-06-19 14:03
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-19 14:03     zhouqi          v1.0.0           Created
 *
 */
public class MongoTest {

    public static void main(String[] args) {

        //打开与数据库的链接
        MongoClient client = new MongoClient("localhost",27017);

        //得到数据库
        MongoDatabase database = client.getDatabase("test");

        //得到一个集合
        MongoCollection<Document> collection = database.getCollection("test2");

        //像集合中插入一个文档
        //collection.insertOne(new Document("name", "java测试").append("money", 99));


        /*
        批量插入
         */
        /*List<Document> documentsList = new ArrayList<>(2);

        documentsList.add(new Document("name", "java测试2").append("money", 99));
        documentsList.add(new Document("name", "java测试3").append("money", 99));

        collection.insertMany(documentsList);*/


        //单条修改
        //collection.updateOne(Filters.eq("name", "java测试2"),new Document("$set",new Document("money","100")));

        //如果存在则修改，不存在则新增
        //collection.updateOne(Filters.eq("name", "java测试6"),new Document("$set",new Document("money","100")),new UpdateOptions().upsert(true));


        //删除
        //collection.deleteOne(Filters.eq("name", "java测试2"));


        /*
        查询一条
         */
        /*Document firstDoc = collection.find().first();
        System.out.println(firstDoc);*/


        /*
        查询并且迭代
         */
        /*MongoCursor<Document> cursor = collection.find().iterator();

        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }*/


        /*
        查询总数
        也可以使用countDocuments的重载方法加条件
         */
        /*long count = collection.countDocuments();
        System.out.println(count);*/


    }


}
