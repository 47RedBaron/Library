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
@Table(name = "AUTHORS")
public class Authors implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column (name = "ID")//pas obligatoire si le nom de table correspond au nom de la variable
    private Long id;
    @Column (name = "NAME")
    private String name;
    @Column (name = "LASTNAME")
    private String lastName;
    @Column (name = "YEAROFBIRTH")
    private Double yearOfBirth;

}
