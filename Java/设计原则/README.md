# 设计原则

- https://www.cnblogs.com/DI-DIAO/p/8613357.html

## 1. 单一职责原则(Single Responsibility Principle，SRP)

- 应该有且仅有一个原因引起类的变更,There should never be more than one reason for a class to change.

- 单一职责适用于接口、类，同时也适用于方法

## 2.里氏替换原则

- 第一种定义，也是最正宗的定义：If for each object o1 of type S there is an object o2 of
  type T such that for all programs P defined in terms of T,the behavior of P is unchanged when o1 is
  substituted for o2 then S is a subtype of T.（如果对每一个类型为 S 的对象 o1，都有类型为 T 的对象 o2，使得以 T 定义的所有程序 P 在所有的对象 o1 都代换成 o2 时，程序 P 的行为没有发生变化，那么类型 S 是类型 T 的子类型。）

- 第二种定义：Functions that use pointers or references to base classes must be able to use
  objects of derived classes without knowing it.（所有引用基类的地方必须能透明地使用其子类的对象。）



里氏替换原则为良好的继承定义了一个规范，一句简单的定义包含了4层含义：

1. 子类必须完全实现父类的方法；
   -- 1.1在类中调用其他类时务必要使用父类或接口，如果不能使用父类或接口，则说明类的设计已经违背了LSP原则；   
   -- 1.2如果子类不能完整地实现父类的方法，或者父类的某些方法在子类中已经发生“畸变”，则建议断开父子继承关系，采用依赖、聚集、组合等关系代替继承。    
2. 子类可以有自己的个性；
3. 覆盖或实现父类的方法时输入参数可以被放大；    
   -- 3.1如果父类的输入参数类型大于子类的输入参数类型，会出现父类存在的地方，子类未必会存在，因为一旦把子类作为参数传入，调用者很可能进入子类的方法范畴；  
   -- 3.2子类中方法的前置条件必须与超类中被覆写的方法的前置条件相同或者更宽松。     
4. 覆写或实现父类的方法时输出结果可以被缩小。
父类的一个方法的返回值是一个类型T，子类的相同方法（重载或覆写）的返回值为S，那么里氏替换原则就要求S必须小于等于T，也就是说，要么S和T是同一个类型，要么S是T的子类。



依赖倒置原则
　　依赖倒置原则（Dependence Inversion Principle,DIP）,原始定义是：High level modules should not depend upon low level modules.Both should depend upon abstractions.Abstractions should not depend upon details.Details should depend upon abstractions.

包含三层含义：

高层模块不应该依赖底层模块，两者都应该依赖抽象；
抽象不应该依赖细节；
细节应该依赖抽象。


接口隔离原则
　　接口分为两种：

实例接口（Object Interface），在Java中声明一个类，然后用new关键字产生一个实例，它是对一个类型的食物的描述，这是一种接口。
类接口（Class Interface），Java中经常使用的interface关键字定义的接口；
Clients should not be forced to depend upon interfaces that they don‘t use。（客户端不应该依赖它不需要的接口。）
The dependency of one class to another one should depend on the smallest possible interface。（类间的依赖关系应该建立在最小的接口上。）
接口隔离原则是对接口进行规范约束，其包含以下4层含义：

接口要尽量小； --- 这是接口隔离原则的核心定义，不出现臃肿的接口（Fat Interface），但是“小”是有限度的，首先就是不能违反单一职责原则。
接口要高内聚； --- 高内聚就是提高接口、类、模块的处理能力，减少对外的交互。在接口中尽量少公布public方法，接口是对外的承诺，承诺越少对系统的开发越有利，变更的风险也就越少，同时也越有利于降低成本。
定制服务； --- 一个系统或系统内的模块之间必然会有耦合，有耦合就要有相互访问的接口（并不一定就是Java中定义的Interface，也可能是一个类或单纯的数据交换），我们设计时就需要为各个访问者（即客户端）定制服务。定制服务就是单独为一个个体提供优良的服务。我们在做系统设计时也需要考虑对系统之间或模块之间的接口采用定制服务。采用定制服务就必然有一个要求：只提供访问者需要的方法。
接口设计是有限度的。 --- 接口的设计粒度越小，系统越灵活，这是不争的事实。但是，灵活的同时也带来了结构的复杂化，开发难度增加，可维护性低，这不是一个项目或产品所期望看到的，所以接口设计一定要注意适度，这个“度”如何来判断？根据经验和常识判断，没有一个固话或可测量的标准。




迪米特法则
　　迪米特法则（Law of Demeter ，LoD）也称为最少知识原则（Least Knowledge Principle，LKP），虽然名字不同，但描述的是同一个规则：一个对象应该对其他对象有最少的了解。通俗地讲，一个类应该对自己需要耦合或调用的类知道得最少，你（被耦合或调用的类）的内部是如何复杂都和我没关系，那是你的事情，我就知道你提供的这么多public方法，我就调用这么多，其他的我一概不关心。

迪米特法则对类的低耦合提出了明确的要求，其包含以下4层含义：

只和朋友交流 --- 迪米特法则还有一个英文解释是：Only talk to your immedate friends（只与直接的朋友通信。）什么叫做直接的朋友？每个对象都必然会与其他对象有耦合关系，两个对象之间的耦合就成为朋友关系，这种关系的类型有很多，例如组合、聚合、依赖等。朋友类的定义：出现在成员变量、方法的输入输出参数中的类称为成员朋友类，而出现在方法体内部的类不属于朋友类。注意：一个类只和朋友交流，不与陌生类交流，不要出现getA().getB().getC().getD()这种情况（在一种极端的情况下允许出现这种访问，即每一个点后面返回类型都相同），类与类之间的关系是建立在类间的，而不是方法间，因此一个方法尽量不引入一个类中不存在的对象，当然，JDK API提供的类除外。
朋友间也是有距离的 --- 一个类公开的public属性或方法越多，修改时涉及的面积越大，变更引起的风险扩散也就越大。因此，为了保持朋友类间的距离，在设计时需要反复衡量：是否还可以再减少public方法和属性，是否可以修改为private、package-private（包类型，在类、方法、变量前不加访问权限，则默认为包类型）、protected 等访问权限，是否可以加上final关键字等。  注意：迪米特法则要求类“羞涩”一点，尽量不要对外公布太多的public方法和非静态的public变量，尽量内敛，多使用private、package-private、protected等访问权限。
是自己的就是自己的 --- 如果一个方法放在本类中，即不增加类间的关系，也对本类不产生负面影响，就放置在本类中。
谨慎使用Serializable







开放封闭原则
　　开放封闭原则的定义：Software entities like classes, modules and functions should be open for extension but closed for modifications.（一个软件实体如类、模块和函数应该对扩展开放，对修改关闭。）