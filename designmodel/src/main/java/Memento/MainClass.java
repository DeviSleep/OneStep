package Memento;

/**
 * 测试类
 */
public class MainClass {

    public static void main(String[] args) {
        Person per = new Person("desviSleep", "男", 30);

        // 保存内部状态
        Person backup = new Person();
        backup.setName(per.getName());
        backup.setSex(per.getSex());
        backup.setAge(per.getAge());
        System.out.println(per.toString());

        // 修改
        per.setAge(28);
        System.out.println(per.toString());

        //回滚 还原
        per.setName(backup.getName());
        per.setAge(backup.getAge());
        per.setSex(backup.getSex());
        System.out.println(per.toString());

        // -----------------------test2-------------
        System.out.println();
        testMemento();
        // -----------------------test3-------------
        System.out.println();
        test3();
    }

    /**
     * 备忘录1
     */
    public static void testMemento() {
        Person per = new Person("desviSleep2", "男", 30);

        Menmento menmento = per.creatMemento();
        System.out.println(per.toString());

        per.setName("chen quan");
        per.setAge(29);
        System.out.println(per.toString());

        per.setMemento(menmento);
        System.out.println(per.toString());

    }

    // 备忘录2
    public static void test3() {
        Person per = new Person("desviSleep3", "男", 20);

        Caretaker caretaker = new Caretaker();
        caretaker.setMenmento(per.creatMemento());
        System.out.println(per.toString());

        per.setName("chen-quan");
        per.setAge(29);
        System.out.println(per.toString());

        per.setMemento(caretaker.getMenmento());
        System.out.println(per.toString());
    }
}
