package cn.meijunjie.web.execption;


public class ImageUploadException extends RuntimeException {

    public ImageUploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public ImageUploadException(String message) {
        super(message);
    }
}
