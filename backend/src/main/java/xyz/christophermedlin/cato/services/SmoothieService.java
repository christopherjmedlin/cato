package xyz.christophermedlin.cato.services;

import org.springframework.data.domain.Pageable;
import xyz.christophermedlin.cato.entities.Smoothie;

import java.util.List;

public interface SmoothieService {

    Smoothie findById(Long id);
    List<Smoothie> findAll();
    List<Smoothie> findAll(Pageable page);
}
