### ArrayList

#### 简介

ArrayList是一个其容量能够动态增长的动态数组。但是他又和数组不一样，下面会分析对比。它继承了AbstractList，实现了List、RandomAccess, Cloneable, java.io.Serializable。

- 它继承于AbstractList，实现了List,RandomAccess[随机访问],Cloneable[可克隆], java.io.Serializable[序列化]这些接口。
- ArrayList 继承了AbstractList，实现了List。它是一个数组队列，提供了相关的添加、删除、修改、遍历等功能.
- ArrayList 实现了RandmoAccess接口，即提供了随机访问功能。
- ArrayList 实现了Cloneable接口，即覆盖了函数clone()，能被克隆.
- ArrayList 实现java.io.Serializable接口，这意味着ArrayList支持序列化，能通过序列化去传输和Vector不同，ArrayList中的操作不是线程安全的。所以，建议在单线程中才使用ArrayList，而在多线程中可以选择Vector或者CopyOnWriteArrayList。

#### 构造方法

```java
// 构造一个容量为var1的list
public ArrayList(int var1) {
    if (var1 > 0) {
        this.elementData = new Object[var1];
    } else {
        if (var1 != 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + var1);
        }

        this.elementData = EMPTY_ELEMENTDATA;
    }

}

// 无参的构造方法，构造一个默认长度为0的list
public ArrayList() {
    this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
}

// 构造一个含有var1中所有元素的list
public ArrayList(Collection<? extends E> var1) {
    this.elementData = var1.toArray();
    if ((this.size = this.elementData.length) != 0) {
        if (this.elementData.getClass() != Object[].class) {
            this.elementData = Arrays.copyOf(this.elementData, this.size, Object[].class);
        }
    } else {
        this.elementData = EMPTY_ELEMENTDATA;
    }

}
```

#### 常用方法

##### 增

- boolean add(E e)：添加一个元素到列表的末尾。
- boolean add( int index, E element ) :在指定的位置添加元素。
- boolean addAll( Collection<? extends E> c )：添加一个集合到元素的末尾.

##### 删

- remove(Object o)：删除列表中第一个出现o的元素
- remove( int index)：删除列表中指定位置的元素
- removeAll（Collection<?> c）：删除列表中包含C的所有元素
- removeIf（Predictcate<? super E> filter）：删除列表中给定谓词的所有元素
- removeRange( int from,int to )：删除从from到to的所有元素
- clear()：清除所有的元素。返回类型为void

##### 改

- etainAll( Collection<?> c )：仅仅保留列表中和C相同的元素，相当于&运算。
- set（int index,E element）：用element替换index位置上的元素。
- size()：返回此列表的元素数。
- sort(Comparator<? super E> c)：按照指定的排序规则排序。
- subList( int from , int to )：返回从from到to之间的列表。
- toArray()：将列表转化为数组。
- trimToSize( )：修改当前实例的容量是列表的当前大小。

##### 查

- contains（Object o）：如果包含元素o,则返回为true。
- get（int index）:返回指定索引的元素。
- indexOf( Object o )：返回此列表中指定元素的第一次出现的索引，如果列表不包含此元素，返回-1。
- lastindexOf( Object o ):返回此列表中指定元素的最后一次出现的索引，如果列表不包含此元素，返回-1。
- isEmpty（）：如果列表为空，返回true。
- iterator()：返回列表中元素的迭代器。
- listIterator（）：返回列表的列表迭代器（按适当的顺序）。
- listIterator(int index)：从适当的位置返回列表的列表迭代器（按照正确的顺序）。

#### 遍历方法

```java
List<E> list = new ArrayList<E>();

// 1. 迭代器
Iterator<E> iterator = list.iterator();
while(iterator.hasNext()){
    System.out.println(iterator.next());
}

// 2. 效率最高
for(int i=0;i<list.size();i++){
    E e = list.get(i);
    System.out.println(e);
}

// 3. for-each
for(E e:list){
    System.out.println(e);
}

```

