package com.javarush.test.level17.lesson10.home01;

import java.util.*;

/* Общий список
1. Изменить класс Solution так, чтобы он стал списком. (Необходимо реализовать интерфейс java.util.List).
2. Список Solution должен работать только с целыми числами Long.
3. Воспользуйтесь полем original.
4. Список будет использоваться нитями, поэтому позаботьтесь, чтобы все методы были синхронизированы.
*/

public class Solution implements List<Long>{
    private ArrayList<Long> original = new ArrayList<Long>();
public synchronized int size(){
    return original.size();}
 public synchronized boolean isEmpty(){return original.isEmpty(); }
    public synchronized boolean contains(Object o){ return original.contains(o);}
    public synchronized Iterator<Long> iterator(){ return original.iterator();}
    public synchronized Object [] toArray(){ return original.toArray();}
    public synchronized <T> T[] toArray(T[] a){ return original.toArray(a);}
    public synchronized boolean add(Long r){ return original.add(r); }
    public synchronized boolean remove(Object r){ return original.remove(r);}
    public synchronized boolean containsAll(Collection<?> a){ return original.containsAll(a);}
    public synchronized boolean addAll(Collection<? extends Long> c){ return original.addAll(c);}
    public synchronized boolean addAll(int index, Collection<? extends Long> d) {return original.addAll(index, d);}
    public synchronized boolean removeAll(Collection<?> a){ return original.removeAll(a);}
    public synchronized boolean retainAll(Collection<?> a) { return original.retainAll(a);}
    public synchronized void clear(){ original.clear();}
    public synchronized Long get(int index) { return original.get(index);}
    public synchronized Long set(int index, Long e){ return original.set(index, e);}
    public synchronized void add(int i, Long e){ original.add(i,e);}
    public synchronized Long remove(int index){ return original.remove(index);}
    public synchronized int indexOf(Object o){ return original.indexOf(o);}
    public synchronized ListIterator<Long> listIterator(){return original.listIterator();}
    public synchronized ListIterator<Long> listIterator(int index){return original.listIterator(index);}
    public synchronized List subList(int i, int h){return original.subList(i, h);}
    public synchronized  int lastIndexOf(Object o){ return original.lastIndexOf(o);}



}
