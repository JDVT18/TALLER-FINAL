package com.example.taller.controladores;

import com.example.taller.Persistencia.entidades.Vehiculo;
import com.example.taller.Servicio.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {
    @Autowired
    private VehiculoService vehiculoServicio;
    @GetMapping("/ver")
    public List<Vehiculo> findAll(){
        return vehiculoServicio.findAll();

    }
    @PostMapping("/regist")
    private Vehiculo save (@RequestBody Vehiculo vehiculo){
        return vehiculoServicio.almacenar(vehiculo);
    }
    @PutMapping("/deshabilitar/{id}")
    public ResponseEntity<Vehiculo> delete (@PathVariable Long id ){
      Vehiculo vehiculo =  vehiculoServicio.actualizar(id);
     return ResponseEntity.ok(vehiculo);

    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Vehiculo> actualizarVehiculo(
            @PathVariable Long id,
            @RequestBody Vehiculo vehiculoActualizado) {
        Vehiculo vehiculo = vehiculoServicio.actualizarVehiculo(id, vehiculoActualizado);
        return ResponseEntity.ok(vehiculo);
    }
    @PutMapping("/asign/{vehiculoId}/conductor/{conductorId}")
    public ResponseEntity<Vehiculo> asignarConductor(
            @PathVariable Long vehiculoId,
            @PathVariable Long conductorId) {
        Vehiculo vehiculo = vehiculoServicio.asignarConductor(vehiculoId, conductorId);
        return ResponseEntity.ok(vehiculo);
    }

}
