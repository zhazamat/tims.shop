package shop.services;

import org.springframework.stereotype.Service;
import shop.models.entity.CalculateResponse;
import shop.models.entity.Clothes;
import shop.models.entity.QuantityRequest;

import java.util.List;

@Service
public interface ClothesService {
    Clothes update(Clothes clothes);

    void delete(Clothes clothes);

    Clothes create(Clothes clothes);

    List<Clothes> getAllClothes();

   // CalculateResponse calculate(QuantityRequest request);

    CalculateResponse calculate(long id, int quantity);

    Clothes getById(long id);

    double calculateSum(int quantity,long id);
    double getAmount(int quantity,long id);
}
