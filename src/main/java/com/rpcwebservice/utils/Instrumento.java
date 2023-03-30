package com.rpcwebservice.utils;

import jakarta.persistence.Convert;


@Convert
public enum Instrumento {

        PRIVADO("Privado"), PUBLICO("Publico"), NC("NC");

        private String code;

        private Instrumento(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
}
