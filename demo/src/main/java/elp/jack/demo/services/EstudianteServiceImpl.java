package elp.jack.demo.services;

import elp.jack.demo.dao.EstudianteDao;
import elp.jack.demo.models.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstudianteServiceImpl implements EstudianteService{

    @Autowired
    private EstudianteDao estudianteDao;


    @Override
    public Estudiante save(Estudiante estudiante) {
        return estudianteDao.save(estudiante);
    }

    @Override
    public Estudiante findById(Long id) {
        return estudianteDao.findById(id).orElse(null);
    }

    @Override
    public List<Estudiante> findAll() {
        return estudianteDao.findAll();
    }

    @Override
    public void delete(Long id) {
        estudianteDao.deleteById(id);

    }
}