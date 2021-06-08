package net.skhu.repository;



import net.skhu.entity.Comm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommRepository extends JpaRepository<Comm, Integer> {

    List<Comm> findAllByPostidx(int postidx);

}
