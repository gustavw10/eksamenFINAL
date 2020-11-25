/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.CountryDTO;
import dtos.WeatherDTO;
import dtos.WeatherDTO.Weather;
import dtos.WeatherDTO.WeatherMain;
//import dtos.WeatherDTO;
import facades.FetchFacade;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import utils.HttpUtils;

/**
 * REST Web Service
 *
 * @author David
 */
@Path("weather")
public class WeatherResource {

    private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static FetchFacade FACADE = new FetchFacade();
    
    @Context
    private UriInfo context;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getEndpoints() throws IOException, InterruptedException, ExecutionException {
        List<String> list = FACADE.fetchParallel();
        return GSON.toJson(list);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{city}")
    public String getWeather(@PathParam("city") String city ) throws IOException {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=4cb8ceb8adc96ee3e4f0518d11cfa985";
        String weatherData = HttpUtils.fetchData(url);
        
        //ChuckDTO joke = GSON.fromJson(chuck, ChuckDTO.class);
        return GSON.toJson(weatherData);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("weatherDTO/{city}")
    public String getWeatherDTO(@PathParam("city") String city ) throws IOException {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=4cb8ceb8adc96ee3e4f0518d11cfa985";
        String weatherData = HttpUtils.fetchData(url);
        
        WeatherDTO weather = GSON.fromJson(weatherData, WeatherDTO.class);
        
        return GSON.toJson(weather);
    }
    
    public static void main(String[] args) throws IOException {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + "London" + "&appid=4cb8ceb8adc96ee3e4f0518d11cfa985";
        String weatherData = HttpUtils.fetchData(url);
        
        WeatherDTO we = GSON.fromJson(weatherData, WeatherDTO.class);
        
        
        
        System.out.println(we.getWeatherMain().getHumidity());
        System.out.println(we.getWeather());
        
        Weather[] wete = we.getWeather();
        System.out.println(wete[0].getMain());
        
        String url2 = "https://restcountries.eu/rest/v2/name/" + "Denmark";
        String countryData = HttpUtils.fetchData(url2);
        CountryDTO[] country = GSON.fromJson(countryData, CountryDTO[].class);
        
        System.out.println(country[0].getName());
        
    }
}
