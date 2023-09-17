package com.factoria.f5.miportafoliospring.domain.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.factoria.f5.miportafoliospring.domain.models.Proyecto;
import com.factoria.f5.miportafoliospring.infrarepositories.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service

public class ProyectoServis {



    private final ProyectoRepository proyectoRepository;
    private final Cloudinary cloudinary;
    @Autowired

    public ProyectoServis(ProyectoRepository proyectoRepository, Cloudinary cloudinary) {
        this.proyectoRepository = proyectoRepository;
        this.cloudinary = cloudinary;
    }


    public List<Proyecto> getProyect(){
        return proyectoRepository.findAll();
    }

    public void newProyect(String name, String technology, String description, MultipartFile img) throws IOException {
        Map uploadResult = cloudinary.uploader().upload(img.getBytes(), ObjectUtils.emptyMap());
        String imageUrl = (String) uploadResult.get("url");
        Proyecto proyecto = new Proyecto(name, technology, description, imageUrl);
        proyectoRepository.save(proyecto);

    }

    public Proyecto proyectoById(Integer id){
        Optional<Proyecto> proyectoById = proyectoRepository.findById(id);
        return proyectoById.orElse(null);
    }

    public void update(Integer id, String name, String technology, String description, MultipartFile img) throws IOException {
        Proyecto proyectExistent = proyectoById(id);
        if (proyectExistent != null){
            Map uploadResult = cloudinary.uploader().upload(img.getBytes(), ObjectUtils.emptyMap());
            String imagePath = (String) uploadResult.get("url");

            proyectExistent.setName(name);
            proyectExistent.setTechnology(technology);
            proyectExistent.setDescription(description);
            proyectExistent.setImagePath(imagePath);

            proyectoRepository.save(proyectExistent);
        }
    }

    public void deleteProyect(Integer id) {
        boolean existe = proyectoRepository.existsById(id);
        if (existe) {
            proyectoRepository.deleteById(id);
        }
    }
}
