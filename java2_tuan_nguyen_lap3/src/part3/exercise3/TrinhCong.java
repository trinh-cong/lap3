package part3.exercise3;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TrinhCong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        File directory = new File(path);
        if (!directory.exists()) {
            System.out.println("Error: Directory not found.");
                return;
        }
        if (!directory.isDirectory()) {
            System.out.println("Error: Path is not a directory.");
            return;
        }
        File[] fileList = directory.listFiles();

        System.out.println("\nDirectory of " + directory.getAbsolutePath() + "\n");
        for (File file : fileList) {
            String fileName = file.getName();
            long fileSize = file.length();
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            String fileDate = dateFormat.format(file.lastModified());
            String fileType = file.isDirectory() ? "<DIR>" : "";

            System.out.printf("%-30s %15s %25s %s\n", fileName, fileType, fileSize + " bytes", fileDate);
        }
    }
}
