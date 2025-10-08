package excecao;

public class CampoVazioException extends Exception{


    private static final long serialVersionUID = 1L;

    public CampoVazioException(String campo){
        super(campo + " não deve estar vazio");
    }
}
