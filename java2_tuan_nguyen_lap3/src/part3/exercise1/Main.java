package part3.exercise1;



            import java.io.BufferedReader;
            import java.io.BufferedWriter;
            import java.io.File; import java.io.FileReader; import java.io.FileWriter; import java.io.IOException;

    public class Main {
        public static void main(String[] args) {
            String inputFileName = "input";
            String outputFileName = "output";

            File inputFile = new File(inputFileName);
            File outputFile = new File(outputFileName);

            try {
                BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

                String line;
                while ((line = reader.readLine()) != null) {
                    String encodedLine = encode(line);
                    writer.write(encodedLine);
                    writer.newLine();
                }

                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static String encode(String line) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);

                if (c >= 'a' && c <= 'z') {
                    c += 3;
                    if (c > 'z') {
                        c -= 26;
                    }
                } else if (c >= 'A' && c <= 'Z') {
                    c += 3;
                    if (c > 'Z') {
                        c -= 26;
                    }
                }

                sb.append(c);
            }

            return sb.toString();
        }
    }

