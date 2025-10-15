package exception;

public class CampoVazioException extends Exception{

    public CampoVazioException(String campo){
        super(campo + " não deve estar vazio");
    }

}
