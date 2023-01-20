package xyz.christophermedlin.cato.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.christophermedlin.cato.entities.Smoothie;

@Repository
public interface SmoothieRepository extends JpaRepository<Smoothie, Long> {

}

