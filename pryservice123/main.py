import json
from flask import Flask, jsonify, request, abort

# Instanciamos una aplicacion de tipo flask por medio del costructor que toma el nombre del archivo (main)
app = Flask(__name__)

# Definimso el arrego de clientes
listClients = [
    {
    "codigo":1,
    "identificacion":"0104925599",
    "nombres":"Juan Naula",
    "correo":"pruebas@yahoo.es",
    "telefono":"0986543762",
    "direccion":"Sidcay"
    },
    {
    "codigo":2,
    "identificacion":"0105935599",
    "nombres":"Jenny",
    "correo":"pruebas@yahoo.es",
    "telefono":"0986543762",
    "direccion":"Sidcay"
    },
]
# Servicio para agregar persona
@app.route('/clients', methods = ['POST'])
def addClient():
    if((request.method == 'POST') and (request.headers.get('Content-Type')=='application/json')):
        client = request.json
        listClients.append(client)
        return listClients
    else:
        abort(404,"Client no registrado")               
# Servicio para actualizar la persona
@app.route('/clients/<int:codigo>', methods = ['GET'])
def getClientCode(codigo):
    if(request.method == 'GET'):
        for client in listClients:
            if (client.get("codigo") == codigo):
                return jsonify(client)
        abort(404)
                

# Exponemos el servicio para retornar lista de personas
@app.route('/clients', methods = ['GET'])
# Definimos los servicios
def returnClients():
    if(request.method == 'GET'):
        return jsonify(listClients)

# Definimos el main como una buena practica
if __name__ == '__main__':
    # Ejecutamos la aplicacion y podemos activar el debug
    app.run(debug=True)