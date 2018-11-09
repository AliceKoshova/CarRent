package ua.nure.koshova.finalProject.service;
import java.util.List;
import ua.nure.koshova.finalProject.db.dao.impl.ClassDao;
import ua.nure.koshova.finalProject.db.entity.ClassCar;

public class ClassService {
    private ClassDao classDao  = ClassDao.getInstance();

    public List<ClassCar> getClassList() {
        return classDao.findAllClasses();
    }

    public ClassCar getClassById(Long id){
        ClassCar classCar = classDao.getClassById(id);
        return classCar;
    }
    public Long getClassByName(String name){
        Long id = classDao.getClassByName(name);
        return id;
    }
}
