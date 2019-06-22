#JDK8 

####函数式接口
    BiConsumer<T,U>			代表了一个接受两个输入参数的操作，并且不返回任何结果
    BiFunction<T,U,R>		代表了一个接受两个输入参数的方法，并且返回一个结果
    BinaryOperator<T>		代表了一个作用于于两个同类型操作符的操作，并且返回了操作符同类型的结果
    BiPredicate<T,U>		代表了一个两个参数的boolean值方法
    BooleanSupplier			代表了boolean值结果的提供方
    Consumer<T>				代表了接受一个输入参数并且无返回的操作
    DoubleBinaryOperator	代表了作用于两个double值操作符的操作，并且返回了一个double值的结果。
    DoubleConsumer 			代表一个接受double值参数的操作，并且不返回结果。
    DoubleFunction<R> 		代表接受一个double值参数的方法，并且返回结果
    DoublePredicate			代表一个拥有double值参数的boolean值方法
    DoubleSupplier 			代表一个double值结构的提供方
    DoubleToIntFunction 	接受一个double类型输入，返回一个int类型结果。
    DoubleToLongFunction	接受一个double类型输入，返回一个long类型结果
    DoubleUnaryOperator		接受一个参数同为类型double,返回值类型也为double 。
    Function<T,R>			接受一个输入参数，返回一个结果。
    IntBinaryOperator		接受两个参数同为类型int,返回值类型也为int 。
    IntConsumer 			接受一个int类型的输入参数，无返回值 。
    IntFunction<R>			接受一个int类型输入参数，返回一个结果 。
    IntPredicate			接受一个int输入参数，返回一个布尔值的结果。
    IntSupplier				无参数，返回一个int类型结果。
    IntToDoubleFunction		接受一个int类型输入，返回一个double类型结果 。
    IntToLongFunction 		接受一个int类型输入，返回一个long类型结果。
    IntUnaryOperator 		接受一个参数同为类型int,返回值类型也为int 。
    LongBinaryOperator 		接受两个参数同为类型long,返回值类型也为long。
    LongConsumer 			接受一个long类型的输入参数，无返回值。
    LongFunction<R> 		接受一个long类型输入参数，返回一个结果。
    LongPredicate 			R接受一个long输入参数，返回一个布尔值类型结果。
    LongSupplier 			无参数，返回一个结果long类型的值。
    LongToDoubleFunction 	接受一个long类型输入，返回一个double类型结果。
    LongToIntFunction 		接受一个long类型输入，返回一个int类型结果。
    LongUnaryOperator 		接受一个参数同为类型long,返回值类型也为long。
    ObjDoubleConsumer<T> 	接受一个object类型和一个double类型的输入参数，无返回值。
    ObjIntConsumer<T>		接受一个object类型和一个int类型的输入参数，无返回值。
    ObjLongConsumer<T> 		接受一个object类型和一个long类型的输入参数，无返回值。
    Predicate<T>			接受一个输入参数，返回一个布尔值结果。
    Supplier<T> 			无参数，返回一个结果。
    ToDoubleBiFunction<T,U>	接受两个输入参数，返回一个double类型结果
    ToDoubleFunction<T>		接受一个输入参数，返回一个double类型结果
    ToIntBiFunction<T,U>	接受两个输入参数，返回一个int类型结果。
    ToIntFunction<T>		接受一个输入参数，返回一个int类型结果。
    ToLongBiFunction<T,U>	接受两个输入参数，返回一个long类型结果。
    ToLongFunction<T>		接受一个输入参数，返回一个long类型结果。
    UnaryOperator<T>		接受一个参数为类型T,返回值类型也为T。
    
####流

    生成流
    1:stream() − 为集合创建串行流。
    2:parallelStream() − 为集合创建并行流。

    forEach
    对流进行迭代,但是没有返回结果

    map
    映射每一个元素，可以有返回结果
    
    filter
    过滤每一个元素，可以有一个Boolean类型的返回结果
    
    limit
    限定只取前多少条
    
    sorted
    默认是正序排列，可以传入Comparator的比较方法进行自定义排序
    
    collect
    用于将流收集成何种类型，
    String s = list.stream().sorted().collect(Collectors.joining(","));
    List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
    
####时间

    1:Clock：		用于获取指定时区的当前日期，时间。该类可取代System类的currentTimeMills()方法，而且提供了更多的方法来获取当前时间，日期。
    2:Duration  	该类代表持续时间
    3:Instant 		代表一个具体的时刻，可以精确到纳秒。该类提供了一个静态的now()来获取当前的时刻，也提供了静态的now(Clock clock)来获取clock对应的时刻。
    4:LocalDate		LocalDate是一个不可变的日期时间对象，表示日期，通常被视为年月日。 也可以访问其他日期字段，例如日期，星期几和星期。 例如，值“2007年10月2日”可存储在LocalDate 					。该类不存储或表示时间或时区。 相反，它是日期的描述，用于生日。 它不能代表时间线上的即时信息，而没有附加信息，如偏移或时区。
    5:LocalTime		LocalTime是一个不可变的日期时间对象，代表一个时间，通常被看作是小时 - 秒。 时间表示为纳秒精度。 例如，值“13：45.30.123456789”可以存储在LocalTime 。
    				它不存储或表示日期或时区。 相反，它是在挂钟上看到的当地时间的描述。 它不能代表时间线上的即时信息，而没有附加信息，如偏移或时区。 
    6:LocalDateTime	LocalDateTime是一个不可变的日期时间对象，代表日期时间，通常被视为年 - 月 - 日 - 时 - 分 - 秒。 也可以访问其他日期和时间字段，例如日期，星期几和星期。 					时间表示为纳秒精度。 例如，值“2007年10月2日在13：45.30.123456789”可以存储在LocalDateTime 。 
    				该类不存储或表示时区。 相反，它是对日子的描述，如用于生日，结合当地时间在挂钟上看到的。 它不能代表时间线上的即时信息，而没有附加信息，如偏移或时区。 


