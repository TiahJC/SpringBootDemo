package com.example.demo.repository;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Asset;
// I think this is where the Query starts to be done from. 
// Trail and Error needed to be done after trying out the program.
@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
  // List<Asset> findbySerialNumber(String assets_sn);
  // List<Asset> findbyStatus(String assets_status);
}
