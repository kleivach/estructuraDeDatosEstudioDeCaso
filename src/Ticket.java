import java.time.LocalDateTime;

public class Ticket {
    private static int cantidad = 1;

    private int id;
    private String descripcion;
    private String nombreCompleto;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaResolucion;

    public Ticket(String descripcion, String nombreCompleto) {
        this.id = cantidad++;
        this.descripcion = descripcion;
        this.nombreCompleto = nombreCompleto;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaResolucion = null;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(LocalDateTime fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaResolucion=" + fechaResolucion +
                '}';
    }
}
