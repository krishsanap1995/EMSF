package com.EMS.repositries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EMS.models.Project;

public interface ProjectRepositry extends JpaRepository<Project, Integer> {

}
