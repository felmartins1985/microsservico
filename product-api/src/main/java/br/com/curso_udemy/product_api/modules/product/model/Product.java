package br.com.curso_udemy.product_api.modules.product.model;
import br.com.curso_udemy.product_api.modules.category.model.Category;
import br.com.curso_udemy.product_api.modules.product.dto.ProductRequest;
import br.com.curso_udemy.product_api.modules.supplier.model.Supplier;
import lombok.*;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name="PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer id;
    @Column(name="NAME", nullable=false)
    private String name;
    @ManyToOne
    @JoinColumn(name="FK_SUPPLIER", nullable=false)
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name="FK_CATEGORY", nullable=false)
    private Category category;

    @Column(name="QUANTITY_AVAILABLE", nullable = false)
    private Integer quantityAvailable;

    @Column(name="CREATED_AT", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public  void prePersis(){
        createdAt = LocalDateTime.now();
    }
    public Integer getId(){
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }

    public String getName() {
        return name;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public static Product of(ProductRequest request, Supplier supplier, Category category){
        return Product
                .builder()
                .name(request.getName())
                .quantityAvailable(request.getQuantityAvailable())
                .supplier(supplier)
                .category(category)
                .build();
    }

    public void setId(Integer id) {

    }
}
