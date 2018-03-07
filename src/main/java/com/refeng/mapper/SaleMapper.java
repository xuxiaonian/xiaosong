package com.refeng.mapper;


import com.refeng.model.DailyRankings;
import com.refeng.model.SaleUser;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface SaleMapper {
    @Select(" select * FROM  C_DAILYRANKINGS WHERE SORT =#{sort} ")

    List<SaleUser> dayList(String sort);
//    @Insert("<script>"+
//            "update c_sys_user set NAME = #{name}, USERNAME = #{userName}, QQ = #{qq}, WEIXIN = #{weixin}, EMAIL = #{email} where USER_ID = #{userId}"+
//            "</script>")userId
    @Insert(" INSERT INTO c_sys_user (USER_ID_CREATE,GMT_CREATE,GMT_MODIFIED,USER_ID ,NAME, USERNAME,PASSWORD,STATUS,QQ,WEIXIN,EMAIL,LEVELS) VALUES (#{userIdCreate},#{time},#{time},#{userId}," +
            " #{name}, #{userName},#{password},1,#{qq},#{weixin},#{email},#{levels})")
    Integer newsAdd(SaleUser saleUser);
    @Select(" select USER_ID as userId FROM  c_sys_user order by USER_ID desc ")

    List<SaleUser> userId();
    @Update(" UPDATE ACT.TB_USER_INFO SET LOGO = #{url} WHERE USER_ID =#{id}")
    Integer updateInfoa(@Param("id")Integer id, @Param("url")String url);

    @Update(" UPDATE ACT.TB_USER_EXT SET HEAD_IMAGE = #{url} WHERE USER_ID =#{id}")
    Integer updateInfob(@Param("id")Integer id, @Param("url")String url);
    @Select(
            "<script>"+
            " select USER_ID as userId, NAME as name , USERNAME as userName , STATUS as count , QQ , WEIXIN , EMAIL ,LEVELS FROM  c_sys_user where 1=1  "
                    + "<if test='userName!=null '>"
                    + " and NAME like '%'||#{userName}||'%' "
                    + "</if>"
                    + "</script>" )
    List<SaleUser> roleList(@Param("userName")String userName);

    @Select(" select PASSWORD as password , USER_ID as userId, NAME as name , USERNAME as userName , STATUS as count , QQ , WEIXIN , EMAIL ,LEVELS FROM  c_sys_user  where USER_ID=#{id}")
    SaleUser useId(Integer id);

//    @Insert(" INSERT INTO c_sys_user (USER_ID_CREATE,GMT_CREATE,GMT_MODIFIED,USER_ID ,NAME, USERNAME,PASSWORD,STATUS,QQ,WEIXIN,EMAIL,LEVELS) VALUES (#{userIdCreate},#{time},#{time},#{userId}," +
//            " #{name}, #{userName},#{password},1,#{qq},#{weixin},#{email},#{levels})")
    @Update(" UPDATE c_sys_user SET GMT_MODIFIED = #{time},NAME = #{name},USERNAME = #{userName},QQ = #{qq},WEIXIN = #{weixin},EMAIL = #{email} WHERE USER_ID =#{userId}")
    Integer newsUpdate(SaleUser saleUser);
    @Select(" select  USER_ID as userId, NAME as name ,LEVELS from c_sys_user where LEVELS < 3")
    List<SaleUser> saleList();
}