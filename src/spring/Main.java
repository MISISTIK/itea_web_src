package spring;

public class Main {
    public static void main(String[] args) {
        MsgProvider mp = MsgServiceFactory.getMsgProvider();
        MsgRenderer cr = MsgServiceFactory.getMsgRenderer();
        cr.setMsgProvider(mp);
        cr.renderString();
    }
}
