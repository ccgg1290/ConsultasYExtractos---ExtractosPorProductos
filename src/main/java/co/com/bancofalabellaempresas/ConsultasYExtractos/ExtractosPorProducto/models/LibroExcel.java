package co.com.bancofalabellaempresas.ConsultasYExtractos.ExtractosPorProducto.models;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("Hoja 1")
public class LibroExcel {

    @ExcelCellName("TipoPago")
    private String tipoDePago;
    @ExcelCellName("Nro.Proceso")
    private String nroProceso;
    @ExcelCellName("fechaCreacion")
    private String fechaDeCreacion;
    @ExcelCellName("Estado")
    private String estado;
    @ExcelCellName("Descripcion")
    private String descripcion;
    @ExcelCellName("ProductoOrigen")
    private String productoOrigen;
    @ExcelCellName("ProductoDestino")
    private String productoDestino;
    @ExcelCellName("ValorPago")
    private String valorPago;

    @Override
    public String toString() {
        return "LibroExcel{" +
                "tipoDePago='" + tipoDePago + '\'' +
                ", nroProceso='" + nroProceso + '\'' +
                ", fechaDeCreacion='" + fechaDeCreacion + '\'' +
                ", estado='" + estado + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", productoOrigen='" + productoOrigen + '\'' +
                ", productoDestino='" + productoDestino + '\'' +
                ", valorPago='" + valorPago + '\'' +
                '}';
    }

    public LibroExcel() {
    }


    public LibroExcel(String tipoDePago, String nroProceso, String fechaDeCreacion, String estado, String descripcion, String productoOrigen, String productoDestino, String valorPago) {
        this.tipoDePago = tipoDePago;
        this.nroProceso = nroProceso;
        this.fechaDeCreacion = fechaDeCreacion;
        this.estado = estado;
        this.descripcion = descripcion;
        this.productoOrigen = productoOrigen;
        this.productoDestino = productoDestino;
        this.valorPago = valorPago;
    }

    public String getTipoDePago() {
        return tipoDePago;
    }

    public void setTipoDePago(String tipoDePago) {
        this.tipoDePago = tipoDePago;
    }

    public String getNroProceso() {
        return nroProceso;
    }

    public void setNroProceso(String nroProceso) {
        this.nroProceso = nroProceso;
    }

    public String getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(String fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProductoOrigen() {
        return productoOrigen;
    }

    public void setProductoOrigen(String productoOrigen) {
        this.productoOrigen = productoOrigen;
    }

    public String getProductoDestino() {
        return productoDestino;
    }

    public void setProductoDestino(String productoDestino) {
        this.productoDestino = productoDestino;
    }

    public String getValorPago() {
        return valorPago;
    }

    public void setValorPago(String valorPago) {
        this.valorPago = valorPago;
    }
}
