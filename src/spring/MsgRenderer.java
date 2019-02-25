package spring;

public interface MsgRenderer {
    void setMsgProvider(MsgProvider mp);
    void renderString();
}
