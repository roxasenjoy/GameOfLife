package gameOfLife;

public interface Cell {
    public Cell newGeneration(int nbNeighbours);
    public boolean isAlive();
    public String getAsString();
}
