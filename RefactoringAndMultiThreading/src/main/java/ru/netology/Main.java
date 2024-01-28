package ru.netology;

/*import java.io.*;
import java.net.ServerSocket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;*/

public class Main {
    public static int numberOfThreads = 64;
    protected static final int PORT = 9999;

    public static void main(String[] args) {
    final var server = new Server(PORT, numberOfThreads);
    server.addHandler("GET", "/messages", ((request, responseStream) ->
            server.responseWithoutContent(responseStream, "404", "Not found!")));
    server.addHandler("POST", "/messages", ((request, responseStream) ->
            server.responseWithoutContent(responseStream, "503", "Service unavailable")));
    server.addHandler("GET", "/", ((request, responseStream) ->
            server.defaultHandler(responseStream, "spring.svg")));
    server.start();

    }
}
