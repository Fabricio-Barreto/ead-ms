package com.ead.course.repositories;

import com.ead.course.models.ModuleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;
import java.util.List;

public interface ModuleRepository extends JpaRepository<ModuleModel, UUID> {
    /*
    @EntityGraph(attributePaths = {"course"})
    ModuleModel findByTitle(String title);
    Esse mapeamento faz o comportamento dessa consulta ser igual a um fetchType.EAGER com isso ela traz todos os dados e subdados de modulo.
    */

    @Query(value = "select * from tb_modules where course_course_id = :courseId", nativeQuery = true)
    List<ModuleModel> findAllModulesIntoCourse(@Param("courseId") UUID courseId);
}
