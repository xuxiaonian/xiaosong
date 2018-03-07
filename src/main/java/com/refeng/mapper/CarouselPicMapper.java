package com.refeng.mapper;


import com.refeng.model.CarouselPic;
import com.refeng.model.MenuUrl;
import com.refeng.model.Role;
import com.refeng.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface CarouselPicMapper {

//	pic的查询
	@Select(" SELECT * FROM  act.TB_CAROUSEL_PIC ")
	@Results({
			 @Result(property = "id", column = "id"),
			@Result(property = "platform", column = "PLATFORM"),
			@Result(property = "title", column = "TITLE"),
			@Result(property = "picUrl", column = "PIC_URL"),
			@Result(property = "exhibitionUrl", column = "EXHIBITION_URL"),
			@Result(property = "exhibitionPosition", column = "EXHIBITION_POSITION"),
			@Result(property = "exhibitionPositionWeight", column = "EXHIBITION_POSITION_WEIGHT"),
			@Result(property = "startActivityTime", column = "START_ACTIVITYT_IME"),
			@Result(property = "endActivityTime", column = "END_ACTIVITY_TIME"),
			@Result(property = "startExhibitionTime", column = "START_EXHIBITION_TIME"),
			@Result(property = "endExhibitionTime", column = "END_EXHIBITION_TIME"),
			@Result(property = "details", column = "DETAILS"),
			@Result(property = "founder", column = "FOUNDER"),
			@Result(property = "establishTime", column = "ESTABLISHTIME"),
			@Result(property = "state", column = "STATE")
	})
	List<CarouselPic> picList();



	/*INSERT INTO act.TB_CAROUSEL_PIC (ID , PIC_URL) VALUES (act.AA.nextval, "11111");*/
//	pic的新增
	@Insert("INSERT INTO act.TB_CAROUSEL_PIC (ID , PLATFORM ,TITLE, PIC_URL,START_ACTIVITYT_IME,END_ACTIVITY_TIME,START_EXHIBITION_TIME," +
			" END_EXHIBITION_TIME,EXHIBITION_POSITION,EXHIBITION_POSITION_WEIGHT,TYPE,EXHIBITION_URL,CHANNEL,STATE,DETAILS,ESTABLISHTIME,FOUNDER) " +
			" VALUES (act.AA.nextval ,#{platform},#{title},#{picUrl},#{startActivityTime},#{endActivityTime},#{startExhibitionTime},#{endExhibitionTime},#{exhibitionPosition},#{exhibitionPositionWeight},#{type},#{exhibitionUrl},#{channel},#{state},#{details},#{establishTime},#{founder}) ")
	Integer newsPic (CarouselPic pic);

	//	pic的修改
	@Update("update act.TB_CAROUSEL_PIC SET PLATFORM=#{platform},TITLE=#{title},PIC_URL=#{picUrl}, " +
			"START_ACTIVITYT_IME=#{startActivityTime},END_ACTIVITY_TIME=#{endActivityTime},START_EXHIBITION_TIME=#{startExhibitionTime},END_EXHIBITION_TIME=#{endExhibitionTime},EXHIBITION_POSITION=#{exhibitionPosition} ," +
			"EXHIBITION_POSITION_WEIGHT=#{exhibitionPositionWeight},TYPE=#{type},EXHIBITION_URL=#{exhibitionUrl},CHANNEL=#{channel},STATE=#{state} ,DETAILS=#{details},ESTABLISHTIME=#{establishTime},FOUNDER=#{founder}" +
				" WHERE ID=#{id} ")
	/**/
	Integer upodatePic (CarouselPic pic);


	//	pic的查询
	@Select(" SELECT * FROM  act.TB_CAROUSEL_PIC where ID=#{id}")
	@Results({
			@Result(property = "id", column = "id"),
			@Result(property = "platform", column = "PLATFORM"),
			@Result(property = "title", column = "TITLE"),
			@Result(property = "picUrl", column = "PIC_URL"),
			@Result(property = "exhibitionUrl", column = "EXHIBITION_URL"),
			@Result(property = "exhibitionPosition", column = "EXHIBITION_POSITION"),
			@Result(property = "exhibitionPositionWeight", column = "EXHIBITION_POSITION_WEIGHT"),
			@Result(property = "startActivityTime", column = "START_ACTIVITYT_IME"),
			@Result(property = "endActivityTime", column = "END_ACTIVITY_TIME"),
			@Result(property = "startExhibitionTime", column = "START_EXHIBITION_TIME"),
			@Result(property = "endExhibitionTime", column = "END_EXHIBITION_TIME"),
			@Result(property = "details", column = "DETAILS"),
			@Result(property = "founder", column = "FOUNDER"),
			@Result(property = "establishTime", column = "ESTABLISHTIME"),
			@Result(property = "state", column = "STATE")
	})
	CarouselPic picById(Integer id);
}