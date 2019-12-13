package logicadenegocios;
import java.util.Date; 

public class Llamada {
  private String numeroDestino = null;
  private int minutos = 0;
  private Date fechaHora = null;
  
  private static int cantidadLlamadas = 0;
  
  public void setNumDestino(String pNumDestino){
    this.numeroDestino = pNumDestino; 
  }
  
  public String getNumDestino(){
    return numeroDestino;  
  }
  
  public void setCantidadLlamadas(int pCantidadLlamadas){
    this.cantidadLlamadas = pCantidadLlamadas; 
  }
  
  public int getCantidadLlamadas(){
    return cantidadLlamadas;  
  }
  
  public void setNumeroDestino(String pNumeroDestino){
    this.numeroDestino = pNumeroDestino; 
  }
  
  public String getNumeroDestino(){
    return numeroDestino;  
  }
  
  public void setMinutos(int pMinutos){
    this.minutos = pMinutos; 
  }
  
  public int getMinutos(){
    return minutos;  
  }
}
