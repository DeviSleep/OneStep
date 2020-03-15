package Memento;

/**
 * 备忘录
 */
public class Menmento {
    // 姓名
    private String name;
    // 性别
    private String sex;
    // 年龄
    private int age;

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public Menmento(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

//    public void display() {
//        System.out.println(" name:" + name + " sex:" + sex
//                + " age:" + age);
//    }

}
