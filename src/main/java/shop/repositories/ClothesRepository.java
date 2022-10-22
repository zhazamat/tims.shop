package shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.models.entity.Clothes;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes, Long> {

}
