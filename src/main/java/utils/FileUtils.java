
package utils;

import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileUtils {

    private static final Logger LOGGER = LogManager.getLogger(FileUtils.class.getName());

    public List<Integer> readIntLines(String fileName) {
        List<Integer> intLines = new ArrayList<>();

        try (Stream<String> lines = readLines(fileName)) {
            lines.forEach(line -> intLines.add(Integer.parseInt(line)));
        }

        return intLines;
    }

    private Stream<String> readLines(String fileName) {
        try {
            URL systemResource = ClassLoader.getSystemResource(fileName);
            URI uri = systemResource.toURI();
            Path path = Paths.get(uri);

            return Files.lines(path);
        } catch (Exception ex) {
            LOGGER.error("Error reading the file: " + ex.getMessage());
            System.exit(1);
        }

        return null;
    }

    public List<String> readStringLines(String fileName) {
        try (Stream<String> lines = readLines(fileName)) {
            return lines.collect(Collectors.toList());
        }
    }
}
