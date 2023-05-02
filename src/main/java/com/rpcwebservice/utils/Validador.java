package com.rpcwebservice.utils;

public class Validador {

    public static String validarCuit(String cuit) {
        //Metodo utilizado para validar la longitud y formato del cuit
        String cuitFormateado;
        cuitFormateado = borrarGuiones(cuit);
        cuitFormateado = borrarEspacios(cuitFormateado);
        cuitFormateado = cuitFormateado.trim();
        if (cuitFormateado.length() != 11) {
            cuitFormateado = "";
        }
        return cuitFormateado;
    }

    private static String borrarEspacios(String palabra) {
        return palabra.replaceAll(" +", "");
    }

    private static String borrarGuiones(String palabra) {
        return palabra.replaceAll("-+", "");
    }
}
