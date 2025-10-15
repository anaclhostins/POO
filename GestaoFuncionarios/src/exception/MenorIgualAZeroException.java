package exception;

public class MenorIgualAZeroException extends Exception{

    public MenorIgualAZeroException (String campo){
        super(campo + " não pode ser igual ou menor que zero");
    }
}
