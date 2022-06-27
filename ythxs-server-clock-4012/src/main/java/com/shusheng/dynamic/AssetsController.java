package com.shusheng.dynamic;

import cn.hutool.core.date.DateUtil;
import com.shusheng.mapper.AssetsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘闯
 * @date 2021/8/13.
 */
@RestController
public class AssetsController {

    @Autowired
    AssetsMapper am;

    @GetMapping("/insertAssets")
    public void insertAssets(){
        PhysicalAssetsEntity pa = new PhysicalAssetsEntity();
        pa.setSubsId("");
        pa.setEquipId("a66467fb89244395945f0e994387963b");
        pa.setEquipNo("");
        pa.setEquipName("");
        pa.setOrgId("1");
        pa.setAssSource("002");
        pa.setRunData(DateUtil.date());
        pa.setRepairOrgId("1");
        pa.setRunOrgId("1");
        pa.setStoreLocation("1");
        pa.setEquipOwner("1");
        pa.setTableName("LSPMS_ARCH_HWG");
        pa.setEquipFieldId("HWG_ID");

        int i = am.updateAssets(pa);

    }
}
