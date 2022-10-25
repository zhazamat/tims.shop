package shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.models.entity.BuyRequest;
import shop.models.entity.CalculateResponse;
import shop.models.entity.Clothes;
import shop.repositories.ClothesRepository;
import shop.services.ClothesService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ClothesServiceImpl implements ClothesService {
    private final ClothesRepository clothesRepository;
@Autowired
    public ClothesServiceImpl(ClothesRepository clothesRepository) {
        this.clothesRepository = clothesRepository;
    }

    @Override
    public Clothes update(Clothes clothes) {

        return clothesRepository.save(clothes);
    }

    @Override
    public void delete(Clothes clothes) {
     clothesRepository.delete(clothes);
    }

    @Override
    public Clothes create(Clothes clothes) {
        return clothesRepository.save(clothes);
    }

    @Override
    public List<Clothes> getAllClothes() {
        return clothesRepository.findAll();
    }

    @Override
    public List<Clothes> getClothes(long id) {
    return clothesRepository.findAll()
            .stream()
            .filter(clothes -> clothes.getId()==id)
            .collect(Collectors.toList());
    }
    @Override
    public List<Double> calculateAmount(long id,int quantity){
        List<Clothes>clothesList=getClothes(id);
        List<Double> list=new ArrayList<>();
        double amount;
        for(Clothes clothes:clothesList){
            amount=clothes.getPrice()* quantity;
            list.add(amount);
        }
    return list;
    }
    @Override
    public  double getTotalSum(long id,int quantity){
    double result=0;
   List<Double> list=calculateAmount(id,quantity);
   for(Double l:list){
       result+=l;
   }
    return result;
    }




    @Override
    public CalculateResponse calculateBuyRequest(BuyRequest buyRequest) {
        List<Clothes>clothesList=getClothesBuyRequest(buyRequest.getIds());
      //  List<Double> list=calculateAmountBuyRequest(buyRequest.getIds(), buyRequest.getQuantities());
        Map<Clothes,Double>map=calculateAmountBuyRequest(buyRequest.getIds(),buyRequest.getQuantities());
       // Double total= getTotalSumBuyRequest(buyRequest.getIds(),buyRequest.getQuantities());


        return new CalculateResponse(map);
    }

    @Override
    public List<Clothes> getClothesBuyRequest(List<Long> ids) {
        List<Clothes> clothesList = new ArrayList<>();
        for (Clothes clothes : clothesRepository.findAll()) {
            for (Long id : ids) {
                if(clothes.getId()==id)
            clothesList.add(clothes);
            }

        }
        return clothesList;
    }

    @Override
    public double getTotalSumBuyRequest(List<Long> ids, List<Integer> quantities) {
        return 0;
    }


    @Override
    public  Map<Clothes,Double> calculateAmountBuyRequest(List<Long> ids,List<Integer> quantities){
        List<Clothes>clothesList=getClothesBuyRequest(ids);
        List<Double> list=new ArrayList<>();
        Map<Clothes,Double>listMap=new HashMap<>();
        for(int i=0;i<clothesList.size();i++) {
            for(int j=0;j<quantities.size();j++){
                if(i==j){
                    listMap.put(clothesList.get(i),clothesList.get(j).getPrice() * quantities.get(j));
                }

            }
        }
        return listMap;
    }

}
