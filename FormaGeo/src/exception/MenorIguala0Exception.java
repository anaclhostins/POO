package exception;

public class MenorIguala0Exception extends Exception {
    public MenorIguala0Exception(String message) {
        super(message + " deve ser maior que 0");
    }
}
