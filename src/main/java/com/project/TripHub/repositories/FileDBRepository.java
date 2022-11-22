package com.project.TripHub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.TripHub.models.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
	
//	List <FileDB> findAll();
}