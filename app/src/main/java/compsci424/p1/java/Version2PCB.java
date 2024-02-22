/* COMPSCI 424 Program 1
 * Name: Corbin Giese
 */
 package compsci424.p1.java;

/**
 * The process control block structure that is used to track a
 * process's parent, first child, younger sibling, and older sibling
 * (if they exist) in Version 2.
 */
public class Version2PCB {
    private int pid;
    private int parent;
    private int firstChild;
    private int youngerSibling;

    public Version2PCB(int pid) {
        this.pid = pid;
        this.parent = -1;
        this.firstChild = -1;
        this.youngerSibling = -1;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getFirstChild() {
        return firstChild;
    }

    public void setFirstChild(int firstChild) {
        this.firstChild = firstChild;
    }

    public int getYoungerSibling() {
        return youngerSibling;
    }

    public void setYoungerSibling(int youngerSibling) {
        this.youngerSibling = youngerSibling;
    }
}
