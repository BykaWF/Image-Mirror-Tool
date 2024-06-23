package com.yaroslavcode;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {
    private final BufferedImage bufferedImage;
    private final int height;
    private final int width;

    public int getStart() {
        return start;
    }

    public int getBound() {
        return bound;
    }

    private int start;

    public void setStart(int start) {
        this.start = start;
    }

    public void setBound(int bound) {
        this.bound = bound;
    }

    private int bound;


    public int getHeight() {
        return height;
    }


    public int getWidth() {
        return width;
    }


    public Image(Path path) throws IOException {
        this.bufferedImage = ImageIO.read(new File(path.getPath()));
        this.height = bufferedImage.getHeight();
        this.width = bufferedImage.getWidth();
    }

    public Image(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
        this.height = bufferedImage.getHeight();
        this.width = bufferedImage.getWidth();
    }
    
    public int[][] getArrayFromImage(){
        int height = bufferedImage.getHeight();
        int width = bufferedImage.getWidth();

        int[][] result = new int[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
               result[row][col] = bufferedImage.getRGB(col,row);
            }
        }

        return result;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void saveImageToFile(Path path, String format) throws IOException {
        File f = new File(Path.FLIPPED_IMG_PATH.getPath());

        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        if (!f.exists())
            f.createNewFile();

        ImageIO.write(bufferedImage, format, f);
    }
}
