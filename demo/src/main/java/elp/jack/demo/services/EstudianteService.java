package elp.jack.demo.services;

import elp.jack.demo.models.Estudiante;

import java.util.List;

public interface EstudianteService {
    public Estudiante save(Estudiante estudiante);

    public Estudiante findById(Long id);

    public List<Estudiante> findAll();

    public void delete(Long id);

}
