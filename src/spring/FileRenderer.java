package spring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileRenderer implements MsgRenderer {
    private MsgProvider mp;

    @Override
    public void setMsgProvider(MsgProvider mp) {
        this.mp = mp;
    }

    @Override
    public void renderString() {
        try {
            Files.write(Paths.get("File.txt"),mp.getString().getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
