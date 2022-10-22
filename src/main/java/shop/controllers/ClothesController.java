package shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.models.entity.CalculateResponse;
import shop.models.entity.Clothes;
import shop.models.entity.QuantityRequest;
import shop.services.ClothesService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shop")

public class ClothesController {
    private final ClothesService clothesService;
@Autowired
    public ClothesController(ClothesService clothesService) {
        this.clothesService = clothesService;
    }

    @PostMapping("/create")
    public Clothes create(@RequestBody Clothes clothes){
        return clothesService.create(clothes);
    }

    @GetMapping("/list")
    public List<Clothes> getAll(){
        return clothesService.getAllClothes();
    }

    @PutMapping("/update")
    private Clothes update(@RequestBody Clothes clothes){
        return clothesService.update(clothes);
    }

    @DeleteMapping("/delete")
    private void delete(@RequestBody Clothes clothes)
    {
        clothesService.delete(clothes);
    }
    @PostMapping("/list/id")
    public Clothes getById(@PathVariable long id){
    return clothesService.getById(id);
    }
   @GetMapping("/calculate")
    public CalculateResponse calculate(@RequestParam long id,@RequestParam int quantity){
    return clothesService.calculate(id,quantity);
    }
}
