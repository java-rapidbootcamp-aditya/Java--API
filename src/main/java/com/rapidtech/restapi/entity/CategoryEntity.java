package com.rapidtech.restapi.entity;


import com.rapidtech.restapi.model.CategoryModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "product_category")

public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    @Column (name = "category_code", length = 20, nullable = false)

    private String code;

    @Column (name = "category_name", length = 100, nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<ProductEntity> products = new HashSet<>();

    public CategoryEntity(CategoryModel model) {
        BeanUtils.copyProperties(model, this);
    }
}
