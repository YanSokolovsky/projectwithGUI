package lfm.lfm.rarzip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipDearchivator extends Dearchivator {
    public ZipDearchivator(String filename) {
        archFile = filename;
        String address = getAddressOfFile(filename);
        address += "\\ZipDearchiveResult\\";
        setStandardName(address);
    }
    @Override
    public ArrayList<String> dearchive() {
        ArrayList<String> names = new ArrayList<>();
        File directory = new File(standardName);
        if (!directory.exists()){
            directory.mkdirs();
        }
        try(ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(archFile)))
        {
            ZipEntry entry;
            String name;
            while((entry = zipInputStream.getNextEntry())!=null){
                name = entry.getName();
                String shortName = getShortName(name);
                String NormalNameOfFile = standardName + shortName;
                names.add(NormalNameOfFile);
                FileOutputStream fileOutputStream = new FileOutputStream(NormalNameOfFile);
                for (int c = zipInputStream.read(); c != -1; c = zipInputStream.read()) {
                    fileOutputStream.write(c);
                }
                fileOutputStream.flush();
                zipInputStream.closeEntry();
                fileOutputStream.close();
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return names;
    }
    @Override
    public ArrayList<String> dearchive(String fileDestination) {
        fileDestination += "\\";
        ArrayList<String> names = new ArrayList<>();
        try(ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(archFile)))
        {
            ZipEntry entry;
            String name;
            while((entry = zipInputStream.getNextEntry())!=null){
                name = entry.getName();
                name = getShortName(name);
                name = fileDestination + name;
                names.add(name);
                FileOutputStream fileOutputStream = new FileOutputStream(name);
                for (int c = zipInputStream.read(); c != -1; c = zipInputStream.read()) {
                    fileOutputStream.write(c);
                }
                fileOutputStream.flush();
                zipInputStream.closeEntry();
                fileOutputStream.close();
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return names;
    }
}
