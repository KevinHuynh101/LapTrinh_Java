package huynhnam.ASM3.services;

import huynhnam.ASM3.models.Course;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {
    private List<Course> listCourse = new ArrayList<>();

    public void add(Course newProduct) {
        listCourse.add(newProduct);
    }
    public List<Course> GetAll() {
        return listCourse;
    }


}
