/* COMPSCI 424 Program 1
 * Name: Corbin Giese
 */
package compsci424.p1.java;
import java.util.ArrayList;
/**
 * The process control block structure that is used to track a
 * process's parent and children (if any) in Version 1.
 */
public class Version1PCB {
    private int pid;
    private int parent;
    private ArrayList<Integer> children;

    public Version1PCB(int pid) {
        this.pid = pid;
        this.parent = -1;
        this.children = new ArrayList<>();
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public ArrayList<Integer> getChildren() {
        return children;
    }

    public void addChild(int childPid) {
        children.add(childPid);
    }

    public void removeChild(int childPid) {
        children.remove(Integer.valueOf(childPid));
    }
}
