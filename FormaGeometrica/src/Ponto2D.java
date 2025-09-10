public class Ponto2D {
    private double pontoX;
    private double pontoY;

    public Ponto2D(double pontoX, double pontoY){
        setPontoX(pontoX);
        setPontoY(pontoY);
    }

    public double getPontoX() {
        return pontoX;
    }

    public void setPontoX(double pontoX) {
        this.pontoX = pontoX;
    }

    public double getPontoY() {
        return pontoY;
    }

    public void setPontoY(double pontoY) {
        this.pontoY = pontoY;
    }

    @Override
    public String toString() {
        return "\nX= " + pontoX +
                " e Y=" + pontoY;
    }
}
