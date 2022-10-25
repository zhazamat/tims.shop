package shop.services;

import org.springframework.stereotype.Service;
import shop.models.entity.BuyRequest;
import shop.models.entity.CalculateResponse;
import shop.models.entity.Clothes;

import java.util.List;
import java.util.Map;

@Service
public interface ClothesService {
    Clothes update(Clothes clothes);

    void delete(Clothes clothes);

    Clothes create(Clothes clothes);

    List<Clothes> getAllClothes();
    List<Clothes> getClothes(long id);
   List<Double> calculateAmount(long id,int quantity);

    double getTotalSum(long id,int quantity);

   List<Clothes> getClothesBuyRequest(List<Long> ids);

   // List<Double> calculateAmountBuyRequest(List<Long> ids,List<Integer> quantities);
    double getTotalSumBuyRequest(List<Long> ids,List<Integer> quantities);
    Map<Clothes,Double> calculateAmountBuyRequest(List<Long> ids,List<Integer> quantities);
    CalculateResponse calculateBuyRequest(BuyRequest buyRequest);
}
