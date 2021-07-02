package com.company.main.loggercomponent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Pipe {

    private static Queue<Log> queue = new LinkedList<>();
    private static Thread logWriterThread;
    private static boolean shouldBeOnLoop = true;

    public static void open() {
        logWriterThread = new Thread(new Runnable() {
            @Override
            public void run() {
                do {
                    if (!queue.isEmpty()) {
                        Log log = (Log) queue.poll();
                        try {
                            String fileName = "D:\\pipe_log_" + getFormattedTime(log.getTime(), "dd-MM-yyyy'.txt'");
                            String message = getFormattedTime(log.getTime(), "dd-MM-yyyy HH:mm:ss.SSS") + " " + log.getSeverityLevel() + " " + log.getMessage();
                            writeToFile(fileName, message);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } while (!queue.isEmpty() || shouldBeOnLoop);
            }
        });
        logWriterThread.start();
    }

    public static void print(SeverityLevel severityLevel, String message) {
        Log log = new Log(severityLevel, message, System.currentTimeMillis());
        queue.add(log);
    }

    public static void close() {
        shouldBeOnLoop = false;
    }

    private static String getFormattedTime(long timeInMillis, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        Date date = new Date(timeInMillis);
        String formattedTime = formatter.format(date);
        return formattedTime;
    }

    private static void writeToFile(String fileName, String message) throws IOException {
        File file = new File(fileName);
        if (!file.exists() && file.isFile()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write("\n" + message);
        fileWriter.close();
    }
}


