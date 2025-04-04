package Cadastramento;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class UtilsRemoverAcento {
    public static String removerAcentos(String str) {
        String normalizado = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern padrao = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return padrao.matcher(normalizado).replaceAll("").toLowerCase().trim();
    }
}
