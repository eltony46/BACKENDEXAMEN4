package elp.jack.demo.services;

import elp.jack.demo.models.Asignatura;
import elp.jack.demo.models.Estudiante;

import java.util.List;

public interface AsignaturaService {
    public List<Asignatura> findAll();
    public Estudiante findById(Long id);
    public void delete(Long id);

}
