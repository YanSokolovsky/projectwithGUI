package lfm.lfm.rarzip;

import com.github.junrar.Junrar;
import com.github.junrar.exception.RarException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RarDearchivator extends Dearchivator {
    public RarDearchivator(String filename) {
        archFile = filename;
        String address = getAddressOfFile(filename);
        address += "\\RarDearchiveResult\\";
        setStandardName(address);
    }
    public ArrayList<String> getNames(List<File> files) {
        ArrayList<String> names = new ArrayList<>();
        for (File f : files) {
            names.add(f.getName());
        }
        return names;
    }
    @Override
    public ArrayList<String> dearchive() {
        List<File> files = new ArrayList<>();
        File rarFile = new File(archFile);
        File directory = new File(standardName);
        if (!directory.exists()){
            directory.mkdirs();
        }
        File destDir = new File(standardName);
        try {
            files = Junrar.extract(rarFile, destDir);
        } catch (IOException | RarException e) {
            e.printStackTrace();
        }
        return getNames(files);
    }
    @Override
    public ArrayList<String> dearchive(String fileDestination) {
        List<File> files = new ArrayList<>();
        File rarFile = new File(archFile);
        File destDir = new File(fileDestination);
        try {
            files = Junrar.extract(rarFile, destDir);
        } catch (IOException | RarException e) {
            e.printStackTrace();
        }
        return getNames(files);
    }
}
