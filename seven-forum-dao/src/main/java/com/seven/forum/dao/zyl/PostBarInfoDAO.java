package com.seven.forum.dao.zyl;

import com.seven.forum.entity.zyl.PostBarInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface PostBarInfoDAO {

    List<Integer> listPopularPostBarIds();

    List<PostBarInfoEntity> listPopularPostBars(Set<Integer> postBarId);

    List<PostBarInfoEntity> listPostBarsByCatalogueId(Long catalogueId, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    Integer countPostBarsByCatalogueId(Long catalogueId);

    PostBarInfoEntity getPostBarById(Long postBarId);

    List<PostBarInfoEntity> listPostBarsByPartitionId(Long partitionId, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    Integer countPostBarsByPartitionId(Long partitionId);

    // ----


    Integer ifExist(String postBarName);

    void updateExplainById(String postBarExplain, Long postBarId);

    void updateLogo(String logoUrl, Long postBarId);

    void updateCatalogue(Long catalogueId, Long postBarId);

    void updateUserId(Long userId, Long postBarId);

    void addPostCount(Long postBarId);

    void addUserCount(Long postBarId);

    void reducePostCount(Long postBarId);

    void reduceUserCount(Long postBarId);

    void reducePostBar(Long postBarId);

    void insertPostBarInfo(PostBarInfoEntity postBarInfoEntity);
}
