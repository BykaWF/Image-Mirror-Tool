package com.yaroslavcode;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.yaroslavcode.Path.FLIPPED_IMG_PATH;
import static com.yaroslavcode.Path.SOURCE_PATH;

public class Main {
    private static int nThread = Runtime.getRuntime().availableProcessors();
    public static void main(String[] args) throws IOException {

        Image image = new Image(SOURCE_PATH);


        try(ExecutorService service = Executors.newFixedThreadPool(nThread)) {
            List<FlipperTask> callableList = new ArrayList<>();
            List<Future<Image>> futuresImg = new ArrayList<>();

            int totalHeight = image.getHeight();
            int sectionHeight = totalHeight / nThread;

            for (int i = 0; i < nThread; i++) {
                int start = i * sectionHeight;
                int end = (i == nThread - 1) ? totalHeight : start + sectionHeight;
                callableList.add(new FlipperTask(image, start, end));
            }

            for (FlipperTask flipperTask : callableList){
                Future<Image> imageFuture = service.submit(flipperTask);
                futuresImg.add(imageFuture);
            }

            BufferedImage finalImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

            for(Future<Image> future : futuresImg){
                Image flippedPart = future.get();
                BufferedImage partBufferedImg = flippedPart.getBufferedImage();

                int startY = flippedPart.getStart();
                int endY  = flippedPart.getBound();

                for(int row = startY; row < endY; row++){
                    for(int col = 0; col < image.getWidth(); col++){
                        finalImage.setRGB(col,row,partBufferedImg.getRGB(col,row));
                    }
                }
            }

            Image outputImg = new Image(finalImage);

            outputImg.saveImageToFile(FLIPPED_IMG_PATH,"jpg");


        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
