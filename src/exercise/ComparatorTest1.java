package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/4 0004
 * @Description: exercise
 * @version: 1.0
 */
public class ComparatorTest1 {
    public static void main(String[] args) {
        List<Person1> person1List = new ArrayList<Person1>();
        person1List.add(new Person1("ace",22));
        person1List.add(new Person1("xb",21));
        person1List.add(new Person1("glm",36));
        person1List.add(new Person1("sxy",20));
        System.out.println("按照年龄，大的排前面");
        person1List.sort(new PersonSortByAgeBig());
        for(Person1 p:person1List)
            System.out.println(p);
        System.out.println();

        System.out.println("按照年龄，小的排前面");
        person1List.sort(new PersonSortByAgeSmall());
        for(Person1 p:person1List)
            System.out.println(p);


        System.out.println();
        System.out.println("按照名字排序");
        person1List.sort(new PersonSortByName());
        for(Person1 p:person1List)
            System.out.println(p);
    }
}
class Person1 {
    String name;
    int age;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class PersonSortByAgeSmall implements Comparator<Person1> {
    @Override
    public int compare(Person1 o1, Person1 o2) {
        return o1.age - o2.age;
    }
}
class PersonSortByAgeBig implements Comparator<Person1> {
    @Override
    public int compare(Person1 o1, Person1 o2) {
        return o2.age - o1.age;
    }
}
class PersonSortByName implements Comparator<Person1> {
    @Override
    public int compare(Person1 o1, Person1 o2) {
        return o1.name.compareTo(o2.name);
    }
}