import java.util.ArrayList;
import java.util.List;

public class Gramatica2 {

    public static List<String> criarCadeias(int comprimento) {
        List<String> listaDeCadeias = new ArrayList<>();
        construirCadeia("", comprimento, listaDeCadeias);
        return listaDeCadeias;
    }

    private static void construirCadeia(String inicio, int comprimento, List<String> listaDeCadeias) {

        if (inicio.length() == comprimento) {
            listaDeCadeias.add(inicio);
            return;
        }

        if (inicio.isEmpty()) {

            construirCadeia(inicio + "a", comprimento, listaDeCadeias);
            construirCadeia(inicio + "b", comprimento, listaDeCadeias);
            if (comprimento == 1) {
                listaDeCadeias.add("c");
            }
        } else {

            char ultimoCaractere = inicio.charAt(inicio.length() - 1);
            if (ultimoCaractere == 'a') {
                construirCadeia(inicio + "a", comprimento, listaDeCadeias);
            } else if (ultimoCaractere == 'b') {
                construirCadeia(inicio + "b", comprimento, listaDeCadeias);
            }
        }
    }

    public static void main(String[] args) {
        int comprimento = 3;
        List<String> listaDeCadeias = criarCadeias(comprimento);

        System.out.println("Cadeias de comprimento " + comprimento + ":");
        for (String cadeia : listaDeCadeias) {
            System.out.println(cadeia);
        }
    }
}
