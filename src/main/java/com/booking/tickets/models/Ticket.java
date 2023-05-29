package com.booking.tickets.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;
import java.util.Date;

@Entity
public class Ticket {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long IdTicket;

    @NotNull
    //@Size (min=3,max=20)
    private String NomTicket;

    @NotNull
    //@Size (min=10,max=500)
    private String DescriptionTicket;


    //@Min(10)
    //@Max(1000)
    private double PrixTicket;
    //@Min(10)
    //@Max(1000)
    private int NombreTicket;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    //@PastOrPresent
    private Date Eventdate;


    @ManyToOne
    private Categorie categorie;


    public Ticket() {
        super();
    }
    public Ticket(String nomTicket, String descriptionTicket, double prixTicket, int nombreTicket,Date eventdate ) {
        NomTicket = nomTicket;
        DescriptionTicket = descriptionTicket;
        PrixTicket = prixTicket;
        NombreTicket = nombreTicket;
        Eventdate=eventdate;
    }



    @Override
    public String toString() {
        return "Ticket{" +
                "IdTicket=" + IdTicket +
                ", NomTicket='" + NomTicket + '\'' +
                ", DescriptionTicket='" + DescriptionTicket + '\'' +
                ", PrixTicket=" + PrixTicket +
                ", NombreTicket=" + NombreTicket +
                ", Eventdate=" + Eventdate +
                '}';
    }

    public long getIdTicket() {
        return IdTicket;
    }

    public void setIdTicket(long idTicket) {
        IdTicket = idTicket;
    }

    public String getNomTicket() {
        return NomTicket;
    }

    public void setNomTicket(String nomTicket) {
        NomTicket = nomTicket;
    }

    public String getDescriptionTicket() {
        return DescriptionTicket;
    }

    public void setDescriptionTicket(String descriptionTicket) {
        DescriptionTicket = descriptionTicket;
    }

    public double getPrixTicket() {
        return PrixTicket;
    }

    public void setPrixTicket(double prixTicket) {

        PrixTicket = prixTicket;
    }

    public int getNombreTicket() {
        return NombreTicket;
    }

    public void setNombreTicket(int nombreTicket) {
        NombreTicket = nombreTicket;
    }


    public Date getEventdate() {
        return Eventdate;
    }

    public void setEventdate(Date eventdate) {
        Eventdate = eventdate;
    }


}
