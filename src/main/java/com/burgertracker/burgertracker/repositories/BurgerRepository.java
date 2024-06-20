package com.burgertracker.burgertracker.repositories;

import com.burgertracker.burgertracker.models.Burger;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BurgerRepository extends JpaRepository<Burger, Long> {

	List<Burger> findAll();
}