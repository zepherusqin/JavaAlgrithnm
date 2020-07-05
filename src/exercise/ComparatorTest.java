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
public class ComparatorTest {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("ace",22));
        personList.add(new Person("xb",21));
        personList.add(new Person("glm",36));
        personList.add(new Person("sxy",20));
        personList.sort(new PersonSortByAge());
        for(Person i: personList) {
            System.out.println(i);
        }
    }
}
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class PersonSortByAge implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.age - o2.age;
    }
}