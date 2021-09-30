/*package com.simiosMeli.DTO;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MetricasDnaDto {

    private Double metricaHumano;
    private Double metricaSimio;
    //private Set<DnaDto> valor = new HashSet<>();

    public MetricasDnaDto(){

    }

    public MetricasDnaDto(Double metricaHumano, Double metricaSimio, Set<DnaDto> valor) {
        this.metricaHumano = metricaHumano;
        this.metricaSimio = metricaSimio;
        //this.valor = valor;
    }

    public Double getMetricaHumano() {
        return metricaHumano;
    }

    public void setMetricaHumano(Double metricaHumano) {
        this.metricaHumano = metricaHumano;
    }

    public Double getMetricaSimio() {
        return metricaSimio;
    }

    public void setMetricaSimio(Double metricaSimio) {
        this.metricaSimio = metricaSimio;
    }

    //public Set<DnaDto> getValor() {
       // return valor;
   // }

    //public void setValor(Set<DnaDto> valor) {
       // this.valor = valor;
    //}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MetricasDnaDto)) return false;
        MetricasDnaDto that = (MetricasDnaDto) o;
        return Objects.equals(getMetricaHumano(), that.getMetricaHumano()) && Objects.equals(getMetricaSimio(), that.getMetricaSimio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMetricaHumano(), getMetricaSimio());
    }
}
*/