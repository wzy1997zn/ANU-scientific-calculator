package au.edu.anu.scientificcalculator.file;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static final String FILE_NAME = "recently.txt";

    private Context context;

    public FileUtil(Context context) {
        this.context = context;
    }

    public void save(List<String> datas) {
        if (datas != null) {
            try {
                String filePath = "";
                if (context != null) {
                    filePath = context.getFilesDir() +  "/" + FILE_NAME;
                } else {
                    filePath = FILE_NAME;
                }

                FileWriter fw = new FileWriter(filePath);
//                System.out.println(context.getFilesDir() +  "/" + FILE_NAME);
                //write down data and next
                for (int i = 0; i < datas.size(); i++) {
                    fw.write(datas.get(i) + "\r\n");
                }
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public List<String> loadFile(){
        List<String> lists = new ArrayList<>();
        try {
            String filePath = "";
            if (context != null) {
                filePath = context.getFilesDir() +  "/" + FILE_NAME;
            } else {
                filePath = FILE_NAME;
            }
            File file = new File(filePath);
            InputStream instream = new FileInputStream(file);
            if (instream != null) {
                InputStreamReader inputreader
                        = new InputStreamReader(instream, "GBK");
                BufferedReader buffreader = new BufferedReader(inputreader);
                String line = "";
                while ((line = buffreader.readLine()) != null) {
                    lists.add(line);
                }
                instream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

}
