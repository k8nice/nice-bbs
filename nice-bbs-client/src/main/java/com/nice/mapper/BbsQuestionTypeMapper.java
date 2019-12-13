package com.nice.mapper;

import com.nice.domain.BbsQuestionType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * bbs问题类型mapper接口
 *
 * @author nice
 */
@Mapper
public interface BbsQuestionTypeMapper {

    /**
     * 获取全部问题类型
     *
     * @return List<BbsQustionType>  存放全部问题类型的list集合
     */
    List<BbsQuestionType> queryAllQuestionTypes();

}
