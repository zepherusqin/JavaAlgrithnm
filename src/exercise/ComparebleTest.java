package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/4 0004
 * @Description: exercise
 * @version: 1.0
 */
public class ComparebleTest {
    public static void main(String[] args) {
        List<P> personList = new ArrayList<P>();
        personList.add(new P("ace",22));
        personList.add(new P("xb",21));
        personList.add(new P("glm",36));
        personList.add(new P("sxy",20));
        System.out.println("比较大小");
        P ace = new P("ace",22);
        P xb = new P("xb",21);
        String result = ace.compareTo(xb)==0?"一样大":ace.compareTo(xb)>0?"ace大":"xb大";
        System.out.println(result);
        System.out.println("按照年龄");
        Collections.sort(personList);
        for(P p:personList)
            System.out.println(p);
        System.out.println();
    }
}
class P implements Comparable<P>{
    String name;
    int age;

    public P(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "P{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(P o) {
        return this.age - o.age;
    }
}
