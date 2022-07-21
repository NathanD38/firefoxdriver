import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Logger {
    private static Logger instance = null;

    Logger() { }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    // A method to log to file, separately using APPEND.
    public void logToFile(String result) throws IOException {
        String filePath = "YearlyReports.txt";
        Files.write(Paths.get(filePath), (result + "\n").getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
    }

    // A method to clear the contents of the file upon each run,
// so it would not append to the contents of a previous run.
    public void clearFile() throws IOException {
        FileWriter fw = new FileWriter("YearlyReports.txt");
        fw.flush();
        fw.close();
    }
}

