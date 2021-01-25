package br.com.exchange.currency.repository;

import br.com.exchange.currency.repository.entity.CurrencyConverterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyConverterEntity, Long> {
     List<CurrencyConverterEntity> findByIdUser(Long idUser);
}
