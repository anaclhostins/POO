import java.awt.*;

public class Retangulo {
    private Ponto2D superiorEsquerdo;
    private Ponto2D inferiorDireito;

    public Retangulo(Ponto2D superiorEsquerdo, Ponto2D inferiorDireito) {
        //validarRetangulo(superiorEsquerdo, inferiorDireito);
        setInferiorDireito(inferiorDireito);
        setSuperiorEsquerdo(superiorEsquerdo);
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
        if (superiorEsquerdo.getPontoX() < inferiorDireito.getPontoX()) {
            throw new IllegalArgumentException("Pontos não formam um retângulo válido");
        }
        if (superiorEsquerdo.getPontoY() > inferiorDireito.getPontoY()) {
            throw new IllegalArgumentException("Pontos não formam um triângulo válido");
        }
    }

    public double area() {
        double altura = superiorEsquerdo.getPontoY() - inferiorDireito.getPontoY();
        double largura = inferiorDireito.getPontoX() - superiorEsquerdo.getPontoX();
        return altura * largura;
    }

    public double perimetro() {
        double altura = superiorEsquerdo.getPontoY() - inferiorDireito.getPontoY();
        double largura = inferiorDireito.getPontoX() - superiorEsquerdo.getPontoX();
        return altura * 2 + largura + 2;
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
        double altura = superiorEsquerdo.getPontoY() - inferiorDireito.getPontoY();
        double largura = inferiorDireito.getPontoX() - superiorEsquerdo.getPontoX();
        if (largura == altura) {
            return true;
        }
            return false;
    }

    @Override
    public String toString() {
        return "Retangulo: " +
                "\nSuperior Esquerdo: " + superiorEsquerdo +
                "\nInferior Direito: " + inferiorDireito;
    }
}

