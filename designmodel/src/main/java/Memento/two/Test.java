package Memento.two;

import java.util.Scanner;

/**
 * Created by des on 2020/3/15.
 */
public class Test {
    public static void main(String[] args) {
        ReadTopic rd = new ReadTopic();
        Memento me = new Memento();
        Caretaker ct = new Caretaker();

        Scanner sc = new Scanner(System.in);
        System.out.println("从断点处计算吗？ ");
        String strMark = sc.nextLine();
        if (strMark.equals("y")){
            me = ct.getMemento();
            rd.restoreFromMe(me);
        }

        do {
            String strTopic = rd.getNextTopic();
            System.out.println(strTopic);
            sc.nextLine();
            System.out.println("继续做题吗？ ");
            strMark = sc.nextLine();
            strMark = sc.nextLine();
        }while (strMark.equals("y"));

        me = rd.creatMemento();
        rd.close();
        ct.saveMemento(me);
    }
}
