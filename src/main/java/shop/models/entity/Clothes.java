package shop.models.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import shop.models.enums.Gender;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="clothes")
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String size;
    @Enumerated(EnumType.STRING)
    Gender gender;
    double price;
    Boolean available;
    private String color;
    private String category;

}
