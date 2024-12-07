package Model;

import java.util.Date;
import java.util.List;

public class Pedido {
    private int id;
    private Usuario usuario;
    private List<Produto> listaProdutos;
    private Date data;
    private String status;

    public Pedido(int id, Usuario usuario, List<Produto> listaProdutos, Date data, String status) {
        this.id = id;
        this.usuario = usuario;
        this.listaProdutos = listaProdutos;
        this.data = data;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pedido ID: " + id + ", Usuário: " + usuario.getNome() + ", Data: " + data + ", Status: " + status;
    }
}