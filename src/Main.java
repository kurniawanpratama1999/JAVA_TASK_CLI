import controllers.TaskController;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        TaskController controller = new TaskController();

        String[] options = {"create", "find", "list", "list by status", "update description", "update status", "delete"};
        StringJoiner joiner = new StringJoiner(" / ", "| ", " |");
        for (String option : options) {
            joiner.add(option);
        }

        try {

            while(true) {
                System.out.println("PILIHAN: " + joiner);
                System.out.print("KETIK PILIHAN: ");
                String input = in.nextLine();

                if (input.equalsIgnoreCase("~exit")) break;

                switch (input.toLowerCase()) {
                    case "create" -> {
                        System.out.print("ENTER ID: ");
                        String id = in.nextLine();
                        System.out.print("ENTER DESCRIPTION: ");
                        String description = in.nextLine();

                        String result = controller.create(id, description);
                        System.out.println(result);
                    }

                    case "find" -> {
                        System.out.print("ENTER ID: ");
                        String id = in.nextLine();

                        String result = controller.find(id);
                        System.out.println(result);
                    }

                    case "get list" -> {
                        String result = controller.list();
                        System.out.println(result);
                    }

                    case "list by status" -> {
                        System.out.print("ENTER STATUS: ");
                        String status = in.nextLine();

                        String result = controller.listByStatus(status.toLowerCase());
                        System.out.println(result);
                    }

                    case "update description" -> {
                        System.out.print("ENTER ID: ");
                        String id = in.nextLine();
                        System.out.print("ENTER NEW DESCRIPTION: ");
                        String description = in.nextLine();

                        String result = controller.updateDescription(id, description);
                        System.out.println(result);
                    }

                    case "update status" -> {
                        System.out.print("ENTER ID: ");
                        String id = in.nextLine();
                        System.out.print("ENTER NEW STATUS: ");
                        String status = in.nextLine();

                        String result = controller.updateStatus(id, status);
                        System.out.println(result);
                    }

                    case "delete" -> {
                        System.out.print("ENTER ID: ");
                        String id = in.nextLine();

                        String result = controller.delete(id);
                        System.out.println(result);
                    }
                }


                System.out.println("Program Berlanjut >>");
            }

        } catch (Exception e) {
            throw new RuntimeException("Error");
        } finally {
            System.out.println("Program Selesai");
        }
    }
}
