package exercise;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String file1, String file2, String resultFile) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(Paths.get(file1).toAbsolutePath().normalize());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(Paths.get(file2).toAbsolutePath().normalize());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<String> future = future1.thenCombine(future2, (f1, f2) -> {
            try {
                Files.writeString(Paths.get(resultFile).toAbsolutePath().normalize(), f1 + f2, StandardOpenOption.CREATE);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return "Done";
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return "Error";
        });
        return future;
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        App.unionFiles("src/main/resources/file1.txt",
                "src/main/resources/file2.txt", "src/main/resources/file3.txt");
        // END
    }
}

