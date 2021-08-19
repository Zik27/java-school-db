package enums.lab;

import enums.lab.handlers.*;

import java.util.Arrays;

public enum HttpCode {
    Redirection(300, 399, new RedirectionHandler()),
    ClientError(400, 499, new ClientErrorHandler()),
    ServerError(500, 599, new ServerErrorHandler());

    private final int minCode;
    private final int maxCode;
    private final HandlerByHttpCodes handler;

    HttpCode(int minCode, int maxCode, HandlerByHttpCodes handler) {
        this.minCode = minCode;
        this.maxCode = maxCode;
        this.handler = handler;
    }

    public static void executeByHttpCode(int code) {
        HttpCode httpCode = Arrays.stream(values())
                .filter(http -> http.minCode <= code && http.maxCode >= code)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Unsupported code: %s.", code)));
        httpCode.handler.execute();
    }
}
