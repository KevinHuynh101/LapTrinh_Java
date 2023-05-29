package huynhnam.ASM5.service;

import huynhnam.ASM5.model.Course;
import huynhnam.ASM5.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository repo;

    public List<Course> getAll() {
        return repo.findAll();
    }
    public List<Course> getbyName(String keyword) {

        return repo.search(keyword);
    }

    public void add(Course newCourse) {
        repo.save(newCourse);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public void edit(Course course) {
        repo.save(course);
    }

    public Course getById(Integer id) {
        return repo.findById(id).get();
    }


}
