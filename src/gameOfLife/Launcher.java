package gameOfLife;

import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        boolean boucle = true;
        int nbGeneration = 0, nbRows = 0, nbColumns = 0;

        while(boucle){
            System.out.println("Entrez un nombre de génération :");
            nbGeneration = new Scanner(System.in).nextInt();
            if(nbGeneration > 0) {
                boucle = false;

            }
        }
        boucle = true;
        while(boucle){
            System.out.println("Entrez un nombre de lignes :");
            nbRows = new Scanner(System.in).nextInt();
            if(nbRows > 0){
                boucle = false;
            }
        }
        boucle = true;
        while(boucle){
            System.out.println("Entrez un nombre de colonnes :");
            nbColumns = new Scanner(System.in).nextInt();
            if(nbColumns > 0){
                boucle = false;
            }
        }
        World golWorld = new World(nbRows,nbColumns);
        System.out.println(golWorld);
        for(int i = 0 ; i < nbGeneration ; i++){
            golWorld.newGeneration();
            System.out.println("Génération n°" + (i+1) + "\n" + golWorld);
            System.gc();
            try{
                Thread.sleep(50);   // = 50 ms
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
