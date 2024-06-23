# Image Mirror Tool

This Java application mirrors an image horizontally using multithreading. It divides the image processing across multiple threads to improve performance.

## Features

- **Multithreaded Image Processing**: Utilizes multiple threads to mirror an image horizontally.
- **Image IO**: Reads and writes images using `javax.imageio`.
- **Parallel Execution**: Divides image processing into sections to run concurrently.

## Components

### Main.java

Entry point of the application. It coordinates the multithreaded image mirroring process.

### Image.java

Represents an image file and provides methods for reading from and writing to the file system. Also provides methods for converting between `BufferedImage` and integer arrays representing RGB values.

### MirrorTask.java

Implements `java.util.concurrent.Callable`. Represents a task that mirrors a section of an image horizontally.

### Example of mirroring 

![Original Image](resources/image/leaf-original.jpg)

![Flipped Image](resources/output/leaf-flipped.jpg)


## Usage

1. **Clone the repository**:

   ```bash
   git clone https://github.com/your-username/ImageMirrorTool.git

2. **To add an image need to provide your ``SOURCE_PATH`` in the enum ``Path``, do not forget to provide ``MIRRORED_IMG_PATH``**
