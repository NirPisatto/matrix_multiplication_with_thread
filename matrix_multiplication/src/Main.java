import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        int row = 1000;

        if (args.length > 0){
            row = Integer.parseInt(args[0]);
        }

        Matrix matrix = new Matrix();
        long startTime = System.nanoTime();
        matrix.dev_auto_create_matrix(row);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration/1000000);


//        startTime = System.nanoTime();
//        matrix.multiple();
//        endTime = System.nanoTime();
//        duration = (endTime - startTime);
//        System.out.println(duration/1000000);



        startTime = System.nanoTime();
        matrix.multiple_threads();
        endTime = System.nanoTime();
        duration = (endTime - startTime);

        System.out.println("Matrix [" + row +" X " + row + "] in "+Runtime.getRuntime().availableProcessors() + " cores - TIME = " +duration/1000000);
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
                    long startTime = System.nanoTime();
                    MatrixSet ans = matrix.multiple();
//                    long endTime = System.nanoTime();
//                    long duration = (endTime - startTime);
//                    System.out.println(duration/1000000);

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