




# 一级标题
## 二级标题
### 三级标题
#### 四级标题
##### 五级标题
###### 六级标题

前面带#号，后面带文字，分别表示h1-h6,上图可以看出，只到h6，而且h1下面会有一条横线，注意，#号后面有空格


一级标题
====
二级标题
------

这种方式好像只能表示一级和二级标题，而且=和-的数量没有限制，只要大于一个就行



无序列表1
* 1
* 2 
* 3

无序列表2
+ 1
+ 2
+ 3

无序列表3

- 1
- 2
- 3


有序列表
1. sladfj
    > sdljfals
3. lsdfj
    >引用的使用
    
    > sldjflsadsdfassdafds
2. asldfjlds

自动为序号排列


华丽的分割线，星号，减号，下划线，大于等于三个

***

---

___


链接行内式
[连接测试](http://www.baidu.com)

链接参数式

[name]: http://www.baidu.com "名称"
这里是[name]


图片行内式
![我是图片](图片地址)


图片参数式

[image]: 图片地址

![image]


代码

单行代码

`final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();`

多行代码

```$xslt    此处可以跟随一些注释

    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            final CorsConfiguration corsConfiguration = new CorsConfiguration();
            corsConfiguration.addAllowedHeader("*");
            corsConfiguration.addAllowedOrigin("*");
            corsConfiguration.addAllowedMethod("*");
            source.registerCorsConfiguration("/**", corsConfiguration);
            return new CorsFilter(source);

```

表格



强调

_字体倾斜_

**字体加粗**

~~中线~~

~~删除~~
