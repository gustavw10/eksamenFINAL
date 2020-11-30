/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.util.ArrayList;

public class CovidListDTO {

    Global GlobalObject;
    ArrayList<Country> Countries = new ArrayList<Country>();

    public ArrayList<Country> getCountries() {
        return Countries;
    }

    public void setCountries(ArrayList<Country> Countries) {
        this.Countries = Countries;
    }

    public Global getGlobal() {
        return GlobalObject;
    }

    public void setGlobal(Global GlobalObject) {
        this.GlobalObject = GlobalObject;
    }

    class Country {

        public String Country;
        public String CountryCode;
        public int TotalConfirmed;

        public String getCountry() {
            return Country;
        }

        public void setCountry(String Country) {
            this.Country = Country;
        }

        public String getCountryCode() {
            return CountryCode;
        }

        public void setCountryCode(String CountryCode) {
            this.CountryCode = CountryCode;
        }

        public int getTotalConfirmed() {
            return TotalConfirmed;
        }

        public void setTotalConfirmed(int TotalConfirmed) {
            this.TotalConfirmed = TotalConfirmed;
        }
    }

}

class Global {

    private float NewConfirmed;
    private float TotalConfirmed;
    private float NewDeaths;
    private float TotalDeaths;
    private float NewRecovered;
    private float TotalRecovered;

    // Getter Methods 
    public float getNewConfirmed() {
        return NewConfirmed;
    }

    public float getTotalConfirmed() {
        return TotalConfirmed;
    }

    public float getNewDeaths() {
        return NewDeaths;
    }

    public float getTotalDeaths() {
        return TotalDeaths;
    }

    public float getNewRecovered() {
        return NewRecovered;
    }

    public float getTotalRecovered() {
        return TotalRecovered;
    }

    // Setter Methods 
    public void setNewConfirmed(float NewConfirmed) {
        this.NewConfirmed = NewConfirmed;
    }

    public void setTotalConfirmed(float TotalConfirmed) {
        this.TotalConfirmed = TotalConfirmed;
    }

    public void setNewDeaths(float NewDeaths) {
        this.NewDeaths = NewDeaths;
    }

    public void setTotalDeaths(float TotalDeaths) {
        this.TotalDeaths = TotalDeaths;
    }

    public void setNewRecovered(float NewRecovered) {
        this.NewRecovered = NewRecovered;
    }

    public void setTotalRecovered(float TotalRecovered) {
        this.TotalRecovered = TotalRecovered;
    }
}
