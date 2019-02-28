/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API.controller;

import API.model.Opinion;
import API.service.opinion.OpinionService;
import API.service.opinion.exceptions.OpinionServiceException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 *
 * @author fabian
 */
@RestController
@CrossOrigin(origins = "*")
public class OpinionController {
    
    private static final Logger logger = LogManager.getLogger(OpinionController.class);
    
    @Autowired
    private OpinionService opinionService;
    
    @RequestMapping("/opinion")
    public Opinion getOpinion(@RequestParam(value="compraId") int compraId) throws OpinionServiceException{
        System.err.println("ID a bscar en la compra ----> "+compraId);
        return opinionService.getOpinionPorCompra(compraId);
    }
    
    @RequestMapping("/eliminarOpinion")
    public ResponseEntity<?> eliminarOpinion(@RequestParam(value="opinionId") int opinonId) throws OpinionServiceException{
        if (opinionService.eliminarOpinion(opinonId)) {
            return new ResponseEntity<>("Se ha borrado la opion con ID: "+ opinonId, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se encuentra la opinion o ha ocurrido un problema.", HttpStatus.CONFLICT);
        }
    }
    
    @RequestMapping("/opiniones")
    public List<Opinion> getOpiniones(@RequestParam(value="tiendaId") int tiendaId,
                                        @RequestParam(value="fechaIni") String fechaIni,
                                        @RequestParam(value="fechaFin") String fechaFin) throws OpinionServiceException {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return opinionService.getOpiniones(tiendaId, LocalDate.parse(fechaIni, format), LocalDate.parse(fechaFin, format));        
    }
    
    @RequestMapping("/registrarOpinion")
    public ResponseEntity<?> registrarOpinion(@RequestParam(value="id") int id,
                                                @RequestParam(value="fecha") String fecha,
                                                @RequestParam(value="usuarioId") int usuarioId,
                                                @RequestParam(value="tiendaId") int tiendaId,
                                                @RequestParam(value="compraId") int compraId,
                                                @RequestParam(value="puntuacion") int puntuacion,
                                                @RequestParam(value="comentario") String comentario) throws OpinionServiceException {        
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        Opinion op = new Opinion(id, LocalDate.parse(fecha,format), usuarioId, tiendaId,
                                compraId, puntuacion, comentario);
        System.out.println("Inicia paso al controler");
        opinionService.registrarOpinion(op);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
