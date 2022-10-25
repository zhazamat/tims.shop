package shop.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
public class BuyRequest {
    private List<Long> ids;
    private List<Integer>quantities;
}
