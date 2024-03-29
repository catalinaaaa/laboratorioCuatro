package logicadenegocios;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;


/**
 * Write a description of class Llamada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Llamada{
  private String numeroDestino = null;
  private int minutos = 0;
  private Date fechaHora = null;
  
  private static int cantidadLlamadas = 0;
  
  public Llamada(String pNumeroDestino, int pMinutos){
    setNumDestino(pNumeroDestino);
    setMinutos(pMinutos);
  }
  
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
  
  public void setFechaHora(){
    Calendar calendario;
    calendario = Calendar.getInstance();
    fechaHora = calendario.getTime();
  }
  
  public String getFechaHora(){
    SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yy HH:mm");
    return mascara.format(fechaHora);
  }
  
}
