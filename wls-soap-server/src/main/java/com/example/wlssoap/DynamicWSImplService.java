package com.example.wlssoap;

import javax.jws.WebService;

@WebService(
        name = "DynamicWSImpl",
        serviceName = "DynamicWSImplService"
)
public class DynamicWSImplService {
    // By default, all public methods are exposed as Web Services operation
    public String sayHelloWorld(String message) {
        return "Here is the message: '" + message + "'";
    }

    public int subtract(int x, int y) {
        return x - y;
    }
}