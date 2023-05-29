package huynhnam.ASM5.repository;

import huynhnam.ASM5.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository  extends JpaRepository<Course,Integer> {
    @Query(value = "SELECT c FROM Course c where c.lectureName LIKE CONCAT('%',:keyword, '%')")

    List<Course> search(@Param("keyword") String keyword);

}
