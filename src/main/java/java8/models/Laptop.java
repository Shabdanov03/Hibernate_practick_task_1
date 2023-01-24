package java8.models;

import jakarta.persistence.*;
import java8.enums.OperationSystem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Shabdanov Ilim
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "laptops")
public class Laptop {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "laptop_id_generation")
    @SequenceGenerator(
            name = "laptop_id_generation",
            sequenceName = "laptop_seq",
            allocationSize = 1)
    private Long id;
    @Column(name = "brand")
    private String brand;

    @Enumerated(EnumType.STRING)
    private OperationSystem operationSystem;
    private int memory ;
    private int price;
    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;

    public Laptop(String brand, OperationSystem operationSystem, int memory, int price, LocalDate dateOfIssue) {
        this.brand = brand;
        this.operationSystem = operationSystem;
        this.memory = memory;
        this.price = price;
        this.dateOfIssue = dateOfIssue;
    }

    @Override
    public String toString() {
        return "\nLaptop : " +
                "\nid : " + id +
                "\nbrand : " + brand +
                "\noperationSystem : " + operationSystem +
                "\nmemory : " + memory +
                "\nprice : " + price +
                "\ndateOfIssue : " + dateOfIssue +
                "\n+++++++++++++++++++++++++++++++";
    }
}
