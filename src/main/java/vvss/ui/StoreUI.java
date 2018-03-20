package vvss.ui;



import vvss.controller.StoreController;
import vvss.model.Product;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Vlad on 17-Mar-16.
 */
public class StoreUI {
    public StoreController ctrl;
    Scanner in;

    public StoreUI(StoreController ctrl) {
        this.ctrl = ctrl;
        this.in = new Scanner(System.in);
    }

    public void printMenu() {
        String menu;
        menu = "These are the available commands:\n";
        menu += "\t 1 - Add a new Product \n";
        menu += "\t 2 - Displays all products from category\n";
        menu += "\t 3 - Stock situation for all productst \n";
        menu += "\t 4 - Stock situation for a certain product \n";
        menu += "\t 0 - to exit; \n";
        System.out.println(menu);
    }

    public void AddNewProduct() {
        System.out.println("Give the Product code:");
        int pCode = readInt();

        System.out.println("Give the product name:");
        String pName = in.nextLine();

        System.out.println("Give the product category:");
        String pCategory = in.nextLine();

        System.out.println("Give the quantity:");
        int pQunatity = readInt();

        Product p = new Product(pCode, pName, pCategory, pQunatity);
        String msg = ctrl.addProduct(p);
        if(msg.equals("success")) {
            System.out.println(msg);
        }
        else
            System.err.println(msg);
    }

    public void DisplayCategory() {
        System.out.println("Give category");
        String cat = in.nextLine();
        ArrayList<Product> temp = ctrl.getProductsCategory(cat);

        for (Product p : temp) {
            System.out.println(p.toString());
        }
    }

    public void DisplayStock() {

        ArrayList<Product> temp = ctrl.stockSituation();

        for (Product p : temp) {
            System.out.println(p.toString());
        }
    }

    public void DisplayStockFor() {
        System.out.println("Give product name");
        String cat = in.nextLine();
        ArrayList<Product> temp = ctrl.stockSituationProduct(cat);

        for (Product p : temp) {
            System.out.println(p.toString());
        }
    }

    public int readCommand() {
        System.out.println("Give a command: ");
        return readInt();
    }

    public void executeCommand(int c) {
        switch (c) {
            case 1:
                AddNewProduct();
                break;
            case 2:
                DisplayCategory();
                break;
            case 3:
                DisplayStock();
                break;
            case 4:
                DisplayStockFor();
                break;
            default:
                System.out.println("B'bye now!...\n");
                break;
        }
    }

    public void run() {
        int c;
        do {
            printMenu();
            c = readCommand();
            executeCommand(c);
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (c != 0);

    }

    private int readInt() {
        try {
            return Integer.parseInt(in.nextLine());
        } catch (NumberFormatException ex) {
            System.err.println("Invalid input");
            return readInt();
        }

    }


}
