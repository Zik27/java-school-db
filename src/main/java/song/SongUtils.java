package song;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class SongUtils {
    @SneakyThrows
    public static long countOfWordsInSong(String path) {
        return Files.lines(Paths.get(path))
                .flatMap(line -> Arrays.stream(line.trim().split("\\W+")))
                .count();
    }

    public static void main(String[] args) {
        System.out.println(countOfWordsInSong("src/main/resources/song.txt"));
    }
}
