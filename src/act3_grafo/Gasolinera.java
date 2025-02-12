package act3_grafo;


public class Gasolinera implements NodoGrafo {
    String clave;
    String rotulo;
    String direccion;
    String municipio;
    String localidad;

    public Gasolinera(String clave, String rotulo, String direccion, String municipio, String localidad) {
        this.clave = clave;
        this.rotulo = rotulo;
        this.direccion = direccion;
        this.municipio = municipio;
        this.localidad = localidad;
    }

    @Override
    public String getClave() {
        return clave;
    }
}
