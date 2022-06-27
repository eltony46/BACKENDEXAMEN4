package elp.jack.demo.controllers;

import elp.jack.demo.models.Asignatura;
import elp.jack.demo.models.Estudiante;
import elp.jack.demo.services.AsignaturaService;
import elp.jack.demo.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Estudiante>> listarEstudiantes() {
        return new ResponseEntity<>(estudianteService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/asignaturas")
    public ResponseEntity<List<Asignatura>> listarAsignaturas() {
        return new ResponseEntity<>(asignaturaService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiante(@PathVariable Long id) {
        return new ResponseEntity<>(estudianteService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/listar")
    public ResponseEntity<Estudiante> listarEstudiante(@RequestBody Estudiante estudiante) {
        return new ResponseEntity<>(estudianteService.save(estudiante), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        Estudiante estudianteEncontrado = estudianteService.findById(id);
        if (estudianteEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            estudianteEncontrado.setNombre(estudiante.getNombre());
            estudianteEncontrado.setApellido(estudiante.getApellido());
            estudianteEncontrado.setCorreo(estudiante.getCorreo());
            estudianteEncontrado.setSigla(estudiante.getSigla());
            estudianteEncontrado.setImagen(estudiante.getImagen());
            estudianteEncontrado.setAsignatura(estudiante.getAsignatura());
            return new ResponseEntity<>(estudianteService.save(estudianteEncontrado), HttpStatus.CREATED);

        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> actualizarEstudiante(@PathVariable Long id){
        estudianteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}