package observer;

import java.util.ArrayList;

public class GroupAdmin implements Sender{

    private ArrayList<Member> arr = new ArrayList<Member>();
    private UndoableStringBuilder usb = new UndoableStringBuilder();

    @Override
    public void register(Member obj) {
        this.arr.add(obj);
    }

    @Override
    public void unregister(Member obj) {
        this.arr.remove(obj);
    }

    @Override
    public void insert(int offset, String obj) {
        this.usb.insert(offset, obj);
    }

    @Override
    public void append(String obj) {
        this.usb.append(obj);
    }

    @Override
    public void delete(int start, int end) {
        this.usb.delete(start, end);
    }

    @Override
    public void undo() {
        this.usb.undo();
    }

    public void notifyMember(){
        for(Member m: arr){
            m.update(this.usb);
        }
    }
}
