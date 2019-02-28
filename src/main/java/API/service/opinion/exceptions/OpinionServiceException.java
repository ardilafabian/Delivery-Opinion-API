/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API.service.opinion.exceptions;

/**
 *
 * @author fabian
 */
public class OpinionServiceException extends Exception{
    public OpinionServiceException() {
        super();
    }
    
    public OpinionServiceException(String msg) {
        super(msg);
    }
}
