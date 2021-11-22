package qustion2.imageReader;

public class PngImageReader implements ImageReader {
    @Override
    public void showImage(String name) {
        System.out.println(name + " The format of your image is -Png- ");
    }
}
