/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API.service.opinion;

import java.util.List;
import java.time.LocalDate;
import API.service.opinion.exceptions.OpinionServiceException;
import API.model.Opinion;

/**
 *
 * @author fabian
 */
public interface OpinionService {
    
    void registrarOpinion (Opinion opinion) throws OpinionServiceException;
    
    boolean eliminarOpinion (int opinionId) throws OpinionServiceException;
    
    Opinion getOpinionPorCompra (int compraId) throws OpinionServiceException;
    
    List<Opinion> getOpiniones (int tiendaId, LocalDate ini, LocalDate fin) throws OpinionServiceException;
}
