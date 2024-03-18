public class Client
{
    public Client(String identificacion, String nombres, String correo, String telefono, String direccion){
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    private String identificacion {get; set;}
    private String nombres {get; set;}
    private String correo {get; set;}
    private String telefono  {get; set;}
    private String direccion {get; set;}
}

