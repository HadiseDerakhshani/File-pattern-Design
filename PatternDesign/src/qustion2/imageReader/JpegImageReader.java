package qustion2.imageReader;

public class JpegImageReader implements ImageReader {
    @Override
    public void showImage(String name) {
        System.out.println( name +" The format of your image is -Jpeg- " );

    }
}
