import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class test21_ZipStream01 {
    public static void main(String[] args) throws Exception {
        File src=new File("01 IO/PixPin_2.0.0.3.zip");
        File dest=new File("01 IO/copy");

        unzip(src,dest);

    }

    public static void unzip(File zipfile,File dest)throws Exception{
        ZipInputStream zis=new ZipInputStream(new FileInputStream(zipfile));
        ZipEntry ze;
        while ((ze = zis.getNextEntry()) != null) {
            System.out.print(ze);
            System.out.println("\t");
            System.out.print(ze.getName());
            System.out.println("\t");
            System.out.println(ze.toString());
            if(ze.isDirectory()){
                File d=new File(dest,ze.getName());
                d.mkdirs();
            }else{
                FileOutputStream bos=new FileOutputStream(new File(dest,ze.getName()));
                int len=0;
                byte[] buf=new byte[1024*8];
                while((len=zis.read(buf))!=-1){
                    bos.write(buf,0,len);
                }
                bos.close();

            }
            zis.closeEntry();
        }
        zis.close();
    }
}
