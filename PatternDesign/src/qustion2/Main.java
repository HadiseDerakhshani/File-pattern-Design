package qustion2;

import qustion2.imageReader.ImageReader;
import qustion2.imageReader.PngImageReader;
import qustion2.imageReader.decorator.GifDecorator;
import qustion2.imageReader.decorator.JpegDecorator;

public class Main {
    public static void main(String[] args) {
        User user = new User("HADISEH", "png,jpeg,gif");
        ImageReader imageReader = new PngImageReader();
        imageReader = new JpegDecorator(imageReader);
        imageReader = new GifDecorator(imageReader);
        imageReader.showImage(user.getName());
    }
}
