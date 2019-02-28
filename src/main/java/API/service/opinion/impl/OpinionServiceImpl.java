/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API.service.opinion.impl;

import API.controller.OpinionController;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import API.model.Opinion;
import org.springframework.stereotype.Service;
import API.service.opinion.OpinionService;
import API.service.opinion.exceptions.OpinionServiceException;
import java.time.Month;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author fabian
 */
@Service
public class OpinionServiceImpl implements OpinionService{
    
    private static final Logger logger = LogManager.getLogger(OpinionServiceImpl.class);
    
    List<Opinion> opiniones = new ArrayList<Opinion>();
    
    public OpinionServiceImpl() {
        Opinion op1 = new Opinion(1, LocalDate.of(2005, Month.MARCH, 10), 123, 456, 789, 5, "Perfecto");
        Opinion op2 = new Opinion(2, LocalDate.of(2010, Month.JANUARY, 22), 34, 456, 285, 3, "No me gustó");
        Opinion op3 = new Opinion(3, LocalDate.of(2012, Month.DECEMBER, 01), 492, 456, 45, 4, "Estuvo bueno");
        Opinion op4 = new Opinion(4, LocalDate.of(2018, Month.NOVEMBER, 10), 98, 456, 56, 1, "Pesimo");
        opiniones.add(op1);
        opiniones.add(op2);
        opiniones.add(op3);
        opiniones.add(op4);
    }

    @Override
    public void registrarOpinion(Opinion opinion) throws OpinionServiceException {
        opiniones.add(opinion);
        System.out.println("Opinion Agregada -> " + opinion);
    }

    @Override
    public boolean eliminarOpinion(int opinionId) throws OpinionServiceException {
        boolean res = false;
        for (int i = 0; i < opiniones.size(); i++) {
            if (opiniones.get(i).getId() == opinionId) {
                opiniones.remove(i);
                res = true;
            }
        }
        return res;
    }

    @Override
    public Opinion getOpinionPorCompra(int compraId) throws OpinionServiceException {
        Opinion op = null;
        for (int i = 0; i < opiniones.size(); i++) {
            if (opiniones.get(i).getCompraId() == compraId) {
                op = opiniones.get(i);
            }
            
        }
        return op;
    }

    @Override
    public List<Opinion> getOpiniones(int tiendaId, LocalDate ini, LocalDate fin) throws OpinionServiceException {
        List<Opinion> result = new ArrayList<Opinion>();
        Opinion op;
        for (int i = 0; i < opiniones.size(); i++) {
            op = opiniones.get(i);
            if (op.getTiendaId() == tiendaId && 
                    op.getFecha().isAfter(ini) && op.getFecha().isBefore(fin)) {
                result.add(op);
            }
        }
        return result;
    }
    
}
