package br.com.curso_udemy.product_api.modules.category.model;

import br.com.curso_udemy.product_api.modules.category.dto.CategoryRequest;
import lombok.*;
import org.springframework.beans.BeanUtils;


import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    public static Category of(CategoryRequest request) {
        var category = new Category();
        BeanUtils.copyProperties(request, category);
        return category;
    }

    public void setId(Integer id) {
    }
}