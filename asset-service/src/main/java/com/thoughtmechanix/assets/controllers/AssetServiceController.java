package com.thoughtmechanix.assets.controllers;

import com.thoughtmechanix.assets.config.ServiceConfig;
import com.thoughtmechanix.assets.model.Asset;
import com.thoughtmechanix.assets.services.AssetService;
import com.thoughtmechanix.assets.utils.UserContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value="/v1/organizations/{organizationId}/assets")
public class AssetServiceController {
    private static final Logger logger = LoggerFactory.getLogger(AssetServiceController.class);

    @Autowired
    private AssetService assetService;

    @Autowired
    private ServiceConfig serviceConfig;

    @Autowired
    private HttpServletRequest request;

    /**
     * GET all assets from an Organization
     * @param organizationId the Organization to get Assets of
     * @return ResponseEntity of Assets as JSON
     */
    @RequestMapping(value="/",method = RequestMethod.GET)
    public List<Asset> getAssets(@PathVariable("organizationId") String organizationId) {
        return assetService.getAssetsByOrg(organizationId);
    }

    /**
     * GET an Asset from an Organization by id
     * @param organizationId
     * @param assetId
     * @return ResponseEntity with Asset as JSON
     */
    @RequestMapping(value="/{assetId}",method = RequestMethod.GET)
    public Asset getAsset(@PathVariable("organizationId") String organizationId,
                                      @PathVariable("assetId") String assetId) throws InterruptedException {

        return assetService.getAsset(organizationId, assetId);
    }

    /**
     * PUT mapping that updates an Asset with newAsset
     * @param newAsset
     * @param assetId
     * @return ResponseEntity
     */
    @PutMapping(value="/{assetId}")
    public ResponseEntity<?> updateAsset(@RequestBody Asset newAsset, @PathVariable("assetId") String assetId) {
        return new ResponseEntity<>(assetService.updateAsset(newAsset), HttpStatus.OK);
    }

    /**
     * POST method creating a new Asset with given params
     * @param asset
     * @return ResponseEntity confirming POST
     */
    @PostMapping(value="/")
    public ResponseEntity<?> saveAsset(@RequestBody Asset asset) {
        return new ResponseEntity<>(assetService.saveAsset(asset), HttpStatus.CREATED);
    }

    /**
     * DELETE method that deletes an Asset by ID
     * @param assetId
     * @return ResponseEntity
     */
    @DeleteMapping(value="/{assetId}")
    public ResponseEntity<?> deleteAsset( @PathVariable("assetId") String assetId) {
        assetService.deleteAsset(assetId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
