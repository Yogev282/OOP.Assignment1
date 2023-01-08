package observer;

public class ConcreteMember implements Member{

    private String name;
    private UndoableStringBuilder usb;

    public ConcreteMember(){
        this.name = null;
        this.usb = null;
    }
    @Override
    public void update(UndoableStringBuilder usb) {
        this.usb = usb;
    }
}
