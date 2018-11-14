import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class algorytmDawidMariankowski {

    public static void main(String[] args) throws FileNotFoundException {
        File data = new File("mojaTablica.txt");
        Scanner load = new Scanner(data);
        float size = load.nextFloat();
        float dataBase[][] = new float[(int) size][(int) size];

        while (load.hasNext()) {
            for (int i = 0; i < size; i++) {
                System.out.println();
                for (int j = 0; j < size; j++) {
                    dataBase[i][j] = load.nextFloat();
                    System.out.print(" " + dataBase[i][j]);
                }

            }
            System.out.println();
        }

        //algorytm
        int visited[] = new int[(int) (size + 1)];
        int lower;
        int nextLine = 0;

        //szukanie sąsiada
        for (int i = 0; i < size; i++) {


            lower = Integer.MAX_VALUE;
            for (int j = 0; j < size; j++) {
                // czy odwiedzona
                boolean isVisited = false;
                for (int o = 0; o < size; o++) {
                    if (j == visited[o]) {
                        isVisited = true;
                    }
                }
                if (!isVisited && lower > dataBase[nextLine][j]) {

                    lower = (int) dataBase[nextLine][j];
                    visited[i + 1] = j;
                } else {

                }
            }

            nextLine = visited[i+1];

        }
        System.out.println();

        System.out.println("Trasa która jest najkrótrza to: ");
            for(int k=0; k<=size; k++){
                System.out.print(" "+visited[k]+"-->");
            }
            System.out.println();
    }
}
