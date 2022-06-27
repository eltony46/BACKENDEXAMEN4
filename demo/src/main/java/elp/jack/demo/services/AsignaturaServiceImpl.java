package elp.jack.demo.services;

import elp.jack.demo.dao.AsignaturaDao;
import elp.jack.demo.models.Asignatura;

import elp.jack.demo.models.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaServiceImpl implements AsignaturaService{

    @Autowired
    private AsignaturaDao asignaturaDao;

    @Override
    public List<Asignatura> findAll()
    {return asignaturaDao.findAll();
    }

    @Override
    public Estudiante findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }


}
