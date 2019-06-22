#Swagger2演示DEMO

###文档页面访问
http://localhost:8080/swagger-ui.html

###注：Swagger2Config
####createRestApi方法用来设置Swagger2扫描哪些包中的API
####apiInfo方法用来设置Swagger2文档页面中的一些基础信息
####继承WebMvcConfigurationSupport并重写addResourceHandlers方法是因为如果开启全局异常拦截处理之后需要将项目的静态资源映射关掉，但是关掉静态资源映射之后Swagger2文档页面所需要的映射也会一起被关闭掉，所以需要手动为这些静态资源添加映射