package com.huayu.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.entity.UniqueView;
import com.huayu.mapper.UniqueViewMapper;
import com.huayu.model.dto.UniqueViewDTO;
import com.huayu.service.UniqueViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UniqueViewServiceImpl extends ServiceImpl<UniqueViewMapper, UniqueView> implements UniqueViewService {

    @Autowired
    private UniqueViewMapper uniqueViewMapper;

    @Override
    public List<UniqueViewDTO> listUniqueViews() {
        DateTime startTime = DateUtil.beginOfDay(DateUtil.offsetDay(new Date(), -7));
        DateTime endTime = DateUtil.endOfDay(new Date());
        return uniqueViewMapper.listUniqueViews(startTime, endTime);
    }

}