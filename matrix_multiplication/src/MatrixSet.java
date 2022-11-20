import java.util.ArrayList;
import java.util.Random;

public class MatrixSet extends Thread {
    Matrix main;
    public int row;
    public int col;

    public int name = 0;
    public ArrayList<ArrayList<Integer>> set;

    public ArrayList<Integer> get_rows(int row_index){
        return set.get(row_index);
    }

    public ArrayList<Integer> get_cols(int col_index){
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i < row; i++) {
            temp.add(get_rows(i).get(col_index));
        }
        return temp;
    }
    public MatrixSet(){
        this.col = 0;
        this.row = 0;
        set = new ArrayList<>();
    }

    public MatrixSet(Matrix main){
        main = main;
        this.col = 0;
        this.row = 0;
        set = new ArrayList<>();
    }

    public void view_display(){
        System.out.println("\nSet ("+row+" x "+col+")");
        for (int i = 0; i < row; i++) {
            System.out.println(set.get(i));
        }
    }

    public void auto_fill(int max_range){
        set.clear();
        Random rand = new Random();
        for (int i = 0; i < row; i++) {
            ArrayList<Integer> temp_rows = new ArrayList<Integer>();
            for (int j = 0; j < col; j++) {
                temp_rows.add(rand.nextInt(max_range));
            }
            set.add(temp_rows);
        }
    }

    @Override
    public void run() {
        auto_fill(9);
    }
}
