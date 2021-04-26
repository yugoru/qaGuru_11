package helpers;

import com.codeborne.pdftest.PDF;
import java.io.File;
import java.io.IOException;


public class FormatFiles {
    public static File getFile(String path) {
        return new File(path);
    }

    public static PDF getPdf(String path) throws IOException {
        return new PDF(getFile(path));
    }
}
