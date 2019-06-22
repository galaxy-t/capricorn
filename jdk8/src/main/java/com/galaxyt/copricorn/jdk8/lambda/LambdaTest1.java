package com.galaxyt.copricorn.jdk8.lambda;


/**
 *  使用 Lambda 表达式需要注意以下两点：
 *
 * Lambda 表达式主要用来定义行内执行的方法类型接口，例如，一个简单方法接口。在下面例子中，我们使用各种类型的Lambda表达式来定义MathOperation接口的方法。然后我们定义了sayMessage的执行。
 * Lambda 表达式免去了使用匿名方法的麻烦，并且给予Java简单但是强大的函数化的编程能力。
 * @author zhouqi
 * @date 2019-06-12 11:51
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-12 11:51     zhouqi          v1.0.0           Created
 *
 */
public class LambdaTest1 {

    public static void main(String[] args) {

        LambdaTest1 tester = new LambdaTest1();

        //类型声明
        MathOperation addition = (int a,int b) -> a + b;

        //不声明类型
        MathOperation subtraction = (a, b) -> a - b;

        //大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {return a*b;};

        //没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        int c = addition.operation(10, 5);

        System.out.println(c);

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));


        //参数不用括号
        GreetingService greetingService1 = message -> System.out.println("Hello" + message);

        //参数用括号
        GreetingService greetingService2 = (message) -> System.out.println("Hello" + message);

        //参数用括号并指明参数类型
        GreetingService greetingService3 = (String message) -> System.out.println("Hello" + message);


        greetingService1.sayMessage("111");
        greetingService2.sayMessage("222");
        greetingService3.sayMessage("333");
    }


    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }

}
