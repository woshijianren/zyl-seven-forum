package com.seven.forum.controller.zyl;

import com.seven.forum.entity.zyl.PostBarPartitionEntity;
import com.seven.forum.service.zyl.PostBarInfoService;
import com.seven.forum.service.zyl.PostBarPartitionService;
import com.seven.forum.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/api")
public class CatalogController {
    @Autowired
    private PostBarPartitionService postBarPartitionService;

    @Autowired
    private PostBarInfoService postBarInfoService;

    @GetMapping("/partitions")
    public ResponseVO listAllPartitionEntities() {
        log.trace("列出所有分区和目录");
        List<PostBarPartitionEntity> postBarPartitionEntities = postBarPartitionService.listAllPartitionsAndCatalogues();
        return new ResponseVO(200, "success", postBarPartitionEntities);
    }

    @GetMapping("/catalogues/postBars")
    public ResponseVO listPostBarsByCatalogueId(Long catalogueId, Integer pageNum, Integer pageSize) {
        log.trace("查询目录id为[" + catalogueId + "]下的[" + 20 * (pageNum - 1) + "," + 20 * pageNum + "]贴吧");
        return new ResponseVO(200, postBarInfoService.countPostBarsByCatalogueId(catalogueId) + "",
                postBarInfoService.listPostBarsByCatalogueId(catalogueId, pageNum, pageSize));
    }

    @GetMapping("/partitions/postBars")
    public ResponseVO listPostBarsByPartitionId(Long partitionId, Integer pageNum, Integer pageSize) {
        log.trace("查询分区id[" + partitionId + "]下的的[" + 20 * (pageNum - 1) + "," + 20 * pageNum + "]贴吧");
        return new ResponseVO(200, postBarInfoService.countPostBarsByPartitionId(partitionId) + "",
                postBarInfoService.listPostBarsByPartitionId(partitionId, pageNum, pageSize));
    }

    @GetMapping("/is/postBarPartition")
    public ResponseVO isExistsPartition(Long partitionId) {
        log.trace("查询分区id[" + partitionId + "]是否存在");
        Integer isExists = postBarPartitionService.isExistsPostBarPartitionByPartitionId(partitionId);
        return new ResponseVO(200, isExists + "");
    }

    @GetMapping("/is/partitionCatalogue")
    public ResponseVO isExistsCatalogue(Long catalogueId) {
        log.trace("查询目录id[" + catalogueId + "]是否存在");
        Integer isExists = postBarPartitionService.isExistsPartitionCatalogueByCatalogueId(catalogueId);
        return new ResponseVO(200, isExists + "");
    }
}

