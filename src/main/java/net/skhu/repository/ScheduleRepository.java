package net.skhu.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {


}
