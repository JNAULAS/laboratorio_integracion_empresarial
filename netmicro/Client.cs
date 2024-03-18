public class Client
{
    public Client(String identificacion, String nombres, String correo, String telefono, String direccion){
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    public String identificacion {get; set;}
    public String nombres {get; set;}
    public String correo {get; set;}
    public String telefono  {get; set;}
    public String direccion {get; set;}
}

