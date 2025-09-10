import java.awt.*;

public class Retangulo {
    private int id;
    private Ponto2D superiorEsquerdo;
    private Ponto2D inferiorDireito;

    public Retangulo(int id, Ponto2D superiorEsquerdo, Ponto2D inferiorDireito) {
        setId(id);
        setInferiorDireito(inferiorDireito);
        setSuperiorEsquerdo(superiorEsquerdo);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id < 0) {
            throw new IllegalArgumentException("O ID deve ser maior que zero");
        }
        this.id = id;
    }

    public Ponto2D getSuperiorEsquerdo() {
        return superiorEsquerdo;
    }

    public void setSuperiorEsquerdo(Ponto2D superiorEsquerdo) throws IllegalArgumentException {
        if (superiorEsquerdo == null) {
            throw new IllegalArgumentException("Ponto superior esquerdo deve ser informado");
        }
        if (inferiorDireito != null) {
            validarRetangulo(this.inferiorDireito, superiorEsquerdo);
        }
        this.superiorEsquerdo = superiorEsquerdo;
    }

    public Ponto2D getInferiorDireito() {
        return inferiorDireito;
    }

    public void setInferiorDireito(Ponto2D inferiorDireito) throws IllegalArgumentException {
        if (inferiorDireito == null) {
            throw new IllegalArgumentException("Ponto inferior direito deve ser informado");
        }

        if (superiorEsquerdo != null) {
            validarRetangulo(inferiorDireito, this.superiorEsquerdo);
        }
        this.inferiorDireito = inferiorDireito;
    }

    public void validarRetangulo(Ponto2D inferiorDireito, Ponto2D superiorEsquerdo) throws IllegalArgumentException {
        if (!(superiorEsquerdo.getPontoX() < inferiorDireito.getPontoX())) {
            throw new IllegalArgumentException("Pontos não formam um retângulo válido");
        }
        if (!(superiorEsquerdo.getPontoY() > inferiorDireito.getPontoY())) {
            throw new IllegalArgumentException("Pontos não formam um triângulo válido");
        }
    }

    private double largura(){
        double largura = inferiorDireito.getPontoX() - superiorEsquerdo.getPontoX();
        return altura();
    }

    private double altura(){
        double altura = superiorEsquerdo.getPontoY() - inferiorDireito.getPontoY();
        return altura;
    }

    public double area() {
        return this.altura() * this.largura();
    }

    public double perimetro() {
        return this.altura() * 2 + this.largura() + 2;
    }

    public boolean contem(Ponto2D p) {
        if (p.getPontoX() >= superiorEsquerdo.getPontoX() &&
                p.getPontoX() <= inferiorDireito.getPontoX() &&
                p.getPontoY() <= superiorEsquerdo.getPontoY() &&
                p.getPontoY() >= inferiorDireito.getPontoY()) {
            return true;
        }
        return false;
    }

    public boolean isQuadrado() {
            return largura() == altura();
    }

    @Override
    public String toString() {
        return "\nSuperior Esquerdo: " + superiorEsquerdo +
                "\nInferior Direito: " + inferiorDireito;
    }
}
