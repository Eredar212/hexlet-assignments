package exercise.specification;

import exercise.dto.ProductParamsDTO;
import exercise.model.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

// BEGIN
@Component
public class ProductSpecification {
    public Specification<Product> build(ProductParamsDTO params) {
        return withCategoryId(params.getCategoryId())
                .and(withPriceGt(params.getPriceGt()))
                .and(withPriceLt(params.getPriceLt()))
                .and(withRatingGt(params.getRatingGt()))
                .and(withTitleCont(params.getTitleCont()));
    }

    public Specification<Product> withCategoryId(Long id) {
        return ((root, query, criteriaBuilder) -> id == null
                ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("category").get("id"), id));
    }

    public Specification<Product> withPriceLt(Integer price) {
        return ((root, query, criteriaBuilder) -> price == null ? criteriaBuilder.conjunction()
                : criteriaBuilder.lessThan(root.get("price"), price));
    }

    public Specification<Product> withPriceGt(Integer price) {
        return ((root, query, criteriaBuilder) -> price == null ? criteriaBuilder.conjunction()
                : criteriaBuilder.greaterThan(root.get("price"), price));
    }

    public Specification<Product> withRatingGt(Double rating) {
        return ((root, query, criteriaBuilder) -> rating == null ? criteriaBuilder.conjunction()
                : criteriaBuilder.greaterThan(root.get("rating"), rating));
    }

    public Specification<Product> withTitleCont(String title) {
        return ((root, query, criteriaBuilder) -> title == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), title.toLowerCase()));
    }
}
// END
