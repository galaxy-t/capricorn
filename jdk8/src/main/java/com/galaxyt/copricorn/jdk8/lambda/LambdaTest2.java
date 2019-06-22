package com.galaxyt.copricorn.jdk8.lambda;

public class LambdaTest2 {

    static String salutation = "Hello! ";

    public static void main(String[] args) {

        String abcd = "ccc";

        //在 Lambda 表达式当中不允许声明一个与局部变量同名的参数或者局部变量。
        GreetingService greetingService = message -> {

            salutation = "abcd";

            //不能在 lambda 内部修改定义在域外的局部变量，否则会编译错误。
            //abcd = "ddd";

            System.out.println(salutation + message + abcd);
        };

        //局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有 final 的语义）
        //abcd = "eee";

        greetingService.sayMessage("AAA");

    }

    interface GreetingService {
        void sayMessage(String message);
    }


}
