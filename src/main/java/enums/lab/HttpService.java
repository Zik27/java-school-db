package enums.lab;

public class HttpService {
    public void handleHttpCode(int httpCode) {
        HttpCode.executeByHttpCode(httpCode);
    }

    public static void main(String[] args) {
        HttpService service = new HttpService();
        service.handleHttpCode(1000);
    }
}
