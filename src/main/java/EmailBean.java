import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EmailBean implements Serializable {

    private String destinatario;
    private String corpo;
    private Date dataEnvio;
    private boolean confirmaLeitura;

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public boolean isConfirmaLeitura() {
        return confirmaLeitura;
    }

    public void setConfirmaLeitura(boolean confirmaLeitura) {
        this.confirmaLeitura = confirmaLeitura;
    }
    public void setEmailSelecionado(Email emailSelecionado) {
        this.emailSelecionado = emailSelecionado;
    }

    public void enviar() {
    
    }
    private Email emailSelecionado;

    public Email getEmailSelecionado() {
        return emailSelecionado;
    }  
    public void ConfirmarLeitura(){
        this.confirmaLeitura = true;
    }
    public void ExcluirEmail(){
        emailSelecionado = null;
    }
    public void VisualizarEmail(){
        System.out.println("Corpo do email: "+emailSelecionado.getCorpo());
    }
    public void ContarEmails(){
        List<Email> emails = new ArrayList<Email>();
        int contador = emails.size();
        System.out.println("Quantidade de emails: "+contador);
    }
}