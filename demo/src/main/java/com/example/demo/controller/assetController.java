package com.example.demo.controller;

import java.util.List;

// import org.apache.commons.lang3.time.DateUtils;
// import java.time.LocalDate;
// import java.time.ZoneId;
// import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Asset;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.exception.ResourceNotFoundException;

@CrossOrigin(origins="http://localhost:8081")
@RestController
@RequestMapping("/api")


public class assetController {
  @Autowired
  private AssetRepository assetRepository;
  @Autowired
	private UserRepository userRepository;
  // @GetMapping("/assets")
  // public ResponseEntity<List<Asset>> getAllAssets(@RequestParam(required = false) String assets_sn){
  //   try {
  //     List<Asset> assets = new ArrayList<Asset>();
  //     if(asset_sn==null)
  //       assetRepository.findAll().forEach(assets::add);
  //   } catch (Exception e) {
  //     // TODO: handle exception
  //   }
 
  // }

  @GetMapping("/assets")
	public List<Asset> getAllAssets(){
		return assetRepository.findAll();
	}
	
	@PostMapping("/assetspost/{userid}")
	public ResponseEntity<Asset> createAsset(@PathVariable (value = "userid") Long UserId, @RequestBody Asset assetreq){
		Asset asset = userRepository.findById(UserId).map(employee -> {
			assetreq.setEmployee(employee);
			return assetRepository.save(assetreq);
		}).orElseThrow(()-> new ResourceNotFoundException("not found with user id" + UserId));
		return ResponseEntity.ok(asset);
	}

	@GetMapping("/assets/{id}")
	public ResponseEntity<Asset> getAssetbySN(@PathVariable Long id){
		Asset asset = assetRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("asset not exist with id"+ id));
		return ResponseEntity.ok(asset);
	}

	@PutMapping("/assets/{id}")
	public ResponseEntity<Asset> updateAsset(@PathVariable Long id, @RequestBody Asset assetDetails){
		Asset asset = assetRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

				// LocalDate localtoday = LocalDate.now();
        // Date today = java.util.Date.from(localtoday.atStartOfDay()
        //         .atZone(ZoneId.systemDefault())
        //         .toInstant());
								
				asset.setDescription(assetDetails.getDescription());
				asset.setHandoverDate(assetDetails.getHandoverDate());
				asset.setSerialNumber(assetDetails.getSerialNumber());
				asset.setCreateDate(assetDetails.getCreateDate());
				asset.setStatus(assetDetails.getStatus());
		
		Asset updatedAsset = assetRepository.save(asset);
		return ResponseEntity.ok(updatedAsset);
	}


}