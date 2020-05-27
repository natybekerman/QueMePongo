package Service.Clima;

import java.time.LocalDateTime;
import java.util.*;

public final class AccuWeatherAPI {

    private LocalDateTime ultimaFechaDePedido;
    private Double temperaturaActual = 0.0;

    public final List<Map<String, Object>> getWeather(String ciudad) {
        return Arrays.asList(new HashMap<String, Object>(){{
            put("DateTime", "2019-05-03T01:00:00-03:00");
            put("EpochDateTime", 1556856000);
            put("WeatherIcon", 33);
            put("IconPhrase", "Clear");
            put("IsDaylight", false);
            put("PrecipitationProbability", 0);
            put("MobileLink", "http://m.accuweather.com/en/ar/villa-vil/7984/");
            put("Link", "http://www.accuweather.com/en/ar/villa-vil/7984");
            put("Temperature", new HashMap<String, Object>(){{
                put("Value", 57);
                put("Unit", "F");
                put("UnitType", 18);
            }});
        }});
    }

    public Double getTemperatura ()
    {
        if(fueHaceMasDe12Horas(this.ultimaFechaDePedido)) {
            List<Map<String, Object>> condicionesClimaticas = getWeather("Buenos Aires, Argentina");
            HashMap<String, Object> primerTemperaturaObtenida = (HashMap<String, Object>) condicionesClimaticas.get(0).get("Temperatura");
            this.temperaturaActual = devuelveTemperaturaActualEnCelsius(primerTemperaturaObtenida);
            this.ultimaFechaDePedido = LocalDateTime.now();
        }
        return this.temperaturaActual;
    }

    private Double devuelveTemperaturaActualEnCelsius(HashMap<String, Object> temperatura){
        if (estaEnFahrenheit(temperatura))
            return convertirDeFahrenheitACelsius((Double) temperatura.get("Value"));
        return (Double) temperatura.get("Value");
    }

    public Boolean estaEnFahrenheit(HashMap<String, Object> primerTemperaturaObtenida){
        return primerTemperaturaObtenida.get("Unit") == "F";
    }

    public Double convertirDeFahrenheitACelsius(Double valor){
        return (valor - 32) * 5 / 9;
    }

    public Boolean fueHaceMasDe12Horas(LocalDateTime ultimaFechaDePedido){
        // Logica si fue hace mas de doce horas
        return true;
    }
}