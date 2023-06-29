package model;

public class daviplataVo { 
private int IdCuenta; 
private int IdUsuario;
private int Saldo; 
 // contructores  
public daviplataVo() {
}
public daviplataVo(int idCuenta, int idUsuario, int saldo) {
    IdCuenta = idCuenta;
    IdUsuario = idUsuario;
    Saldo = saldo;
}
// getters and setters 
public int getIdCuenta() {
    return IdCuenta;
}
public void setIdCuenta(int idCuenta) {
    IdCuenta = idCuenta;
}
public int getIdUsuario() {
    return IdUsuario;
}
public void setIdUsuario(int idUsuario) {
    IdUsuario = idUsuario;
}
public int getSaldo() {
    return Saldo;
}
public void setSaldo(int saldo) {
    Saldo = saldo;
}
    
}
