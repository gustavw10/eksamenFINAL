/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import errorhandling.NotFoundException;
import java.io.IOException;
import javax.ws.rs.PathParam;

/**
 *
 * @author maddy
 */
public interface CovidResourceInterface {
    public String getCovid(@PathParam("country") String country ) throws IOException;
}
