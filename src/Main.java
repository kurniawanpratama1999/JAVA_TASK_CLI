import controllers.TaskController;

public class Main {
    public static void main(String[] args) {

        TaskController control = new TaskController();

        String result;

        result = control.create("001", "Makan");
        result = control.create("002", "Lari");
        result = control.create("003", "Minum");
        result = control.create("004", "Mandi");
        result = control.create("005", "Tidur");

        result = control.update("001", null, "DONE");
        result = control.update("003", null, "DONE");
        result = control.update("005", null, "DONE");

        result = control.delete("002");

        System.out.println(result);

    }
}
