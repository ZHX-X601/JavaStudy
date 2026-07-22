import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class test22_ZipStream02 {
    public static void main(String[] args) throws IOException {
        File src=new File("01 IO/copy/PixPin_2.0.0.3");
        File destparent=src.getParentFile();
        File dest=new File(destparent,src.getName()+".zip");
        ZipOutputStream zos=new ZipOutputStream(new FileOutputStream(dest));
        toZip(src,zos,src.getName());
        zos.close();

    }

    private static void toZip(File src, ZipOutputStream zos, String name) throws IOException {
        File[] files=src.listFiles();
        if(files==null||files.length==0){
            if(files.length==0){
                zos.putNextEntry(new ZipEntry(name));
                zos.closeEntry();
            }
            return;
        }
        for(File file:files){
            if(file.isFile()){
                ZipEntry entry1=new ZipEntry(name+"/"+file.getName());
                zos.putNextEntry(entry1);

                FileInputStream fis=new FileInputStream(file);
                byte[] buffer=new byte[1024*8];
                int len=0;
                while((len=fis.read(buffer))!=-1) {
                    zos.write(buffer, 0, len);
                }
                fis.close();
                zos.closeEntry();
            }else{
                toZip(file,zos,name+"/"+file.getName());
            }
        }

    }
}
