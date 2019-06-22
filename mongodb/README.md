#MongoDB 

####与MySQL的对比

    MySQL           MongoDB
    表（table）      集合（Collection）
    行（row）        文档（Document）
    列（column）     key


####适合用在弱事务的场景
####没有多表连接查询

####启动
    非守护进程启动
    ./bin/mongod --dbpath=/Users/zhouqi/java/tools/mongodb/data --logpath=/Users/zhouqi/java/tools/mongodb/logs/mongodb.log
    守护进程启动
    ./bin/mongod --dbpath=/Users/zhouqi/java/tools/mongodb/data --logpath=/Users/zhouqi/java/tools/mongodb/logs/mongodb.log --fork
    配置文件启动
    ./bin/mongod -f conf/mongodb.yml
    
####默认端口
    27017
    
####命令行客户端连接
    默认连接
    ./bin/mongo
    连接远程
    ./bin/mongo localhost:27017
    
####退出客户端
    exit
    
####客户端命令使用
    
    show dbs;
    查看当前实例中有多少个数据库
    
    use DATABASE_NAME;
    创建数据库，如果数据库不存在，则创建数据库，否则切换到指定数据库。
    mongoDB中默认的数据库是test，如果没有创建新的数据库，集合将存放在 test 数据库中
    在 MongoDB 中，集合只有在内容插入后才会创建! 就是说，创建集合(数据表)后要再插入一个文档(记录)，集合才会真正创建。
    所以在数据库中没有文档（记录）的时候使用 show dbs; 命令是不会显示该数据库的
    
    db;
    显示当前正在使用的数据库
    
    db.createCollection("testCollection");
    在当前数据库中创建一个集合
    
    show collections;
    查看当前数据库中的全部集合
    
    db.testCollection2.save({"name":"周琦"});
    直接为testCollection2集合创建一个文档，若没有testCollection2集合则创建
    
    db.testCollection2.save({"_id":1,"name":"周琦"});
    插入一个文档，并指定_id，若不指定默认为ObjectId
    
    
    db.testCollection2.find();
    查询testCollection2的全部文档
    
    db.testCollection2.findOne();
    默认查询第一条
    
    db.test2.find({"money":57});
    带条件查询money=57的全部数据
    
    db.test2.find({"money":{"$gt":1}});
    查询money大于1的全部数据
    
    db.test2.find({"money":{"$gte":1}});
    查询money大于等于1的全部数据
    
    db.test2.find({"money":{"$lt":1}});
    查询money小于1的全部数据
    
    db.test2.find({"money":{"$lte":1}});
    查询money小于等于1的全部数据
    
    db.test2.find({"money":{"$in":[57,66,100]}});
    IN查询
    
    db.test2.find({"$or":[{"money":57},{"money":66}]});
    OR查询
    
    db.testCollection2.find().limit(1);
    查询一条，分页使用
    
    db.testCollection2.find().skip(1).limit(1);
    跳过一条，查询后面一条，分页使用
    
    db.test2.find().sort({"_id":-1});
    排序，1表示正序，-1表示倒序
    
    
    db.testCollection2.update({"name":"周琦"},{"$set":{"name":"jack"}});
    修改，第一个json指定修改条件（也可以理解为查询条件），第二个指定修改key与内容
    只修改第一条
    
    db.testCollection2.update({"name":"jack"},{"$set":{"name":"周琦"}},false,true);
    修改全部符合条件的数据，第三个参数是没有符合条件的是否插入，第四个参数设置为true生效，默认为false
    
    db.testCollection2.update({"name":"周琦"},{"$set":{"name":"周琦1","sex":"男"}},false,true);
    在修改的时候添加key
    
    db.testCollection2.update({"_id":1},{"$inc":{"money":5}});
    指定为money 加上5
    
    db.testCollection2.remove({"_id":1});
    删除,根据匹配条件全部删除
    
    db.testCollection2.drop();
    删除整个文档，数据+文档
    
    db.testCollection2.remove({});
    删除文档的全部数据，不删除文档和索引等
    
    
    
    
    