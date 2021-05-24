package Utils;

import java.io.*;

public class FileUtils {

    public static BufferedReader getReader(String name) throws UnsupportedEncodingException, FileNotFoundException {
        return new BufferedReader(new InputStreamReader(new FileInputStream(getFileForName(name)), "UTF8"));
    }

    public static PrintWriter getPrintWriter(String name) throws UnsupportedEncodingException, FileNotFoundException {
        return new PrintWriter(new OutputStreamWriter(new FileOutputStream(getFileForName(name)), "UTF8"));
    }

    public static File getFileForName(String name) {
        String dir = System.getProperty("user.dir");
        String sP = System.getProperty("file.separator");
        File dirTaxiService = new File(dir + sP+ "prodavnica");
        if (!dirTaxiService.exists()) {
            dirTaxiService.mkdirs();
        }
        File file = new File(dirTaxiService.getAbsolutePath() + sP+ name + ".csv");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

}
