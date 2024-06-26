package AC.controller;

import AC.dto.AssetDTO;
import AC.service.AssetService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AssetController {

    private final AssetService assetService;

    @GetMapping("/asset")
    public ResponseEntity<AssetDTO> getAsset(
            @RequestParam("userId") Long userId,
            @RequestParam(value = "year", required = false) String year,
            @RequestParam(value = "month", required = false) String month) {

        return ResponseEntity.ok(assetService.getAsset(userId, year, month));
    }


}
