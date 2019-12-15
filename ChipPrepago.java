
package logicadenegocios;
import logicadenegocios.Llamada;
import logicadenegocios.Mensaje;

/**
 * Write a description of class ChipPrepago here.
 * 
 * @author Irene Rojas, Catalina Sánchez 
 * @version 1
 */
public class ChipPrepago{
  private String numTelefono = null;
  private double saldo = 0.0;
  private String duenio = null;
  private boolean estado = false;
  private int contadorSalvame = 0;
  private int megabytes = 0;
  private Mensaje[] mensajesRecibidos = null;
  private int codigoPais = 0;
  private String url = null;
  private Llamada llamada = null;
  private Mensaje mensaje = null;
  
  private static ChipPrepago[] chips = null;
  private static Llamada[] llamadas = null;
  private static Mensaje[] mensajes = null;
  private static int cantidadChip = 0;
  private static int cantidadLlamadas = 0;
  private static int cantidadMensajes = 0;
  
  public ChipPrepago(String pNumTelefono, double pSaldo, String pDuenio, boolean pEstado, int pMegabytes, int pCodigoPais){
    cantidadChip++;
    setNumTelefono(pNumTelefono);
    setSaldo(pSaldo);
    setDuenio(pDuenio);
    setEstado(pEstado);
    setMegabytes(pMegabytes);
    setCodigoPais(pCodigoPais);
  }
  
  
  public void setNumTelefono(String pNumTelefono){
    this.numTelefono = pNumTelefono; 
  }
  
  
  public String getNumTelefono(){
    return numTelefono;  
  }
  
  
  public void setSaldo(double pSaldo){
    this.saldo = pSaldo; 
  }
  
  
  public double getSaldo(){
    return saldo;  
  }
  
  
  public void setDuenio(String pDuenio){
    this.duenio = pDuenio; 
  }
  
  
  public void setEstado(boolean pEstado){
    this.estado = pEstado; 
  }
  
  
  public boolean getEstado(){
    return estado;  
  }
  
  
  public int getContadorSalvame(){
    return contadorSalvame;  
  }
  
  
  public void setMegabytes(int pMegabytes){
    this.megabytes = pMegabytes; 
  }
  
  
  public int getMegabytes(){
    return megabytes;  
  }
  
  
  public void setCodigoPais(int pCodigoPais){
    this.codigoPais= pCodigoPais;
  }
  
  
  public int getCodigoPais(){
    return codigoPais;
  }
  
  
  public void setUrl(String pUrl){
    this.url= pUrl;
  }
  
  
  public int getCantidadChip(){
    return cantidadChip;
  }
  
  
  /**
  * método para activar el chip prepago
  * @param duenio, megabytes, nombre del dueño del chip y 
  * los megabytes del chip prepago
  */
  public void activar(String duenio, int megabytes){
    setDuenio(duenio);
    setMegabytes(megabytes);
    setSaldo(1000);
    setEstado(true);
  }
  
  
  /**
  * método para consultar el saldo actual del chip prepago
  */
  public String consultarSaldo(){
    return "El saldo actual es de: " + saldo;
  }
  
  
  public String consultarSalida(ChipPrepago chip) {
    return "Falta este, lo hago mañana:)";
  }
  
  
  /**
  * método para recargar el saldo del chip prepago
  * @param saldo,saldo a aumentar del saldo actual
  * @return el nuevo balance del saldo o un mensaje para revisar
  * el monto a recargar
  */
  public String recargar(double pSaldo) {
    if(pSaldo > 0){
        saldo += pSaldo;
        setSaldo(saldo);
        return "El nuevo saldo es: " + saldo;
    }
    else {
      return "Revise el monto ingresado";
    }
  }
  
  
  /**
  * método para recargar 100 colones al saldo
  * @return mensaje si la recarga fue exitosa o un mensaje de 
  * error si el comodín "sálvame" sobrepasa la cantidad de veces
  * por ser utilizado
  */
  public String salvame() {
    double saldo = getSaldo();
    if(getContadorSalvame() < 3) {
      if(saldo == 0.0) {
        saldo += 100.0;
        setSaldo(saldo);
        contadorSalvame++;
        return "Salvame se ha realizado exitosamente";
      }
      else {
        return "Su saldo no es cero, no es posible realizar recarga";
      }
    }
    else {
      return "Solo es posible realizar salvame 3 veces";
    }
  }
  
  
  /**
  * método que determina el costo de un país en específicp
  * @param codigoPais, el código del pais consultado
  * @return el costo de la llamada/el mensaje del pais consultado
  */
  private int determinarCostoPais(int codigoPais) {
      int costo = 0;
      switch(codigoPais) {
          case 506: costo = 5;
          break;
          case 100: costo = 7;
          break;
          case 40: costo = 4;
          break;
          case 37: costo = 2;
          break;
          case 85: costo = 3;
          break;
      }
      return costo;
  }
  
  
  /**
  * método para ver el saldo luego de llamar
  * @param chip, minutos, codigoPais, el número del chip prepago,
  * los minutos llamados, y el código del pais al que se llama
  * @return el saldo actual del chip prepago en el que se hace
  * la llamada
  */
  public String llamar(ChipPrepago chip, int minutos, int codigoPais) {
    String numDestino = chip.getNumTelefono();
    Llamada llamadaNueva = new Llamada(numDestino, minutos); 
    llamadas[cantidadLlamadas] = llamadaNueva;
    cantidadLlamadas++;
    if (numDestino == "911") {
      return "El saldo actual es de:" + saldo;
    }
    else {
      saldo -= determinarCostoPais(codigoPais);
      return "El saldo actual es de: " + saldo;
    }
  }
  
  
  /**
  *  método que devuelve el historial de llamadas
  * @return el historial de llamadas
  */
  public String historialLlamadas(){
    String historial = null;
    int i = 0;
    while(llamadas[i] != null && i < llamadas.length){
        historial+="Numero Destino: " + llamadas[i].getNumDestino() + "\n";
        historial+="Minutos: " + llamadas[i].getMinutos() + "\n";
        historial+="Fecha y Hora: " + llamadas[i].getFechaHora() + "\n";
    }
    return historial;
  }
  
  
  /**
  *  método que devuelve el historial de mensajes
  * @return el historial de mensajes
  */
  public String historialMensajes(){
    String historial = null;
    int i = 0;
    while(mensajes[i] != null && i < mensajes.length){
        historial += "Numero Destino: " + mensajes[i].getNumDestino() + "\n";
        historial += "Mensaje: " + mensajes[i].getMensaje() + "\n";
        historial += "Fecha y Hora: " + mensajes[i].getFechaHora() + "\n";
    }
    return historial;
  }
  
  
  /**
  * método para transferir saldo de un chip(número) a otro
  * @param 
  * @return el historial de mensajes
  */
  public String transferir(ChipPrepago chip, ChipPrepago chipTransf, double saldo){
    if(chip.saldo > saldo){
      chip.saldo -= saldo;
      chipTransf.saldo += saldo;
      return "Saldo transferido exitosamente, saldos actuales: " + chipTransf.numTelefono + ": "
         + chipTransf.saldo + "\n" + chip.numTelefono + ": " + chip.saldo;
    }
    else{
      return "Saldo insufuciente para transferir.";
    }
  }
  
  
  /**
  * método verificar que el mensaje no sobrepase los 128 caracteres
  * @param mensaje, el mensaje a ser enviado
  * @return true o false, según corresponda
  */
  public boolean tamanioMensaje(String mensaje){
    int tamanio = 0;
    tamanio = mensaje.length();
    return tamanio >= 128;
  }
  
  
  /**
  * método verificar que el mensaje no sobrepase los 128 caracteres
  * @param mensaje, el mensaje a ser enviado
  * @return true o false, según corresponda
  */
  public String enviarSMS(Mensaje mensaje, ChipPrepago chip) {
    String numeroDestino = chip.getNumTelefono();
    String mensajeEnvia = mensaje.getMensaje();
    Mensaje mensajeNuevo = new Mensaje(numeroDestino, mensajeEnvia); 
    if(chip.saldo >= 20.0){
      if (tamanioMensaje(mensajeEnvia)) {
        chip.saldo = chip.saldo - 20.0;
        mensajes[cantidadMensajes] = mensajeNuevo;
        cantidadMensajes++;
        return "Mensaje enviado con éxito";
      }
      else {
        return "El mensaje se excede los 128 caracteres";
      }
    }
    else{
      return "No cuenta con los fondos suficientes para enviar mensaje.";
    }
  }
  
  // public String mensajesRecibidos(){
     
  // }
  
  
}


