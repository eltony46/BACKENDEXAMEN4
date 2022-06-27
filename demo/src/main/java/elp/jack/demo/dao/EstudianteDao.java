package elp.jack.demo.dao;

import elp.jack.demo.models.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteDao extends JpaRepository<Estudiante, Long> {
}
