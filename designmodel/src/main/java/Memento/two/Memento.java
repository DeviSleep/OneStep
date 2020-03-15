package Memento.two;

import java.io.Serializable;

/**
 * 备忘录类: 一般将要保存的原发者属性定义为成员变量，定义get,set方法
 */
public class Memento implements Serializable {
    private int pos;

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
