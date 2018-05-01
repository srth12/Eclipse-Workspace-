package com.hackerrank.code.loggingservice;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * Reads log file parallely 
 */
public class ReadFilesParallely {

    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {

        readFiles("/Users/srth12/eclipse-workspace/Coding Practice/codingpractice/src/main/java/com/hackerrank/code/loggingservice/resources");
    }

    public static void readFiles(String directory){

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        List<String> fileNames = new ArrayList<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory))) {
            for (Path path : directoryStream) {
                fileNames.add(path.toString());
            }
        } catch (IOException ex) {
            System.out.println("failed to ");
            ex.printStackTrace();
        }

        List<CompletableFuture<Optional<List<LogFileDao>>>> results = fileNames.stream().map((String x) -> {
            CompletableFuture<Optional<List<LogFileDao>>> result =
                    CompletableFuture.supplyAsync(() -> {
                        try {
                            return Optional.of(readLogs(Paths.get(x)));
                        } catch (IOException e) {
                            e.printStackTrace();
                            return Optional.empty();
                        }
                    }, executorService);
            return result;
        }).collect(Collectors.toList());

        results.stream().forEach(x -> x.join());
        System.out.println(results);
    }

    public static List<LogFileDao> readLogs(Path path) throws IOException {

        return Files.readAllLines(path).stream().map(line ->{
            String[] words = line.split(" ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
            return new LogFileDao(Long.parseLong(words[0]),Long.parseLong(words[1]), words[2]);
        }).collect(Collectors.toList());
    }
}
