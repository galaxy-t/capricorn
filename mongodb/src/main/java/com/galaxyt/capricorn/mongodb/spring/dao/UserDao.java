package com.galaxyt.capricorn.mongodb.spring.dao;

import com.galaxyt.capricorn.mongodb.spring.User;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.gridfs.GridFSDBFile;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

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

        //删除一条并且返回这条数据
        //User user = this.mongoTemplate.findAndRemove(Query.query(Criteria.where("id").is(id)), User.class);


        //删除多条并且返回一个集合
        //List<User> list = this.mongoTemplate.findAllAndRemove(Query.query(Criteria.where("id").is(id)), User.class);

        //删除集合的两种方式
        //this.mongoTemplate.dropCollection(User.class);
        //this.mongoTemplate.dropCollection("user");

        //删除库
        this.mongoTemplate.getDb().drop();


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

        //查询总数
        //long count = this.mongoTemplate.count(Query.query(Criteria.where("name").is("zhouqi")), User.class);

        //查询多条
        //this.mongoTemplate.find();

        //查询整个表
        //this.mongoTemplate.findAll();


        //分页
        //在大数据量的情况下，使用skip会很慢，解决办法是记住上一次查询的ID，然后大于这个ID的10条会快很多
        //this.mongoTemplate.find(Query.query(Criteria.where("name").is("zhouqi")).skip(10).limit(10), User.class);

        //or
        /*this.mongoTemplate.find(Query.query(new Criteria().orOperator(
                Criteria.where("name").is("zhouqi"),
                Criteria.where("name").is("zhouqi123")

        )), User.class);*/


        return this.mongoTemplate.findById(id, User.class);
    }


}
