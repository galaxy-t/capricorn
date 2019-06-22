#Zookeeper

####分布式应用程序协调服务
####供的功能包括：配置维护、域名服务、分布式同步、组服务等。

####数据结构不同于常用的数据库结构或NoSQL数据库结构，其更像是文件夹的目录结构

###数据节点类型
	临时节点（Session），会话节点，会话启动，节点存在，会话结束，节点销毁
	持久化节点

###ACL（访问控制列表）用于控制节点的权限
###格式：schema:id:permission
	schema:代表授权策略
	id：代表用户
	permission：代表权限
		permission分为以下几种
			CREATE(c) 	创建子节点的权限
			READ(r)		读取节点数据的权限
			DELETE(d)	删除节点的权限
			WRITE(w)	修改节点数据的权限
			ADMIN(a)	设置子节点权限的权限


####为节点设置权限
    setAcl /test digest:zhouqi:zwnqMhjMhpBo3CqM8qqH5mM73s8=:crdwa
    为test节点添加用户密码权限
    用户名zhouqi
    密码BASE64(SHA1(123456))
    权限：crdwa

####为当前session添加用户权限
    addauth digest zhouqi:123456


####目录
    /
        bin		启动脚本
            zkServer.sh	服务端脚本
                start	启动
                stop	停止
            zkCli.sh	客户端脚本
                ls /	查看根目录下的节点，需要手动指定要查看的目录路径
                create /test "abcd"	在根目录下创建一个节点名字叫test，值为abcd	默认数据是持久化的
                create -e /testtemp "temp" 在根目录下创建一个临时节点testtemp，当session关闭该节点会被销毁
                create -s /testseq "seq"   在根目录下创建一个字增长的节点testseq
                get /test	查看test节点的值
                set /test "abcde" 修改test节点的值
                stat /test 查看test节点的描述信息
                delete /test 删除test节点,若要删除的节点下面又多个子节点，需要先将子节点删除再删除该节点
                rmr /test 递归删除，删除test节点，包括删除其下面的子节点
    
        conf	配置文件

####命令
	启动  ./bin/zkServer.sh start
	停止  ./bin/zkServer.sh stop

