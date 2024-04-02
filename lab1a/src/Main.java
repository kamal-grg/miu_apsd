import java.time.LocalDateTime;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void showMenu()
    {
        System.out.println("National Gcocerry Managment Sytem v 1.0 By Kamal Guragayin\n\n");
        System.out.println("Operational Menu");

        System.out.println("1. Add Product");
        System.out.println("2. Report in JSON Format");
        System.out.println("3. Report in JSON XML");
        System.out.println("4. Report in JSON CSV");
        System.out.println("5. Exit Application");
    }

    public static void showReportInJSON(ArrayList<Product> products)
    {
        Collections.sort(products);

        //generate JSON
        StringBuilder sb=new StringBuilder("");
        sb.append("[\n");
       for(Product p :products)
       {
           sb.append("{");
           sb.append("\"productId\"");
           sb.append(":");
            sb.append(p.getProdutId());
            sb.append(",");

           sb.append("\"name\"");
           sb.append(":");
           sb.append(p.getName());
           sb.append(",");

           sb.append("\"dateOfSupplied\"");
           sb.append(":");
           sb.append(p.getDateOfSupplied().toString());
           sb.append(",");

           sb.append("\"quantityInStock\"");
           sb.append(":");
           sb.append(p.getQuantityInStock());
           sb.append(",");

           sb.append("\"unitPrice\"");
           sb.append(":");
           sb.append(p.getUnitPrice());



           sb.append("},\n");

       }

       sb.append("]");
        System.out.println(sb.toString());


    } public static void showReportInJXML(ArrayList<Product> products)
    {
        Collections.sort(products);

        //generate JSON
        StringBuilder sb=new StringBuilder();
        sb.append("<?xml version=\"1.0\"?>\n");
        sb.append("<products>\n");
        for(Product p :products)
        {
            sb.append("<product ");

            sb.append("productId");
            sb.append("=\"");
            sb.append(p.getProdutId());
            sb.append("\" ");

            sb.append("name");
            sb.append("=\"");
            sb.append(p.getName());
            sb.append("\" ");

            sb.append("dateOFSupplied");
            sb.append("=\"");
            sb.append(p.getDateOfSupplied().toString());
            sb.append("\" ");


            sb.append("quantityInStock");
            sb.append("=\"");
            sb.append(p.getQuantityInStock());
            sb.append("\" ");

            sb.append("unitPrice");
            sb.append("=\"");
            sb.append(p.getUnitPrice());
            sb.append("\"");



            sb.append(">,\n");

        }

        sb.append("</products>>");
        System.out.println(sb.toString());


    }


    public static void showReportInCSV(ArrayList<Product> products)
    {
        Collections.sort(products);

        //generate JSON
        StringBuilder sb=new StringBuilder("");
        sb.append("\n");
        for(Product p :products)
        {
            sb.append(p.getProdutId());
            sb.append(",");
            sb.append(p.getName());
            sb.append(",");
            sb.append(p.getDateOfSupplied().toString());
            sb.append(",");
            sb.append(p.getQuantityInStock());
            sb.append(",");
            sb.append(p.getUnitPrice());
            sb.append("\n");
        }


        System.out.println(sb.toString());


    }
    public static void addProduct(Product product)
    {



    }
    public static void main(String[] args) {

        var products = new ArrayList<Product>();
        Scanner scanner = new Scanner(System.in);
        // Adding products to the list
        products.add(new Product("Apple", new Date(), 10, 5.99));
        products.add(new Product("Banana", new Date(), 20, 3.49));
        products.add(new Product( "Carrot", new Date(), 15, 7.99));


//show menus

showMenu();

        System.out.println("Your choice ");
        int ch = scanner.nextInt();
        switch(ch)
        {
            case 1:
                System.out.println("\nEnter Product Name: ");
                scanner.nextLine();
                String name=scanner.nextLine();
                System.out.println("\nEnter Supplied Date: ");
                String dateString = scanner.nextLine();


                // Get the current time in milliseconds since the epoch
                long currentTimeMillis = System.currentTimeMillis();

                // Create a Date object representing the current date
                Date date = new Date();

                System.out.println("\nEnter Quantity: ");
                int qty = scanner.nextInt();
                System.out.println("\nEnter Unit Price: ");
                double price = scanner.nextDouble();
                Product prod=new Product(name,date,qty,price);
                products.add(prod);
                showReportInJSON(products);
                break;
            case 2:
                showReportInJSON(products);

                break;
            case 3:
                showReportInCSV(products);
                break;

            case 4:
              showReportInJXML(products);
                break;

            case 5:
                break;
            default:
                System.out.println("Invalid Choice");
        }




    }
}