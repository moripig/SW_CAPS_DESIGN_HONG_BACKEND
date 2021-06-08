package net.skhu.repository;

import net.skhu.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    //Location findByLoc_idx(int idx);
//    Location findByLoc_idx(@Param("loc_idx") int loc_inx);
    Location findByIdx(int idx);

}