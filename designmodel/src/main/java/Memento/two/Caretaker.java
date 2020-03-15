package Memento.two;

import java.io.*;

/**
 * 备忘录管理类
 */
public class Caretaker {
    File file;
    String strPath;

    Caretaker() {
        strPath = this.getClass().getResource("/").getPath();
        file = new File(strPath + "Memento/two/Mymeme.txt");
    }

    /**
     * 负责读取备忘录文件并恢复备忘录对象
     * @return
     */
    public Memento getMemento() {
        Memento me = new Memento();
        if (file.exists()) {
            try {
                FileInputStream in = new FileInputStream(strPath + "Memento/two/Mymeme.txt");
                ObjectInputStream in2 = new ObjectInputStream(in);
                me = (Memento) in2.readObject();
                in2.close();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return me;
    }

    /**
     * 负责将备忘录对象保存到文件中
     * @param memento
     */
    public void saveMemento(Memento memento){
        try {
            FileOutputStream out = new FileOutputStream(strPath+"Memento/two/Mymeme.txt");
            ObjectOutputStream outObj = new ObjectOutputStream(out);
            outObj.writeObject(memento);
        } catch ( Exception e) {
            e.printStackTrace();
        }

    }

}
