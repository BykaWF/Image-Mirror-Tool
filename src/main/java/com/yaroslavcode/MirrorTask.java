package com.yaroslavcode;

import java.awt.image.BufferedImage;
import java.util.concurrent.Callable;

public class MirrorTask implements Callable<Image> {
    private final Image originalImg;
    private final int start;
    private final int bound;
    private final int height;
    private final int width;

    public MirrorTask(Image originalImg, int start, int bound) {
        this.originalImg = originalImg;
        this.start = start;
        this.bound = bound;
        this.height = originalImg.getBufferedImage().getHeight();
        this.width = originalImg.getBufferedImage().getWidth();
    }



    @Override
    public Image call() throws Exception {
        int[][] imgArr = originalImg.getArrayFromImage();
        BufferedImage bufferFlippedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int row = start; row < bound; row++) {
            for (int col = 0; col < width; col++) {
                bufferFlippedImg.setRGB(col, row, imgArr[row][width - 1 - col]);
            }
        }

        Image mirroredImg = new Image(bufferFlippedImg);
        mirroredImg.setStart(start);
        mirroredImg.setBound(bound);
        return mirroredImg;
    }

    private void swap(int[][] imgArr, int row, int col,int width) {
        int temp = imgArr[row][col];
        imgArr[row][col] = imgArr[row][width - 1 - col];
        imgArr[row][width - 1 - col] = temp;
    }
}
