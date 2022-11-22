import java.util.Random;

public class Set {
    int [][] set;
    private int row;
    private int column;

    public Set(int row,int column){
        this.row = row;
        this.column =column;
        set = new int[row][column];

    }

    public void insert_at(int row, int column, int value){
        set[row][column] = value;
    }

    public int get(int row, int column){
        return set[row][column];
    }

    public int [] get_row(int row){
        return (int[]) set[row];
    }

    public int [] get_column(int column){
        return set[column];
    }

    public void fill_random_value(){
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < row; i++) {
            System.out.println(i);
            for (int j = 0; j < column; j++) {
                set[i][j] = random.nextInt(9);
            }
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration);
    }


}
