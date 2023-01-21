package xyz.christophermedlin.cato.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import xyz.christophermedlin.cato.entities.Smoothie;
import xyz.christophermedlin.cato.entities.UsesIngredient;
import xyz.christophermedlin.cato.repositories.SmoothieRepository;
import xyz.christophermedlin.cato.repositories.UsesIngredientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SmoothieServiceImpl implements SmoothieService {

    @Autowired
    SmoothieRepository smoothieRepo;
    @Autowired
    UsesIngredientRepository usesIngredient;

    @Override
    public Smoothie findById(Long id) {
        Optional<Smoothie> o = smoothieRepo.findById(id);
        if (!o.isPresent()) {
            throw new IllegalArgumentException("Smoothie not found.");
        }
        return o.get();
    }

    @Override
    public List<Smoothie> findAll() {
        return findAll((Pageable) PageRequest.ofSize(10));
    }

    @Override
    public List<Smoothie> findAll(Pageable page) {
        return smoothieRepo.findAll(page).toList();
    }
}
