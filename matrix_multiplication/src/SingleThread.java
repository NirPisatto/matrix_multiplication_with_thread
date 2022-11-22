import java.util.ArrayList;

public class SingleThread {
    ArrayList<String> menus = new ArrayList<String>();

    public SingleThread(){
        menus.add("Create Matrix");
        menus.add("Auto Generate Matrix");
        menus.add("Multiply Matrix");
        menus.add("Multiply Matrix (Fast)");
        menus.add("Exit");
    }
    public void display(){
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i+1) + ". "+menus.get(i));
        }
    }

}
