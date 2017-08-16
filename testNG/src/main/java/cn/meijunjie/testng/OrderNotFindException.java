package cn.meijunjie.testng;

public class OrderNotFindException extends Exception {
    public OrderNotFindException() {
    }

    public OrderNotFindException(String message) {
        super(message);
    }
}
