public class Gramatica1 {

    public static boolean verificaCadeia(String sequencia) {
        if (sequencia == null || sequencia.isEmpty()) {
            return false;
        }

        char inicial = sequencia.charAt(0);


        if (inicial == 'a') {
            for (char simbolo : sequencia.toCharArray()) {
                if (simbolo != 'a') {
                    return false;
                }
            }
            return true;
        }


        if (inicial == 'b') {
            for (char simbolo : sequencia.toCharArray()) {
                if (simbolo != 'b') {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(verificaCadeia("aaa"));
        System.out.println(verificaCadeia("bbb"));
        System.out.println(verificaCadeia("aab"));
        System.out.println(verificaCadeia("bba"));
        System.out.println(verificaCadeia(""));
    }
}
