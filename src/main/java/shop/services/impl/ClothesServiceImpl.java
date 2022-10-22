package shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.models.entity.CalculateResponse;
import shop.models.entity.Clothes;
import shop.repositories.ClothesRepository;
import shop.services.ClothesService;

import java.util.List;

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
     public CalculateResponse calculate(long id, int quantity) {
         Clothes clothes=clothesRepository.getById(id);
         double total=getAmount(quantity,id);
         double sum=calculateSum(quantity,id);
        return new CalculateResponse(clothes,sum,total);
    }

    @Override
    public Clothes getById(long id) {
        for (Clothes c : clothesRepository.findAll()) {
            if (c.getId() == id) {
               return c;
            }
        }
        throw new RuntimeException("Not found"+id);
    }
    @Override
    public double getAmount(int quantity,long id) {
    double total=0;
        for(Clothes clothes:clothesRepository.findAll()){
            if(clothes.getId()==id){
                total+=clothes.getPrice()*quantity;
            }
        }
       return total;
    }
    @Override
    public double calculateSum(int quantity,long id) {
        for(Clothes clothes:clothesRepository.findAll()){
            if(clothes.getId()==id){
                return clothes.getPrice()*quantity;
            }
        }
       throw new RuntimeException("Not found");
    }

}
