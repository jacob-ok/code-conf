import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author https://blog.csdn.net/chen_2890
 * @description FileUtil
 * @date 2019/6/14 17:29
 */
public class FileUtil {

    /**
     * @description ��ʹ�õݹ�ķ�������
     * @param path �ļ���·��
     * @return java.util.List<java.io.File>
     * @author https://blog.csdn.net/chen_2890
     * @date 2019/6/14 17:34
     * @version V1.0
     */
    public static List<File> traverseFolder1(String path) {
        List<File> fileList = new ArrayList<>();
        int fileNum = 0, folderNum = 0;
        File file = new File(path);
        if (file.exists()) {
            LinkedList<File> list = new LinkedList<File>();
            File[] files = file.listFiles();
            for (File file2 : files) {
                if (file2.isDirectory()) {
                    System.out.println("�ļ���:" + file2.getAbsolutePath());
                    list.add(file2);
                    folderNum++;
                } else {
                    fileList.add(file2);
                    System.out.println("�ļ�:" + file2.getAbsolutePath());
                    fileNum++;
                }
            }
            File temp_file;
            while (!list.isEmpty()) {
                temp_file = list.removeFirst();
                files = temp_file.listFiles();
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        System.out.println("�ļ���:" + file2.getAbsolutePath());
                        list.add(file2);
                        folderNum++;
                    } else {
                        fileList.add(file2);
                        System.out.println("�ļ�:" + file2.getAbsolutePath());
                        fileNum++;
                    }
                }
            }
        } else {
            System.out.println("�ļ�������!");
        }
        System.out.println("�ļ��й���:" + folderNum + ",�ļ�����:" + fileNum);
        return fileList;
    }
    /**
     * @description ʹ�õݹ�ķ�������
     * @param path �ļ���·��
     * @return java.util.List<java.io.File>
     * @author https://blog.csdn.net/chen_2890
     * @date 2019/6/14 17:35
     * @version V1.0
     */
    public static List<File> traverseFolder2(String path) {
        List<File> fileList = new ArrayList<>();
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {
                System.out.println("�ļ����ǿյ�!");
                return null;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        System.out.println("�ļ���:" + file2.getAbsolutePath());
                        traverseFolder2(file2.getAbsolutePath());
                    } else {
                        fileList.add(file2);
                        System.out.println("�ļ�:" + file2.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("�ļ�������!");
        }
        return fileList;
    }

    /**
     * @description ʹ�õݹ�ķ������ã����ж��ļ����Ƿ���.jpg��β
     * @param path �ļ���·��
     * @return java.util.List<java.io.File>
     * @author https://blog.csdn.net/chen_2890
     * @date 2019/6/14 17:35
     * @version V1.0
     */
    public static List<File> getFileList(String path) {
        List<File> fileList = new ArrayList<>();
        File dir = new File(path);
        // ���ļ�Ŀ¼���ļ�ȫ����������
        File[] files = dir.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                // �ж����ļ������ļ���
                if (files[i].isDirectory()) {
                    // ��ȡ�ļ�����·��
                    getFileList(files[i].getAbsolutePath());
                    // �ж��ļ����Ƿ���.jpg��β
                } else if (fileName.endsWith(".jpg")) {
                    String strFileName = files[i].getAbsolutePath();
                    System.out.println("---" + strFileName);
                    fileList.add(files[i]);
                } else {
                    continue;
                }
            }
        }
        return fileList;
    }
}


