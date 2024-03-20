# Utiliza la imagen base de .NET Core 7
FROM mcr.microsoft.com/dotnet/sdk:7.0 AS build
WORKDIR /netmicro

# Copia los archivos del proyecto y restaura las dependencias
COPY *.csproj .
RUN dotnet restore

# Copia el resto del código y compila la aplicación
COPY . .
RUN dotnet publish -c Release -o out

# Genera una imagen final ligera con el artefacto compilado
FROM mcr.microsoft.com/dotnet/aspnet:7.0 AS runtime
WORKDIR /netmicro
COPY --from=build /netmicro/out .
EXPOSE 80
ENTRYPOINT ["dotnet", "netmicro.dll"]