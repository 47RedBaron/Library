package fr.leansys.dto;


import lombok.Data;
import java.io.Serializable;

@Data
public class BookDto implements Serializable {

    private Long id;

    private Long authorId;

    private String title;

    private String description;

    private Double price;
}
