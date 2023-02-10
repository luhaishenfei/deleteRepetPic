import java.io.File;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws Exception {
        String aimDir = "D:\\code\\java\\repeatPictureDelete\\testDir";
        DeleteRepeatPic deleteRepeatPic=new DeleteRepeatPic();
        deleteRepeatPic.delete(aimDir);
    }
}
