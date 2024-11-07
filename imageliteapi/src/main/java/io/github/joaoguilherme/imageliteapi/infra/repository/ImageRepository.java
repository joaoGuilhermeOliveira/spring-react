package io.github.joaoguilherme.imageliteapi.infra.repository;

import io.github.joaoguilherme.imageliteapi.domain.entity.Image;
import io.github.joaoguilherme.imageliteapi.domain.enums.ImageExtension;
import io.github.joaoguilherme.imageliteapi.infra.repository.specs.GenericSpecs;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static io.github.joaoguilherme.imageliteapi.infra.repository.specs.GenericSpecs.*;
import static io.github.joaoguilherme.imageliteapi.infra.repository.specs.ImageSpecs.*;
import static org.springframework.data.jpa.domain.Specification.anyOf;

@Repository
public interface ImageRepository extends JpaRepository<Image, String>, JpaSpecificationExecutor<Image> {


    default List<Image> findByExtensionAndNameOrTagsLike(ImageExtension extension, String query) {


        Specification<Image> spec = Specification.where(conjunction());

        if (extension != null) {
            spec = spec.and(extensionEqual(extension));
        }
        if (StringUtils.hasText(query)) {

            spec = spec.and(anyOf(nameLike(query), tagsLike(query)));
        }
        return findAll(spec);
    }
}
