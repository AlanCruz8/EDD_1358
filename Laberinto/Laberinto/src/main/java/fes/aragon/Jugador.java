package fes.aragon;

public class Jugador {

    private ADTStack<String> camino;
    private int coorX, coorY;
    
    public Jugador(int x, int y) {
        this.camino = new ADTStack();
        this.mover(x, y);
    }

    public void mover(int x, int y) {
        this.setCoorX(x);
        this.setCoorY(y);
        String coordenadas = "" + x + "," + y;
        this.camino.push(coordenadas);
    }

    public void regresar() {
        this.camino.pop();
        String coor = this.camino.peek();
        String tmp[] = coor.split(",");
        this.setCoorX(Integer.parseInt(tmp[0]));
        this.setCoorY(Integer.parseInt(tmp[1]));
    }

    public String getCamino() {
        return this.camino.getPila().toString();
    }

    public String posicionActual() {
        return this.camino.peek();
    }

    public int getCoorX() {
        return this.coorX;
    }

    public void setCoorX(int x) {
        this.coorX = x;
    }

    public void setCoorY(int y) {
        this.coorY = y;
    }

    public int getCoorY() {
        return this.coorY;
    }

}
