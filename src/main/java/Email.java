import java.util.Date;
import javax.persistence.*;

@Entity
public class Email {
  
  @Id
  @GeneratedValue
  private Integer id;
  
  @Column
  private String destinatario;
  
  @Column
  private String corpo;
  
  @Temporal(TemporalType.TIMESTAMP)
  @Column
  private Date dataEnvio;
  
  @Column
  private Boolean confirmaLeitura;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

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

  public Boolean getConfirmaLeitura() {
    return confirmaLeitura;
  }

  public void setConfirmaLeitura(Boolean confirmaLeitura) {
    this.confirmaLeitura = confirmaLeitura;
  }
}
