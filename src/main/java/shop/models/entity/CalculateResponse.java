package shop.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CalculateResponse {

private Clothes clothes;
private double sum;
private Double amount;

}
