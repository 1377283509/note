### HashSet

#### 简介

HashSet是Set接口的实现类，储存的是**无序、唯一**的对象。由于是无序的所以每组数据都没有索引，很多list可用的方法他都没有，凡是需要通过索引来进行操作的方法都没有，所以也**不能使用普通for循环来进行遍历**，只**有加强型for和迭代器两种遍历方法**。不是线程安全的。

#### 常用方法

| 方法名      | 描述                                                         | 返回类型  |
| ----------- | ------------------------------------------------------------ | --------- |
| add()       | 向给定HashSet中添加元素，成功返回true，失败返回false。如存在，则添加失败。 | boolean   |
| contains()  | 检查给定HashSet中是否存在元素。如果找到该元素，则返回true，否则返回false。 | boolean   |
| remove()    | 如果存在，该方法将从集合中删除指定的元素，返回true。否则，返回false。 | boolean   |
| clear()     | 清空给定HashSet中的所以元素。无返回值。                      | void      |
| size()      | 返回HashSet中的元素数量。                                    | int       |
| isEmpty()   | 判断HashSet是否为空。为空返回true。                          | boolean   |
| interator() | 返回HashSet中元素的迭代器。                                  | Interator |
| clone()     | 返回这个集合的浅表副本                                       | Object    |

#### HashSet如何保证唯一性？

当我们将一个对象放入一个HashSet时，它使用该对象的hashcode值来确定一个元素是否已经在该集合中。

每个散列码值对应于某个块位置，该块位置可以包含计算出的散列值相同的各种元素。但是具有相同hashCode的两个对象可能不相等。

因此，将使用equals（）方法比较同一存储桶中的对象。

#### HashSet的性能

HashSet的性能主要受两个参数影响 - 初始容量和负载因子。

将元素添加到集合的预期时间复杂度是O（1），在最坏的情况下（仅存在一个存储桶）可以降至O（n） - 因此，维护正确的HashSet容量至关重要。

一个重要的注意事项：从JDK 8开始，最坏的情况时间复杂度为O（log * n）。

负载系数描述了最大填充级别，在该级别之上，需要调整一组的大小。

我们还可以创建一个HashSet，其中包含初始容量和加载因子的自定义值：

```java
Set<String> hashset = new HashSet<>();
Set<String> hashset = new HashSet<>(20);
Set<String> hashset = new HashSet<>(20, 0.5f);
```

在第一种情况下，使用默认值 - 初始容量为16，载荷系数为0.75。在第二个中，我们覆盖默认容量，在第三个中，我们覆盖两者。

较低的初始容量降低了空间复杂性，但增加了重新散布的频率。

另一方面，高初始容量增加了迭代成本和初始内存消耗。

- 高初始容量适用于大量条目，几乎没有迭代
- 低初始容量适用于具有大量迭代的少数条目

#### 遍历方法

```java
HashSet<String> set = new HashSet<String>();
// interator()
Interator<string> interator = set.interator();
while(interator.hasNext()){
    System.out.print(interator.next());
}
// clone()
HashSet<String> cloneSet = (HashSet<String>) set.clone();
```

 

 

 

 

 

 

 

 

 

 

 

 

 

 