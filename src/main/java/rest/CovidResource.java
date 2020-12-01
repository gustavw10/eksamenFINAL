/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dtos.CovidListDTO;
import dtos.CovidDTO;
import dtos.WeatherDTO;
import errorhandling.NotFoundException;
import facades.FetchFacade;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
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
@Path("covid")
public class CovidResource implements CovidResourceInterface{

    private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static FetchFacade FACADE = new FetchFacade();

    @Context
    private UriInfo context;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{country}")
    public String getCovid(@PathParam("country") String country ) throws IOException{
        String url = "https://covid-api.mmediagroup.fr/v1/cases?country=" + country;
        String covidData = HttpUtils.fetchData(url);
        
        
        CovidDTO covid = GSON.fromJson(covidData, CovidDTO.class);
        
        return GSON.toJson(covid);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String getCovidAll() throws IOException {
        String url = "https://api.covid19api.com/summary";
        String covidData = HttpUtils.fetchData(url);
        
        CovidListDTO covid = GSON.fromJson(covidData, CovidListDTO.class);
        return GSON.toJson(covid);
    }
    
    public static void main(String[] args) throws IOException {
        String url = "https://api.covid19api.com/summary";
        String covidData = HttpUtils.fetchData(url);
        
        CovidListDTO covid = GSON.fromJson(covidData, CovidListDTO.class);
        
        System.out.println(covid.getCountries().get(2));
        
        System.out.println(GSON.toJson(covid.getCountries().get(2)));
    }
}