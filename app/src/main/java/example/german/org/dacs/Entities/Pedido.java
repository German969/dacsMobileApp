package example.german.org.dacs.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by germa on 12/7/2017.
 */

public class Pedido {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("fecha")
    @Expose
    private Date fecha;

    @SerializedName("estado")
    @Expose
    private String estado;

    @SerializedName("usuario")
    @Expose
    private Usuario usuario;

    @SerializedName("productos")
    @Expose
    private List<Producto> productos;

    @SerializedName("fechaPago")
    @Expose
    private Date fechaPago;

    @SerializedName("mediodepago")
    @Expose
    private MedioDePago mediodepago;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public MedioDePago getMediodepago() {
        return mediodepago;
    }

    public void setMediodepago(MedioDePago mediodepago) {
        this.mediodepago = mediodepago;
    }
}
