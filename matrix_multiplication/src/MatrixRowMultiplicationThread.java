import java.util.ArrayList;

public class MatrixRowMultiplicationThread extends Thread{
    private MatrixSet ans;
    private ArrayList<Integer> row_ans;
    private MatrixSet set_a;
    private MatrixSet set_b;

    private int row_index;

    public MatrixRowMultiplicationThread(MatrixSet ans, MatrixSet set_a, MatrixSet set_b, int row_index){
        this.row_ans = new ArrayList<Integer>() ;
        this.ans = ans;
        this.set_a = set_a;
        this.set_b = set_b;
        this.row_index = row_index;
    }

    private int get_sub_step(ArrayList<Integer> a, ArrayList<Integer> b){
        int re_sum = 0;
        for (int i = 0; i < a.size(); i++) {
            re_sum += a.get(i) * b.get(i);
        }
        return re_sum;
    }


    @Override
    public void run() {
        for (int j = 0; j < set_b.col; j++){
            row_ans.add(get_sub_step(set_a.get_rows(row_index),set_b.get_rows(j)));
        }
        this.ans.set.set(row_index, row_ans);
    }
}
