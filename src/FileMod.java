import java.io.*;
import java.nio.file.*;

public class FileMod {
    public static void main(String[] args) {
        String fileName = "example.txt";
        String initialContent = "Ala nie ma kota.\n";

        try {

            createFile(fileName, initialContent);

            String content = readFile(fileName);
            System.out.println("Oryginalna zawartość pliku:");
            System.out.println(content);

            String modifiedContent = content + "Ale Ala może adoptować kotka ze schroniska.\n";
            writeFile(fileName, modifiedContent);

            System.out.println("Zmodyfikowana zawartość pliku:");
            System.out.println(readFile(fileName));
        } catch (IOException e) {
            System.out.println("Wystąpił błąd: " + e.getMessage());
        }
    }

    public static void createFile(String fileName, String content) throws IOException {
        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            Files.write(path, content.getBytes());
            System.out.println("Plik został utworzony: " + fileName);
        } else {
            System.out.println("Plik już istnieje: " + fileName);
        }
    }

    public static String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void writeFile(String fileName, String content) throws IOException {
        Files.write(Paths.get(fileName), content.getBytes());
        System.out.println("Zawartość została zapisana do pliku: " + fileName);
    }
}
