package com.lqw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lqw.domain.book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface bookdao extends BaseMapper<book> {
}
