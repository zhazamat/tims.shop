package shop.models.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import shop.models.enums.Gender;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="shop")
@ToString
public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String size;
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;
    private  double price;
    private Boolean available;
    private String color;
    private String category;

}
