package br.ufsm.csi.pp.exercicio7;

import lombok.Builder;

import java.util.Date;
import java.util.List;

@Builder
public class ClasseExemplo {

    private String str;
    private List<List<String>> lista;
    private Long id;
    private int numero;
    private Date data;
    private Boolean ativo;
    private List<Integer> numeros;
    private InnerObject pessoa;

    @JSON
    public InnerObject getPessoa() {
        return pessoa;
    }

    public void setPessoa(InnerObject pessoa) {
        this.pessoa = pessoa;
    }

    @JSON
    public List<Integer> getNumeros() {
        return numeros;
    }

    public void setNumeros(List<Integer> numeros) {
        this.numeros = numeros;
    }

    @JSON
    public List<List<String>> getLista() {
        return lista;
    }

    public void setLista(List<List<String>> lista) {
        this.lista = lista;
    }

    @JSON
    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @JSON
    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @JSON
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JSON
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @JSON(formato = "dd 'de' MMMMMMMM 'de' yyyy 'às' HH:mm:ss")
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Builder
    public static class InnerObject {
        private String nome;
        private Long id;

        @JSON
        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        @JSON
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }
}
