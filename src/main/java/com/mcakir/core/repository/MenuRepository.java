package com.mcakir.core.repository;

import com.mcakir.core.base.repository.BaseRepository;
import com.mcakir.core.model.Menu;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends BaseRepository<Menu>, JpaSpecificationExecutor<Menu> {

    @Query("SELECT p FROM Menu p WHERE p.parent.id = ?1")
    public List<Menu> findAllByParentId(long parentId);

    @Query("SELECT p FROM Menu p WHERE p.parent is NULL order by p.displayOrder asc")
    public List<Menu> findAllParents();

}
