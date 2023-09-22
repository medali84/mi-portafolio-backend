package com.factoria.f5.miportafoliospring.apiControlers;

import com.factoria.f5.miportafoliospring.domain.models.Proyecto;
import com.factoria.f5.miportafoliospring.domain.services.ProyectoServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import com.cloudinary.Cloudinary;
import java.io.IOException;
import java.util.List;
import java.util.Map;




@CrossOrigin(origins = "https://mi-portafolio-backend-production.up.railway.app/api/v1/proyectos")
@RestController
@RequestMapping(path = "api/v1/proyectos")
public class ProyectoController {

    private final ProyectoServis proyectoServis;
    private final Cloudinary cloudinary;

    @Autowired

        public ProyectoController(ProyectoServis proyectoServis, Cloudinary cloudinary) {
            this.proyectoServis = proyectoServis;
            this.cloudinary = cloudinary;
        }


    @GetMapping
    public List<Proyecto> getProyectControler() {
        return proyectoServis.getProyect();
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<?> createProyect(
            @RequestParam String name,
            @RequestParam String technology,
            @RequestParam String description,
            @RequestParam MultipartFile img) throws IOException {



        proyectoServis.newProyect(name, technology, description, img);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public void updateProyect(@PathVariable Integer id, @RequestParam String name,
                              @RequestParam String technology,
                              @RequestParam String description,
                              @RequestParam MultipartFile img) throws IOException {
        proyectoServis.update(id, name, technology, description, img);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        proyectoServis.deleteProyect(id);
    }
}
