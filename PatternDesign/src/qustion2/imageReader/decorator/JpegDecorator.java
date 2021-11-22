package qustion2.imageReader.decorator;

import qustion2.imageReader.ImageReader;
import qustion2.imageReader.JpegImageReader;

public class JpegDecorator extends ImageReaderBaseDecorator {
    private JpegImageReader jpegImageReader=new JpegImageReader();
    public JpegDecorator(ImageReader imageReader) {
        super(imageReader);
    }

    @Override
    public void showImage(String name) {
        super.showImage(name);
        jpegImageReader.showImage(name);
    }
}
