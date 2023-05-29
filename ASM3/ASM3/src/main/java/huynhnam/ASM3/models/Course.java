package huynhnam.ASM3.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter

public class Course{
    private int id;
    private String lectureName;
    private String place;
    private LocalDate startDate;

}
