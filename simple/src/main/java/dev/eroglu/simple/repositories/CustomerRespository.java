package dev.eroglu.simple.repositories;

import dev.eroglu.simple.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRespository extends JpaRepository<Customer, Long> {

}
