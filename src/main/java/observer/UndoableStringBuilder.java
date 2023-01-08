package observer;
import java.util.Stack;

public class UndoableStringBuilder {

    StringBuilder str;
    int size;
    Stack<StringBuilder> stk;


    /**
     * A constructor that creates an object that contains the string and a stack
     * to save the changes in the string
     */
    public UndoableStringBuilder(String str){
        this.str = new StringBuilder();
        this.stk = new Stack<StringBuilder>();
        if(str==null){
            StringBuilder tmp = new StringBuilder("");
            stk.push(tmp);
            size = 1;
        }
        else {
            StringBuilder tmp = new StringBuilder(str);
            stk.push(tmp);
            size = 1;
        }
//        System.out.println(stk);
    }


    /**
     * Empty constructor
     */
    public UndoableStringBuilder(){
        this.str = new StringBuilder();
        this.stk = new Stack<StringBuilder>();
        StringBuilder tmp = new StringBuilder();
        stk.push(tmp);
        size++;
//        System.out.println(stk);
    }


    /**
     * appends a string to the original string
     * @param st - the string you want to append
     * @return the StringBuilder after the append
     */
    public UndoableStringBuilder append(String st){
        if(st == null){
            System.out.println("no change");
            return this;
        }
        StringBuilder tmp = new StringBuilder(stk.peek());
        tmp.append(st);
        stk.push(tmp);
        size++;
//        System.out.println(stk);
        return this;
    }

    /**
     * deletes chars in the StringBuilder between 2 indexes
     *
     * @param start - first index to delete
     * @param end   - last index to delete
     * @return the StringBuilder after the deletion
     */
    public UndoableStringBuilder delete(int start, int end) { // deletes a substring
        try {
            StringBuilder tmp = new StringBuilder(stk.peek());
            tmp.delete(start, end);
            stk.push(tmp);
            size++;
//            System.out.println(stk);
        }
        catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return this;
    }

    /**
     * insert a String to the StringBuilder into a chosen index
     * @param offset - the index you want to insert the String
     * @param st - a String your want to insert
     * @return the StringBuilder after the change
     */

    public UndoableStringBuilder insert(int offset, String st){ //insert a string into the original string
        try {
            StringBuilder tmp = new StringBuilder(stk.peek());
            tmp.insert(offset, st);
            stk.push(tmp);
            size++;
//        System.out.println(stk);
        }
        catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return this;
    }

    /**
     * takes a substring from index start to end and replace it with st
     * @param start - first index to change
     * @param end - last index, the index before the "end" is the last index to be changed
     * @param st - the string you want to replace instead the substring
     * @return the StringBuilder after the change
     */
    public UndoableStringBuilder replace(int start, int end, String st){ // replaces a substring with another substring
        try {
            StringBuilder tmp = new StringBuilder(stk.peek());
            tmp.replace(start, end, st);
            stk.push(tmp);
            size++;
//            System.out.println(stk);
        }
        catch (IndexOutOfBoundsException | NullPointerException e){
            e.printStackTrace();
        }
        return this;
    }

    /**
     * writes the StringBuilder from end to start
     * @return the reversed StringBuilder
     */

    public UndoableStringBuilder reverse(){ // writes the string conversed
        StringBuilder tmp = new StringBuilder(stk.peek());
        tmp.reverse();
        stk.push(tmp);
        size++;
//        System.out.println(stk);
        return this;
    }

    /**
     * undo the last change of the StringBuilder
     * @return the previous StringBuilder
     */

    public void undo() { //removes the last string from the stack
        if (size > 1) {
            stk.pop();
        } else {
            System.out.println("cant undo unto a null");
        }
    }

    /**
     * writes the StringBuilder as String and not as address
     * @return the StringBuilder
     */

    public String toString() { //return the last string in the stack

        if (stk.isEmpty()) {
            return "";
        }
        return stk.peek().toString();
    }
    public static void main(String[] args) throws Exception {
        UndoableStringBuilder yo = new UndoableStringBuilder("yogev");
        System.out.println(yo);
        yo.replace(-1,12,"gever");
        System.out.println(yo);
        yo.append(" ok");
        System.out.println(yo);

//        yo.append("to be or not to be");
//        System.out.println(yo);
//        System.out.println(yo);
//        yo.replace(3,5,"eat");
//        System.out.println(yo);
//        yo.replace(17,19,"eat");
//        System.out.println(yo);
//        yo.undo();
//        yo.undo();
//        yo.undo();
//        yo.undo();
//        yo.undo();
//        yo.undo();
//        System.out.println(yo);


    }
}
