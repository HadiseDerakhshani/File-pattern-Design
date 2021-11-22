package qustion2.imageReader.decorator;

import qustion2.imageReader.ImageReader;

public class ImageReaderBaseDecorator implements ImageReader {
    private ImageReader imageReader;

    public ImageReaderBaseDecorator(ImageReader imageReader) {
        this.imageReader = imageReader;
    }

    @Override
    public void showImage(String name) {
        imageReader.showImage(name);
    }
}
