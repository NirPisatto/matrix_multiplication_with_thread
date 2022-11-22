import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import com.opencsv.CSVWriter;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class Main {

    public static void writeDataLineByLine(String filePath, int max_row)
    {
        File file = new File(filePath);
        int system_cpus = Runtime.getRuntime().availableProcessors();
        String system_ram = Runtime.getRuntime().maxMemory()/1000000 + " MB";

        try {
            FileWriter outputfile = new FileWriter(file);


            CSVWriter writer = new CSVWriter(outputfile);

            String[] header = { "system environment", "test condition", "cores (active)","setting up duration (milliseconds)","multiplication execution duration (milliseconds)"};
            writer.writeNext(header);

            int row = 10000;
            System.out.println("TEST "+ row + " x " + row + " [running...]");
            Matrix matrix = new Matrix();
            long startTime = System.nanoTime();
            matrix.dev_auto_create_matrix(row);
            long endTime = System.nanoTime();
            long setup_duration = (endTime - startTime);

            startTime = System.nanoTime();
            matrix.multiple_threads();
            endTime = System.nanoTime();
            long cal_duration = (endTime - startTime);

            String[] sub_task_data = {system_cpus+" cores "+system_ram , row +" x "+ row ,
                    Integer.toString(system_cpus-1),Long.toString(setup_duration/1000000),
                    Long.toString(cal_duration/1000000)
            };
            writer.writeNext(sub_task_data);
            System.out.println("TEST "+ row + " x " + row + " [done] in " + cal_duration/1000000);


            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


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
                    System.out.println("Running...");
                    long startTime = System.nanoTime();
                    MatrixSet ans = matrix.multiple();
                    long endTime = System.nanoTime();
                    long setup_duration =  (endTime - startTime);
                    ans.view_display();

                    System.out.println("Time " + ans.col + " x " + ans.row +" : "+ (float) (setup_duration/1000000000)  + "s");
                }else{
                    System.out.println("Invalid sets.");

                }
            } else if (user_selected_menu == 4) {
                if (matrix.sets_validation_valid()) {

                    System.out.println("Running...");
                    long startTime = System.nanoTime();
                    MatrixSet ans = matrix.multiple_threads();
                    long endTime = System.nanoTime();
                    long setup_duration = (endTime - startTime);
                    ans.view_display();
                    System.out.println("Time " + ans.col + " x " + ans.row +" : "+ (float) (setup_duration/1000000000)+ "s");

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