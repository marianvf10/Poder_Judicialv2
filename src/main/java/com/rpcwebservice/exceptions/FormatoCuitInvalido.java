package com.rpcwebservice.exceptions;

import java.io.Serial;

public class FormatoCuitInvalido extends  RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public FormatoCuitInvalido(String msg) {
        super(msg);
    }
}

