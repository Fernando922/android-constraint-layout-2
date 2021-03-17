package br.com.dipaulamobilesolutions.utils;

public class DiasUtil {

    public static final String DIAS_NO_PLURAL = " dias";
    public static final String DIA_NO_SINGULAR = " dia";

    public static String formataEmTexto(int quantidadeDeDias) {
        if (quantidadeDeDias > 1) {
            return quantidadeDeDias + DIAS_NO_PLURAL;
        }
        return quantidadeDeDias + DIA_NO_SINGULAR;
    }
}
