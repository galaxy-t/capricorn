package com.galaxyt.capricorn.mongodb.spring.dao;

import com.galaxyt.capricorn.mongodb.spring.User;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;


    public User save(User user) {


        return this.mongoTemplate.save(user);
    }

    public long remove(Long id) {

        //Query query = new Query(Criteria.where("id").is(id));


        DeleteResult result = this.mongoTemplate.remove(Query.query(Criteria.where("id").is(id)), User.class);

        return result.getDeletedCount();
    }

    public long update(User user) {

        /*Query query = new Query(Criteria.where("id").is(user.getId()));

        Update update = new Update();
        update.set("name", user.getName());


        UpdateResult result = this.mongoTemplate.updateFirst(query, update, User.class);*/


        //注：id作为条件的时候，id的值必须合法，否则不予生效
        UpdateResult result = this.mongoTemplate.updateFirst(Query.query(Criteria.where("id").is(user.getId())),
                Update.update("name",user.getName()),User.class);


        //根据主键ID删除name这个key
        /*UpdateResult result = this.mongoTemplate.updateFirst(Query.query(Criteria.where("id").is(user.getId())),
                new Update().unset("name"),User.class);*/


        //使用与update一致，区别在于该方法查询到即修改，查询不到则新增
        //this.mongoTemplate.upsert();



        return result.getModifiedCount();

    }

    public User findById(long id) {

        return this.mongoTemplate.findById(id, User.class);
    }


}
