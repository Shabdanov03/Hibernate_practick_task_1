package java8;

import java8.config.HibernateConfig;
import java8.enums.OperationSystem;
import java8.models.Laptop;
import java8.service.LaptopService;
import java8.service.LaptopServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        HibernateConfig.getSession();
        LaptopService service = new LaptopServiceImpl();
        Laptop laptop = new Laptop("MacBook Pro",
                OperationSystem.IOS, 1000, 2000, LocalDate.of(2022, 3, 5));

        Laptop laptop2 = new Laptop("HP",
                OperationSystem.LINUX, 128, 6000, LocalDate.of(2019, 6, 5));

        List<Laptop> laptopList = new ArrayList<>(List.of(
                new Laptop("Lenovo", OperationSystem.WINDOWS, 256, 700, LocalDate.of(2020, 1, 3)),
                new Laptop("Asus", OperationSystem.LINUX, 512, 800, LocalDate.of(2021, 1, 5)),
                new Laptop("MacBook", OperationSystem.IOS, 1000, 1000, LocalDate.of(2021, 4, 3))));


        while (true) {
            System.out.println("\n1.SAVE LAPTOP:" +
                    "\n2.SAVE ALL LAPTOP:" +
                    "\n3.DELETE BY ID :" +
                    "\n4.DELETE ALL :" +
                    "\n5.FIND ALL :" +
                    "\n6.UPDATE :" +
                    "\n7.GROUPING BY :" +
                    "\n8.SORT BY DIFFERENT COLUMN :");
            System.out.println("ENTER BY COMMAND :");
            int n = new Scanner(System.in).nextInt();
            switch (n) {
                case 1 -> service.saveProgrammer(laptop);
                case 2 -> System.out.println(service.saveAll(laptopList));
                case 3 -> {
                    System.out.println("Enter by id :");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(service.deleteById(id));
                }
                case 4 -> service.deleteAll();
                case 5 -> System.out.println(service.findAll());
                case 6 -> {
                    System.out.println("Enter by id: ");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(service.update(id, laptop2));
                }
                case 7-> System.out.println(service.groupBy());
                case 8->{
                    System.out.println("Select column : (id / brand / operationsystem / memory / price / year");
                    String column = new Scanner(System.in).nextLine();
                    System.out.println("Select command : (asc / desc");
                    String ascOrDesc = new Scanner(System.in).nextLine();
                    System.out.println(service.sortByDifferentColumn(column, ascOrDesc));
                }
                default -> System.out.println("No such commands :");

            }
        }
    }
}
