package java8.service;

import java8.dao.LaptopDao;
import java8.dao.LaptopDaoImpl;
import java8.enums.OperationSystem;
import java8.models.Laptop;

import java.util.List;
import java.util.Map;

/**
 * Shabdanov Ilim
 **/
public class LaptopServiceImpl implements LaptopService{
    LaptopDao laptopDao = new LaptopDaoImpl();
    @Override
    public Laptop saveProgrammer(Laptop laptop) {
        return laptopDao.saveProgrammer(laptop);
    }

    @Override
    public List<Laptop> saveAll(List<Laptop> laptops) {
        return laptopDao.saveAll(laptops);
    }

    @Override
    public Laptop deleteById(Long id) {
        return laptopDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
     laptopDao.deleteAll();
    }

    @Override
    public List<Laptop> findAll() {
        return laptopDao.findAll();
    }

    @Override
    public Laptop update(Long id, Laptop laptop) {
        return laptopDao.update(id,laptop);
    }

    @Override
    public Map<OperationSystem, List<Laptop>> groupBy() {
        return laptopDao.groupBy();
    }

    @Override
    public List<Laptop> sortByDifferentColumn(String column, String ascOrDesc) {
        return laptopDao.sortByDifferentColumn(column,ascOrDesc);
    }
}
