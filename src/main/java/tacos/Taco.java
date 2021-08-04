package tacos;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createdAt;

    @NotNull
    @Size(min=5, message = "Name must be at least 5 characters long")
    private String name;

    //@ManyToMany -> Taco 1 -> * Ingrediente
    //               Ingrediente 1 -> * Taco
    @ManyToMany(targetEntity = Ingredient.class)
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

    //Antes que uma entidade Taco seja colocada no banco de dados
    //Será chamada este método
    @PrePersist
    private void createdAt(){
        this.createdAt = new Date();
    }
}
