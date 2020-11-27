/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.io.IOException;
import javax.ws.rs.PathParam;

/**
 *
 * @author maddy
 */
public interface WeatherResourceInterface {
    
    public String getWeather(@PathParam("city") String city ) throws IOException;
    
    public String getWeatherDTO(@PathParam("city") String city ) throws IOException;
}
