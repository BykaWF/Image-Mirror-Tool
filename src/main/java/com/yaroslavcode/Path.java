package com.yaroslavcode;

public enum Path {
    SOURCE_PATH("./resources/image/Landscape-Color.jpg"),
    FLIPPED_IMG_PATH("./resources/output/Landscape-Color-Flipped.jpg");

    private String SOURCE_FILE;
    Path(String source) {
        this.SOURCE_FILE = source;
    }

    public String getPath() {
        return SOURCE_FILE;
    }

    public void setPath(String SOURCE_FILE) {
        this.SOURCE_FILE = SOURCE_FILE;
    }

}
