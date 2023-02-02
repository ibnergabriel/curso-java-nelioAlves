package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        List<Product> list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter the number of products: ");
        int n = scanner.nextInt();

        for(int i=1; i<=n; i++){
            System.out.println("Product #"+ i + " data: ");
            System.out.print("Common, used or imported (c/u/i)? ");
            char ch = scanner.next().charAt(0);
            System.out.print("Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("Price: ");
            double price = scanner.nextDouble();

            if(ch == 'i'){
                System.out.print("Customs fee: ");
                double customsFee = scanner.nextDouble();
                list.add((new ImportedProduct(name, price, customsFee)));
            } else if (ch == 'u'){
                System.out.print("Manufacture Date: ");
                String manufactureDate = scanner.next();

                list.add(new UsedProduct(name,price, sdf.parse(manufactureDate)));
            }
            else{
                list.add(new Product(name,price));
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS: ");
        for (Product p: list){
            System.out.println(p.priceTag());
        }
    }
}