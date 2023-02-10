import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class DeleteRepeatPic {

    Set<String> addedSet;
    String parentAbsoluteStr;

    public DeleteRepeatPic() {

    }

    public void delete(String aimFileStr) {
        File aimFile = new File(aimFileStr);

        this.addedSet = new HashSet();
        this.parentAbsoluteStr = aimFile.getParent();

        File bakFile = new File(parentAbsoluteStr + "\\" + "bakDir");
        System.out.println("init...create bakDir:" + bakFile.mkdir());

        deleteRepeatFile(aimFile);
    }

    public void deleteRepeatFile(File aimFile) {
        File[] files = aimFile.listFiles();
        for (File file :
                files) {
            if (file.isDirectory()) {
                //是文件夹
                deleteRepeatFile(file);
            } else {
                //picture
                if (!addedSet.contains(file.getName())) {
                    addedSet.add(file.getName());
                } else {
                    //用移动到备用文件后删除源目录的文件
                    String newNamePre=parentAbsoluteStr + "\\bakDir\\" ;
                    boolean isSuccess = file.renameTo(new File(newNamePre+ file.getName()));
                    if (!isSuccess){
                        for (int i = 0; i < 5; i++) {
                           if (file.renameTo(new File(newNamePre+"("+i+")"+ file.getName()))){
                               break;
                           }
                            System.out.println("repeat"+i);
                        }
                    }
//                    file.delete();
                }
            }
        }
    }
}
