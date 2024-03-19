
using Microsoft.AspNetCore.Mvc;

namespace netmicro.Controllers;

[ApiController]
[Route("[controller]")]
public class ClientController : ControllerBase
{

    // Definimos una lista de tipo Client con los que inicializa la interfaz
    static List<Client> listClients = new List<Client>(){
        new Client(1,"0104925599","Juan Gabriel", "pruebas@yahoo.es","0985642381","San Vicente")
    };
    // Implementacion de loggers
    private readonly ILogger<ClientController> _logger;

    public ClientController(ILogger<ClientController> logger)
    {
        _logger = logger;
    }

    // implementamos metodos para obtener los clientes
    // Definimos como se ebe consumit un metodo 
    [HttpGet(Name = "GetClients")]
    public IEnumerable<Client> Get()
    {
        return listClients.ToArray();
    }
    // Add Client
    [HttpPost(Name = "AddClients")]
    public String Post(Client clientA)
    {
        listClients.Add(clientA);
        return "Cliente Registrado con exito.";
    }

}