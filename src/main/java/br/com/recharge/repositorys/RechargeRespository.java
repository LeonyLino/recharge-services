package br.com.recharge.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.recharge.models.Recharge;

@Repository
public interface RechargeRespository extends JpaRepository<Recharge, Long> {

}
