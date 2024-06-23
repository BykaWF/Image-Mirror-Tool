package com.yaroslavcode;

public enum Path {
    SOURCE_PATH("./resources/image/leaf-original.jpg"),
    MIRRORED_IMG_PATH("./resources/output/leaf-flipped.jpg");

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
