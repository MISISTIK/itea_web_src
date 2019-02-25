package spring;

public class MessageProvider implements MsgProvider {
    @Override
    public String getString() {
        return "Hello from MsgProvider";
    }
}
