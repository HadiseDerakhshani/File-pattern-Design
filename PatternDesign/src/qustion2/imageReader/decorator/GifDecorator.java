package qustion2.imageReader.decorator;

import qustion2.imageReader.GifImageReader;
import qustion2.imageReader.ImageReader;

public class GifDecorator extends ImageReaderBaseDecorator {
    private GifImageReader gifImageReader = new GifImageReader();

    public GifDecorator(ImageReader imageReader) {
        super(imageReader);
    }

    @Override
    public void showImage(String name) {
        super.showImage(name);
        gifImageReader.showImage(name);
    }
}
