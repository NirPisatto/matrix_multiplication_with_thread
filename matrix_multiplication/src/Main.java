import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        single();


    }
    private static void single(){
        Matrix matrix = new Matrix();
        SingleThread app = new SingleThread();

        Scanner user_input = new Scanner(System.in);
        int user_selected_menu = 0;

        while (app != null){
            app.display();
            user_selected_menu = user_input.nextInt();

            if (user_selected_menu == 1){
                matrix.create_matrix();

            }else if (user_selected_menu == 2){
                matrix.auto_create_matrix();

            } else if (user_selected_menu == 3) {
                if (matrix.sets_validation_valid()) {
//                    matrix.set_a.view_display();
//                    matrix.set_b.view_display();
                    MatrixSet ans = matrix.multiple();
//                    ans.view_display();

                }else{
                    System.out.println("Invalid sets.");

                }
            }else {
                app = null;
                matrix = null;
                System.gc();

            }
        }
    }
}