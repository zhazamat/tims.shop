package shop.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
@Getter
@AllArgsConstructor
public enum Gender {
    BABY_CLOTHES,
    CHILDREN_WEAR,
    MENSWEAR,
    WOMANSWEAR
}
