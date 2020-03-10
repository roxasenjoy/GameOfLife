package gameOfLife;

public class AliveCell implements Cell {

    private boolean born = true;

    @Override
    public Cell newGeneration(int nbNeighbours) {
        if(nbNeighbours > 3 || nbNeighbours < 2){
            return new DeadCell();
        }
        else{
            born = false;
            return this;
        }
    }

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public String getAsString() {
        if(born){
            return "O";
        }
        return "+";
    }
}
