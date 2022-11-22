import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Matrix {

    public MatrixSet set_a;
    public MatrixSet set_b;


    public void dev_auto_create_matrix(int row){
        set_a = new MatrixSet(this);
        set_a.row = row;
        set_a.col = row;

        set_b = new MatrixSet(this);
        set_b.row = row;
        set_b.col = row;

        ExecutorService executor = Executors.newFixedThreadPool(2);
        ArrayList<Future<?>> futures = new ArrayList<>();

        Future<?> f_set_a = executor.submit(set_a);
        futures.add(f_set_a);

        Future<?> f_set_b = executor.submit(set_b);
        futures.add(f_set_b);

        for (Future<?>of : futures) {
            try {
                of.get();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            } catch (ExecutionException ex) {
                throw new RuntimeException(ex);
            }
        }

        executor.shutdown();

    }

    public void auto_create_matrix(){
        Scanner user_input = new Scanner(System.in);
        System.out.print("Set size row and col: ");
        int row =  user_input.nextInt();
        dev_auto_create_matrix(row);
    }

    public MatrixSet multiple(){
        if (!sets_validation_valid()) return null;
        MatrixSet ans = new MatrixSet();
        ans.row = set_a.row;
        ans.col = set_b.col;

        for (int i = 0; i < set_a.row; i++) {
            ArrayList<Integer> temp_col_ans = new ArrayList<Integer>() ;
            for (int j = 0; j < set_b.col; j++){
                temp_col_ans.add(get_sub_step(set_a.get_rows(i),set_b.get_cols(j)));
            }
            ans.set.add(temp_col_ans);
        }
        return ans;
    }



    public MatrixSet multiple_threads(){
        if (!sets_validation_valid()) return null;
        MatrixSet ans = new MatrixSet();
        ans.row = set_a.row;
        ans.col = set_b.col;
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores - 1);
        ArrayList<Future<?>> futures = new ArrayList<>();

        for (int i = 0; i < set_a.row; i++) {
            ans.set.add(new ArrayList<>());
            Future<?> get_row_task = executor.submit(new MatrixRowMultiplicationThread(ans, set_a, set_b, i));
            futures.add(get_row_task);
        }


        for (Future<?>sub_task_reso : futures) {
            try {
                sub_task_reso.get();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            } catch (ExecutionException ex) {
                throw new RuntimeException(ex);
            }
        }

        executor.shutdown();

        return ans;
    }

    private int get_sub_step(ArrayList<Integer> a, ArrayList<Integer> b){
        int re_sum = 0;
        for (int i = 0; i < a.size(); i++) {
            re_sum += a.get(i) * b.get(i);
        }
        return re_sum;
    }

    public boolean sets_validation_valid(){
        if (set_a == null || set_b == null) return false;
        if (set_a.col != set_b.row) return false;
        return true;
    }

    public MatrixSet input_single_set_from_user(){
        Scanner user_input = new Scanner(System.in);
        MatrixSet set = new MatrixSet();
        System.out.print("Row: ");
        set.row = user_input.nextInt();
        System.out.print("Col: ");
        set.col = user_input.nextInt();
        user_input.nextLine();
        for (int i = 0; i < set.row; i++) {
            System.out.print("Row "+ (i+1) +": ");
            String temp_row = user_input.nextLine();
            String[] str_rows = temp_row.split(" ");
            ArrayList<Integer> int_rows = new ArrayList<Integer>();
            for (int j = 0; j < set.col; j++) {
                try{
                    int_rows.add(Integer.parseInt(str_rows[j]));
                }catch (Exception e){
                    int_rows.add(0);
                }
            }
            System.out.println("+ "+int_rows);
            set.set.add(int_rows);
        }
        return set;
    }

    public void create_matrix(){
        System.out.println("Input set A");
        set_a = input_single_set_from_user();
        set_a.view_display();
        System.out.println("Input set A");
        set_b = input_single_set_from_user();
        set_b.view_display();
    }

}
