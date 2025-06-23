package com.examples;

import java.io.*;


public class App {
    public static void main(String[] args) {

        // Step 1 (Creating the file)
        File file = new File("data/student_data.txt");

        if (file.exists()) {
            System.out.println("File already exists.");
        } else {
            System.out.println("File doesn't exist. Creating file.");
            try {
                boolean newFileCreated = file.createNewFile(); // creating new file.

            } catch (Exception ex) {
                System.out.println("Error, could not create file.");
                System.exit(1);
            }
        }

        // Step 2 (Writing data to file)
        try {
            FileWriter writer = new FileWriter("data/student_data.txt");
            writer.write("Alice, A\n");
            writer.write("Bob, B\n");
            writer.write("Charlie, A+\n");
            writer.close();

        } catch (Exception ex) {
            System.out.println("Error, could not write to file.");
        }

        // Step 3 (Appending to file)
        try {
            FileWriter writer = new FileWriter("data/student_data.txt", true);
            writer.write("David, B+\n");
            writer.write("Eva, A\n");
            writer.close();

        } catch (Exception ex) {
            System.out.println("Error, could not append to file.");
        }

        // Step 4 (Read from file)

        try (BufferedReader reader = new BufferedReader(new FileReader("data/student_data.txt"))) {
            String line;

            System.out.println("=== Reading from the file ===");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception ex) {
            System.out.println("Error, could not read to file.");
        }

        // Step 5 (File paths)

        try  {
            String relativePath = "data/student_data.txt";
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Relative Path: " + relativePath);

            // Compared to the relative path, the absolute path starts from the root instead of the current file the java project is in.
            // Also notice, the relative path is a part of absolute path (ex: data/student_data.txt is both in the abs. and rel. paths)
        } catch (Exception ex) {
            System.out.println("Error, could not find file path of file.");
        }


        // Step 6 (Delete file)
        try  {
            boolean isDeleted = file.delete();

            if (isDeleted) {
                System.out.println("student_data.txt deleted");
            } else {
                System.out.println("student_data.txt was not deleted");
            }
        } catch (Exception ex) {
            System.out.println("Error, could not delete file.");
        }

        // Step 7 (Reflection questions)

        /*
        (1). For me, working with relative paths is a lot easier compared to absolute. Relative path are shorter compared to absolute path making them
        easier to use and remember. For example, in this exercise the relative path for the student data file was only 2 files/folders while the absolute
        was 9 files/folders.

        (2). If I didn't use the try-with-resources try-catch I would have to close every file reader/writer after using it, which could cause a lot of
        unnecessary clutter and potential mistakes. Using a try-with-resources instead allows for the file to be automatically closed after the end of the
        try statement.

        (3). In situations where you both want to preserve and remember old data while adding new data, appending would be useful. One example of this would be
        a long-term logging application. You wouldn't want the log to be overwritten after every new entry, would you? No, would want each log to appended one after
        another in the log text file, ensuring the new data doesn't overwrite the old.

        (4). There are many situations where file IO is necessary. For starters, it allows a program to remember things from time was previously ran. Think save files
        for video games. Another situation where file IO is necessary is inputting large amount of data into the program. Instead of having to painstaking either hard-code
        data or manually input it, you can just give a program a text file with the data and write some code to get the data into the program for processing. This can make programs
        more efficient and versatile.
        
         */

    }
}
