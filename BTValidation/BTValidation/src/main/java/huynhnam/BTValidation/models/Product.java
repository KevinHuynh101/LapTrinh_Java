package huynhnam.BTValidation.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Setter
@Getter

public class Product {

    private int id;

    @NotBlank(message = "tên sp không để trống")
    private String name;

    @Length(min = 0, max = 50, message = "tên image không qua 50 ký tự")
    private String image;

    @NotNull(message = "giá sp không để trống")
    @Min(value = 1, message = "giá không được nhỏ hơn 1")
    @Max(value = 999999999 ,message = "giá không được quá 99999999")
    private long price;


}
