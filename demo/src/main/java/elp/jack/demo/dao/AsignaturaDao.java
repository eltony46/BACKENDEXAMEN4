package elp.jack.demo.dao;

import elp.jack.demo.models.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaDao extends JpaRepository<Asignatura, Long> {
}
