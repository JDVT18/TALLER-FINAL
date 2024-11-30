package com.example.taller.controladores;


import com.example.taller.Persistencia.entidades.Conductor;
import com.example.taller.Servicio.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conductor")
public class ConductController {
    @Autowired
    private ConductorService conductorServicio;
    @GetMapping ("/ver")
    public List <Conductor> findAll(){
        return conductorServicio.findAll();

    }
    @PostMapping ("/regist")
    private Conductor save (@RequestBody Conductor conductor){
       System.out.println(conductor);
        return conductorServicio.almacenar(conductor);
    }

    @PutMapping("/deshabilitar/{id}")
    public ResponseEntity<Conductor> delete (@PathVariable Long id ){
        Conductor conductor =  conductorServicio.actualizar(id);
        return ResponseEntity.ok(conductor);




    }
}
