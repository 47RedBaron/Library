package fr.leansys.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "BOOKS")
@PersistenceContext
public class Books implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column (name = "ID")
    private Long id;
    @ManyToOne
    @JoinColumn (name = "AUTHORID")
    private Authors author;
    @Column (name = "TITLE")
    private String title;
    @Column (name = "DESCRIPTION")
    private String description;
    @Column (name = "PRICE")
    private Double price;


}
