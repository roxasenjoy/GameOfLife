package gameOfLife;

import javax.swing.*;
import java.util.StringTokenizer;

public class World{
    private Cell[][] cellTab;

    public World(){
        //TODO Auto-generated constructor stub
    }

    public World(Cell[][] cellTab){

    }

    public World(int nbRows, int nbColumns){
        cellTab = new Cell[nbRows][nbColumns];
        for(int i = 0 ; i < nbRows ; i++){
            for(int j = 0 ; j < nbColumns ; j++){
                if(Math.random() > 0.93){
                    cellTab[i][j] = new AliveCell();
                }
                else {
                    cellTab[i][j] = new DeadCell();
                }
            }
        }
    }
    public void newGeneration() {
        for(int i = 0 ; i < cellTab.length ; i++){
            for(int j=0 ; j < cellTab[i].length ; j++){
                int nbNeighbours = 0;
                // Si la cellule n'est pas située sur la première ligne
                if(i > 0){
                    nbNeighbours += (cellTab[i-1][j].isAlive() ? 1 : 0);
                    // Et si la cellule n'est pas située sur la première colonne
                    if(j > 0){
                        nbNeighbours += (cellTab[i-1][j-1].isAlive() ? 1 : 0);
                    }
                    // Et si la cellule n'est pas située sur la dernière colonne
                    if(j < cellTab[i].length -1){
                        nbNeighbours += (cellTab[i-1][j+1].isAlive() ? 1 : 0);
                    }
                }
                // Si la cellule n'est pas située sur la dernière ligne
                if (i < cellTab.length -1){
                    nbNeighbours += (cellTab[i+1][j].isAlive() ? 1 : 0 );
                    // Et si la cellule n'est pas située sur la première colonne
                    if(j > 0){
                        nbNeighbours += (cellTab[i+1][j-1].isAlive() ? 1 : 0);
                    }
                    // Et si la cellule n'est pas située sur la dernière colonne
                    if(j < cellTab[i].length -1){
                        nbNeighbours += (cellTab[i+1][j+1].isAlive() ? 1 : 0);
                    }
                    }
                //Si la cellule n'est pas située sur la première colonne
                if(j > 0) {
                    nbNeighbours += (cellTab[i][j - 1].isAlive() ? 1 : 0);
                }
                //Si la cellule n'est pas située sur la dernière colonne
                if(j < cellTab[i].length -1){
                    nbNeighbours += (cellTab[i][j+1].isAlive() ? 1 : 0);
                }
                cellTab[i][j] = cellTab[i][j].newGeneration(nbNeighbours); 
                }
        }
    }
    @Override
    public String toString(){
        String result  = "";
        for (int i = 0; i < cellTab.length; i++){
            for(int j = 0; j < cellTab[i].length; j++){
                result += cellTab[i][j].getAsString();
            }
            result += "\n";
        }
        return result;
    }
}
