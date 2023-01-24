package java8.service;

import java8.enums.OperationSystem;
import java8.models.Laptop;

import java.util.List;
import java.util.Map;

/**
 * Shabdanov Ilim
 **/
public interface LaptopService {
    Laptop saveProgrammer(Laptop laptop);

    public List<Laptop> saveAll(List<Laptop> laptops);

    public Laptop deleteById(Long id);

    public void deleteAll();

    public List<Laptop> findAll();

    public Laptop update(Long id, Laptop laptop);

    Map<OperationSystem, List<Laptop>> groupBy();

    List<Laptop> sortByDifferentColumn(String column, String ascOrDesc);
}
