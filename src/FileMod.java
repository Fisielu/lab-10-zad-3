import java.io.*;

public class FileMod {
    public static void copyAndReplaceSpaces(String inputFile, String outputFile) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.replace(" ", "-"));
                writer.newLine();
            }
            System.out.println("Plik został skopiowany do '" + outputFile + "', a spacje zastąpiono myślnikami.");
        } catch (FileNotFoundException e) {
            System.err.println("Plik '" + inputFile + "' nie został znaleziony.");
        } catch (IOException e) {
            System.err.println("Wystąpił błąd wejścia/wyjścia: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String inputFilename = "wejscie.txt";
        String outputFilename = "wyjscie.txt";

        copyAndReplaceSpaces(inputFilename, outputFilename);
    }
}
