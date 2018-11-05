package ua.nure.koshova.finalProject.service;

import ua.nure.koshova.finalProject.db.dao.CarsDao;
import ua.nure.koshova.finalProject.db.entity.Car;

import java.util.List;

public class CarService {

    private CarsDao carDao = CarsDao.getInstance();

    public List<Car> getCarsList(String sortField, String sortOrder,
                                 String brandId, String classId) {
        List<Car> cars;
        if (brandId == null && classId == null) {
            cars = carDao.findAllCars();
        } else if (brandId == null && classId != null) {
            Long classIdNum = Long.valueOf(classId);
            cars = carDao.getCarByClass(sortField, sortOrder, classIdNum);
        } else if (brandId != null && classId == null) {
            Long classIdNum = Long.valueOf(brandId);
            cars = carDao.getCarByBrand(sortField, sortOrder, classIdNum);
        } else {
            Long brandIdNum = Long.valueOf(brandId);
            Long classIdNum = Long.valueOf(classId);
            cars = carDao.getCarByClassBrand(sortField, sortOrder, brandIdNum, classIdNum);
        }
        return cars;
    }

    public Car getCarById(Long id){
        return carDao.findCarById(id);
    }

    public void geleteCar(Long id){
        carDao.deleteCar(id);
    }

    public static void main(String[] args) {

    }
}
