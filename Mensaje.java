package logicadenegocios;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * Write a description of class Mensaje here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mensaje {
  private String numeroDestino = null;
  private String mensaje = null;
  private Date fechaHora = null;
  
  private static int cantidadMensajes = 0;
  
  public Mensaje(String pNumeroDestino, String mensaje){
    setNumDestino(pNumeroDestino);
    setMensaje(mensaje);
  }
      
  public void setNumDestino(String pNumDestino){
    this.numeroDestino = pNumDestino; 
  }
  
  public String getNumDestino(){
    return numeroDestino;  
  }
  
  
  public void setMensaje(String pMensaje){
    this.mensaje = pMensaje; 
  }
  
  public String getMensaje(){
    return mensaje;  
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
  
  public void setCantidadMensajes(int pCantidadMensajes){
    this.cantidadMensajes = pCantidadMensajes; 
  }
  
  public int getCantidadMensajes(){
    return cantidadMensajes;  
  }
  
}
