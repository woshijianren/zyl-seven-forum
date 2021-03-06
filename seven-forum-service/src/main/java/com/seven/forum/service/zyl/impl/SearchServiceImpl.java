package com.seven.forum.service.zyl.impl;

import com.seven.forum.dao.zyl.PostBarInfoRepository;
import com.seven.forum.entity.zyl.PostBarInfoEntity;
import com.seven.forum.entity.zyl.PostInfoEntity;
import com.seven.forum.service.zyl.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private PostBarInfoRepository postBarInfoRepository;

    @Override
    public List<PostBarInfoEntity> queryPostBarNameByKey(String postBarName) {
        return postBarInfoRepository.queryByPostBarNameContains(postBarName);
    }

}
