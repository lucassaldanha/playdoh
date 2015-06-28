# Play-Doh
A Java library to create test objects (randomly or based on template)

[![Build Status](https://travis-ci.org/lucassaldanha/playdoh.svg?branch=master)](https://travis-ci.org/lucassaldanha/playdoh) [![Coverage Status](https://coveralls.io/repos/lucassaldanha/playdoh/badge.svg)](https://coveralls.io/r/lucassaldanha/playdoh)

## Synopsis

Have you ever struggle to write some simple test objects in your tests? Me too. With Play-Doh you can generate instantly test objects with random generated data in a blink of an eye.

## Motivation

Testing is good but sometimes it takes a lot of effort to write good tests. Sometimes you need to create constructors for your objects that only tests are going to call. Sometimes you need to use some intrusive libraries as [Spring's ReflectionUtils](http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/util/ReflectionUtils.html) to avoid using those constructors but it feels so dirty.

Even with some cool technics as [Test Data Builder](http://nat.truemesh.com/archives/000714.html) sometimes it's so hard to create a simple object with some data just to write a test.

I started writing this library to help me write less while writing tests. I believe that it helped me a lot and I hope that it will help you too.

## Code Example

You have something like this:
```java
public class Dummy {
    private Integer integerValue;
    private String stringValue;
    private NestedDummy nestedDummy;
    ...
}
```

You create a Dummy class instance:
```java
Dummy dummy = Playdoh.build(Dummy.class);
```

And you get this:
```
dummy.toString()
> Dummy{integerValue=1463994319, stringValue='wtnUOzhmIs', nested=NestedDummy{intValue=1169020145, stringValue='DaVaSeMtrU'}}
```

If you want to set some of the fields with specific values you should do this:
```java
Dummy dummy = Playdoh.builder(Dummy.class)
                     .with("stringValue", "test")
                     .build();
```

So you will have something like this:
```
dummy.toString()
> Dummy{integerValue=1463994319, stringValue='test', nested=NestedDummy{intValue=1169020145, stringValue='DaVaSeMtrU'}}
```

You can also create an object with the data specified in a fixture file (yml file). For example for an User class:
```java
public class User {
    private String name;
    private String email;
    private int age;
    ...
```

You must have an user.yml file in your classpath with the data for an user. Like this one:
```yaml
aUser:
  name: Lucas Saldanha
  email: lucas@example.com
  age: 123
```

Then you can create an User with the data as specified in the fixture file:
```java
User user = Playdoh.build(User.class, "aUser");
```

And you get:
```
user.toString()
> User{name='Lucas Saldanha', email='lucas@example.com', age=123}
```

You may have multiple user data defined in user.yml file. You choose which one will be used with the identifier passed as parameter to the `Playdoh.build(TYPE, IDENTIFIER)` method. Your fixture file must follow a snake-case convention. If you have a **HelloWorld.class** you must name you fixture file **hello_world.yml**.

## Tests

You need JDK > 1.6 and Maven to build the sources and run the tests.

To run the tests execute in the project folder:
```
mvn test
```

## Contributors

Feel free to colaborate with htis project. Pull requests and issue creation are welcome. With you have any doubts about getting involved get in touch and we can talk.

## License

**The MIT License (MIT) Copyright (c) 2015 Lucas Saldanha**

For more details check the LICENCE file in the project.
