/* COMPSCI 424 Program 1
 * Name: Corbin Giese
 */
 package compsci424.p1.java;

/** 
 * Implements the process creation hierarchy for Version 1, which uses
 * linked lists.
 * 
 * This is a template. Program1.java *must* contain the main class
 * for this program. Otherwise, feel free to edit these files, even
 * these pre-written comments or my provided code. You can add any
 * classes, methods, and data structures that you need to solve the
 * problem and display your solution in the correct format.
 */
import java.util.ArrayList;
public class Version1 {
    // Declare any class/instance variables that you need here.
    private Version1PCB[] pcbs;
    private boolean[] pcbFree;
    /**
     * Default constructor. Use this to allocate (if needed) and
     * initialize the PCB array, create the PCB for process 0, and do
     * any other initialization that is needed. 
     */
    public Version1() {
        pcbs = new Version1PCB[16];
        pcbFree = new boolean[16];
        for (int i = 0; i < 16; i++) {
            pcbs[i] = new Version1PCB(i);
            pcbFree[i] = true;
        }
    }

    /**
     * Creates a new child process of the process with ID parentPid. 
     * @param parentPid the PID of the new process's parent
     * @return 0 if successful, not 0 if unsuccessful
     */
    int create(int parentPid) {
        Version1PCB parent = pcbs[parentPid];
        if (parent == null) {
            System.out.println("Parent process does not exist.");
            return -1;
        }
        int newPid = findFreePid();
        if (newPid == -1) {
            System.out.println("No free PCB available.");
            return -1;
        }
        pcbs[newPid].setParent(parentPid);
        parent.addChild(newPid);
        return 0;
    }

    /**
     * Recursively destroys the process with ID parentPid and all of
     * its descendant processes (child, grandchild, etc.).
     * @param targetPid the PID of the process to be destroyed
     * @return 0 if successful, not 0 if unsuccessful
     */
    int destroy (int targetPid) {
        Version1PCB target = pcbs[targetPid];
        if (target == null) {
            System.out.println("Process does not exist.");
            return -1;
        }
        destroyRecursive(targetPid);
        int parentPid = target.getParent();
        if (parentPid != -1) { 
            pcbs[parentPid].removeChild(targetPid);
        }
        pcbs[targetPid] = null;
        return 0;
    }
    
    private void destroyRecursive(int pid) {
        Version1PCB process = pcbs[pid];
        ArrayList<Integer> children = process.getChildren();
        for (int childPid : children) {
            destroyRecursive(childPid);
            pcbs[childPid] = null;
        }
    }
    
    /**
     * Traverse the process creation hierarchy graph, printing
     * information about each process as you go. See Canvas for the
     * *required* output format. 
     *         
     * You can directly use "System.out.println" statements (or
     * similar) to send the required output to stdout, or you can
     * change the return type of this function to return the text to
     * the main program for printing. It's your choice. 
     */
    void showProcessInfo() {
        for (int i = 0; i < 16; i++) {
            if (pcbs[i] != null) {
                System.out.print("Process " + i + ": parent is " + pcbs[i].getParent() + " and children are ");
                ArrayList<Integer> children = pcbs[i].getChildren();
                if (children.isEmpty()) {
                    System.out.println("none");
                } else {
                    for (int child : children) {
                        System.out.print(child + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
    
    private int findFreePid() {
        for (int i = 0; i < 16; i++) {
            if (pcbFree[i]) {
                pcbFree[i] = false;
                return i;
            }
        }
        return -1;
    }
       
    /* If you need or want more methods, feel free to add them. */
    
}
