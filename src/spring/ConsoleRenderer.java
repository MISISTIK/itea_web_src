package spring;

public class ConsoleRenderer implements MsgRenderer {

    private MsgProvider mp;

    @Override
    public void setMsgProvider(MsgProvider mp) {
        this.mp = mp;
    }

    @Override
    public void renderString() {
        System.out.println(mp.getString());
    }
}
