/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author Gustav
 */
public class CovidDTO {
    
    private All All;

    public CovidDTO(All all) {
        this.All = all;
    }
    
    public static class All {
        String confirmed;
        String recovered;
        String deaths;
        String country;
        int population;
        public All() {
        }

        public All(String confirmed, String recovered, String deaths, String country, int population) {
            this.confirmed = confirmed;
            this.recovered = recovered;
            this.deaths = deaths;
            this.country = country;
            this.population = population;
        }

        public String getConfirmed() {
            return confirmed;
        }

        public void setConfirmed(String confirmed) {
            this.confirmed = confirmed;
        }

        public String getRecovered() {
            return recovered;
        }

        public void setRecovered(String recovered) {
            this.recovered = recovered;
        }

        public String getDeaths() {
            return deaths;
        }

        public void setDeaths(String deaths) {
            this.deaths = deaths;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }
        
    }

    public All getAll() {
        return All;
    }

    public void setAll(All all) {
        this.All = all;
    }
    
}
