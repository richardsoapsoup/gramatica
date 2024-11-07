import java.util.*;

class Gramatica3 {
    public String simbolo;
    public List<String> regrasDeProducao;

    public Gramatica3(String simbolo) {
        this.simbolo = simbolo;
        this.regrasDeProducao = new ArrayList<>();
    }

    public void adicionarRegra(String regra) {
        regrasDeProducao.add(regra);
    }
}

class EstruturaGramatica {
    public String simboloInicial;
    public Map<String, Gramatica3> producoes;

    public EstruturaGramatica(String simboloInicial) {
        this.simboloInicial = simboloInicial;
        this.producoes = new HashMap<>();
    }

    public void adicionarProducao(String simbolo, String regra) {
        producoes.putIfAbsent(simbolo, new Gramatica3(simbolo));
        producoes.get(simbolo).adicionarRegra(regra);
    }
}

class AnalisadorGramatica {

    public static boolean pertenceALinguagem(EstruturaGramatica gramatica, String cadeia) {
        return verificaPertinencia(gramatica, gramatica.simboloInicial, cadeia);
    }

    private static boolean verificaPertinencia(EstruturaGramatica gramatica, String simboloAtual, String cadeia) {

        if (cadeia.isEmpty()) {
            for (String regra : gramatica.producoes.getOrDefault(simboloAtual, new Gramatica3("")).regrasDeProducao) {
                if (regra.equals("ε")) {
                    return true;
                }
            }
            return false;
        }

        Gramatica3 producaoAtual = gramatica.producoes.get(simboloAtual);
        if (producaoAtual == null) {
            return false;
        }

        for (String regra : producaoAtual.regrasDeProducao) {
            if (regra.isEmpty()) continue;

            if (Character.isLowerCase(regra.charAt(0))) {
                char terminal = regra.charAt(0);
                if (!cadeia.isEmpty() && cadeia.charAt(0) == terminal) {
                    if (verificaPertinencia(gramatica, regra.substring(1), cadeia.substring(1))) {
                        return true;
                    }
                }
            } else {
                if (verificaPertinencia(gramatica, regra, cadeia)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        EstruturaGramatica gramatica = new EstruturaGramatica("S");
        gramatica.adicionarProducao("S", "aA");
        gramatica.adicionarProducao("S", "bB");
        gramatica.adicionarProducao("A", "aA");
        gramatica.adicionarProducao("A", "ε");
        gramatica.adicionarProducao("B", "bB");
        gramatica.adicionarProducao("B", "ε");

        System.out.println(pertenceALinguagem(gramatica, "aaa"));
        System.out.println(pertenceALinguagem(gramatica, "bbb"));
        System.out.println(pertenceALinguagem(gramatica, "aab"));
        System.out.println(pertenceALinguagem(gramatica, "bba"));
    }
}
