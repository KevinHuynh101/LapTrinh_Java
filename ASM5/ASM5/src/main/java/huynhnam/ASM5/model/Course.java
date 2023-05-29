package huynhnam.ASM5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import javax.annotation.processing.Generated;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
@Getter
@Setter

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Lecture name không được trống")
    @Size(max = 100, message = "Phải nhỏ hơn hoặc bằng 100 ký tứ")
    @Column(name = "LectureName")
    private String lectureName;

    @NotBlank(message = "Course name không được trống")
    @Column(name = "Place")
    private String place;

    @NotNull(message = "Không được trống")
    @FutureOrPresent(message = "Phải lớn hoặc bằng ngày hiện tại")
    @Column(name = "StartDate")
    private LocalDate startDate;
}
