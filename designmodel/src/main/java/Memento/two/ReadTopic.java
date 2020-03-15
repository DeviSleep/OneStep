package Memento.two;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 原发者类
 */
public class ReadTopic {
    private long pos;
    private String strPath;
    private RandomAccessFile in;

    public ReadTopic(){
        strPath = this.getClass().getResource("/").getPath();
        try {
            in = new RandomAccessFile(strPath+"Memento/two/MyTopic.txt","rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 负责根据备忘录对象获取上次答题断点处
     * @param memento
     */
    public void restoreFromMe (Memento memento){
        pos = memento.getPos();
        try {
            in.seek(pos);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 负责将答题位置封装成备忘录对象
     * @return
     */
    public Memento creatMemento(){
        try {
            pos = in.getFilePointer();
        } catch (IOException e) {
        }
        Memento me = new Memento();
        me.setPos((int)pos);
        return me;
    }

    /**
     * 负责获取当前答题题目
     * @return
     */
    public String getNextTopic(){
        String s = null;
        try {
            s = in.readLine();
        } catch (IOException e) {
        }
        return s;
    }

    /**
     * 关闭答题文件，停止答题
     */
    public void close(){
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
