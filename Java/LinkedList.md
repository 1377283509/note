### LinkedList

#### 简介

Java的LinkedList是一种常用的数据容器，与ArrayList相比，LinkedList的增删操作效率更高，而查改操作效率较低。
LinkedList 实现了List 接口，能对它进行列表操作。
LinkedList 实现了Queue 接口，即能将LinkedList当作双端队列使用。
LinkedList 实现了Cloneable接口，能克隆。
LinkedList 实现了java.io.Serializable接口，这意味着LinkedList支持序列化，能通过序列化去传输。

#### 构造方法

```java
// 创建一个空的list
public LinkedList() {
    this.size = 0;
}
// 将一个包含集合var1所有元素的list
public LinkedList(Collection<? extends E> var1) {
    this();
    this.addAll(var1);
}

```

#### 常用方法

##### 增

- public boolean add(E e)，链表末尾添加元素，返回是否成功；
- public void add(int index, E element)，向指定位置插入元素element；
- public boolean addAll(Collection<? extends E> c)，将一个集合的所有元素添加到链表后面，返回是否成功；
- public boolean addAll(int index, Collection<? extends E> c)，将一个集合的所有元素添加到链表的指定位置后面，返回是否成功；
- public void addFirst(E e)，添加到第一个元素；
- public void addLast(E e)，添加到最后一个元素；
- public boolean offer(E e)，向链表末尾添加元素，返回是否成功；
- public boolean offerFirst(E e)，头部插入元素，返回是否成功；
- public boolean offerLast(E e)，尾部插入元素，返回是否成功；

##### 删

- public void clear()，清空链表；
- public E removeFirst()，删除并返回第一个元素；
- public E removeLast()，删除并返回最后一个元素；
- public boolean remove(Object o)，删除某一元素，返回是否成功；
- public E remove(int index)，删除指定位置的元素；
- public E poll()，删除并返回第一个元素；
- public E remove()，删除并返回第一个元素；

##### 查

- public boolean contains(Object o)，判断是否含有某一元素；
- public E get(int index)，返回指定位置的元素；
- public E getFirst(), 返回第一个元素；
- public E getLast()，返回最后一个元素；
- public int indexOf(Object o)，查找指定元素从前往后第一次出现的索引；
- public int lastIndexOf(Object o)，查找指定元素最后一次出现的索引；
- public E peek()，返回第一个元素；
- public E element()，返回第一个元素；
- public E peekFirst()，返回头部元素；
- public E peekLast()，返回尾部元素；

##### 改

- public E set(int index, E element)，设置指定位置的元素；

##### 其他

- public Object clone()，克隆该列表；
- public Iterator<E> descendingIterator()，返回倒序迭代器；
- public int size()，返回链表元素个数；
- public ListIterator<E> listIterator(int index)，返回从指定位置开始到末尾的迭代器；
- public Object[] toArray()，返回一个由链表元素组成的数组；
- public <T> T[] toArray(T[] a)，返回一个由链表元素转换类型而成的数组；

 

 

 

