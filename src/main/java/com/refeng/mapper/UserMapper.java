package com.refeng.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.refeng.model.MenuUrl;
import com.refeng.model.Role;
import com.refeng.model.User;





@Mapper
public interface UserMapper {
	@Select(" select ID as id,LOGIN_NAME as loginName,REAL_NAME as realName,PASSWORD as password , ROLE as role , LOGINTIME as loginTime from F_LOGIN_USER  where  LOGIN_NAME= #{loginName} ")
	List<User> findByName(User user);
	
	@Select("select  RUL.MENU_NAME as menuName , RUL.ID as id   from F_MENU_URL RUL " + 
			"LEFT JOIN  F_ROLE_MENU RM ON RM.MENU_ID=RUL.ID " + 
			"LEFT JOIN  F_ROLE ROLESS  ON ROLESS.ID=RM.ROLE_ID " + 
			"WHERE ROLESS.ID=#{id} AND RUL.PARENT_ID=0 " + 
			"order by RUL.weight ")
	List<MenuUrl> menuList(Integer id);
	
	@Select("select MENU_URL as menuUrl , MENU_NAME as menuName from F_MENU_URL WHERE PARENT_ID=#{id} and state= 1 order by weight ")
	List<MenuUrl> menuLists(Integer id);
	
	
	
	@Select(" select ID as id,LOGIN_NAME as loginName,REAL_NAME as realName,PASSWORD as password , ROLE as role , LOGINTIME as loginTime , DESCRIBE as describe ,PHONE as  phone ,STATE as state , EMAIL as email "
			+ "from F_LOGIN_USER  where  ID= #{id} ")
	User findById(Integer id);

	List<Role> roleList(String userName);
//	角色的列表的查询
	@Select(" select id ,name,CREATION_TIME as time,STATE as state from F_ROLE ")
	List<Role> roleList();
//	角色的权限的查询
	@Select(" select url.id as id,url.MENU_NAME as menuName from F_ROLE role " + 
			" LEFT JOIN F_ROLE_MENU f ON f.ROLE_ID=role.ID" + 
			" LEFT JOIN F_MENU_URL url ON url.ID=f.MENU_ID" + 
			" WHERE role.id=#{id} ")
	List<MenuUrl> menuUrlNmae(Integer id);
//所有的父节点
	@Select(" select id , MENU_NAME  as menuName FROM  F_MENU_URL where PARENT_ID=0 ")
	List<MenuUrl> menuUrl();
	//角色新增name  insert into TStudent(name, age) values(#{name}, #{age})
	@Insert("INSERT INTO F_ROLE (ID,NAME,CREATION_TIME,STATE) " +
			" VALUES (#{id} , #{name} , #{time} , #{state} ) ")
	Integer newsAdd(Role role);
	
//	角色的列表ID的查询
	@Select(" select  id  from F_ROLE   ORDER BY ID DESC ")
	List<Role> idList();
	
//	角色  权限的  新增
	@Insert("INSERT INTO F_ROLE_MENU (ROLE_ID,MENU_ID) " +
			" VALUES (#{rId} , #{mId} ) ")
	Integer addurl(@Param("rId")Integer rId, @Param("mId")Integer mId);
	
	
//	角色的列表ID的查询
	@Select(" select id ,name,CREATION_TIME as time,STATE as state from F_ROLE where id= #{mId} ")
	Role idRole(Integer mId);
//	角色的列表ID的查询
	@Select(" select MENU_ID as id  from F_ROLE_MENU where ROLE_ID= #{mId} ")
	List<Role> idRoles(Integer mId);
	
//	update ENTITY_RELATION SET SRC_ID=#{srcId},SRC_TYPE=#{srcType},DEST_ID=#{destId},
//	        DEST_TYPE=#{destType},REL_TYPE=#{relType},STATUS=#{status},SN_ID=#{snId}
//	 where id=#{id}
	@Update("update F_ROLE SET NAME=#{name},CREATION_TIME=#{time},STATE=#{state} WHERE id=#{id} ")
	Integer newsUpdate(Role role);
	
	@Delete(" DELETE FROM F_ROLE_MENU WHERE ROLE_ID = #{id} ")
	Integer deleteUrl(Integer id);
	
	
	
//	用户表的查询
	@Select(" select  u.ID as id, u.ESTABLISH_TIME as establishTime, u.STATE as state, u.LOGIN_NAME as loginName, u.REAL_NAME as realName ,  u.ROLE as role , LOGINTIME  as loginTime , r.name as rname ,u.PHONE as phone ,u.EMAIL as email ,u.DESCRIBE as describe from F_LOGIN_USER u LEFT JOIN F_ROLE r ON u.ROLE=r.ID  ")
	List<User> userList();
	@Select(" select  u.ID as id, u.ESTABLISH_TIME as establishTime, u.STATE as state, u.LOGIN_NAME as loginName, u.REAL_NAME as realName ,  u.ROLE as role , LOGINTIME  as loginTime , r.name as rname ,u.PHONE as phone ,u.EMAIL as email ,u.DESCRIBE as describe from F_LOGIN_USER u LEFT JOIN F_ROLE r ON u.ROLE=r.ID  where  u.REAL_NAME like  CONCAT('%',#{userName},'%')   ")
	List<User> userLists(String userName);
	
//	用户表的列表ID的查询
	@Select(" select  id  from F_LOGIN_USER   ORDER BY ID DESC ")
	List<User> iduList();
	
//	用户的新增
	@Insert("INSERT INTO F_LOGIN_USER (ID,LOGIN_NAME,REAL_NAME,PASSWORD,ROLE,STATE,LOGINTIME,PHONE,EMAIL,DESCRIBE,ESTABLISH_TIME) " +
			" VALUES (#{id} , #{loginName} , #{realName} , #{password} ,#{role} ,#{state} ,#{loginTime} ,#{phone} ,#{email} ,#{describe} ,#{establishTime} ) ")
	Integer newsUser(User user);

	//	用户的修改
	@Update("update F_LOGIN_USER SET LOGIN_NAME=#{loginName},REAL_NAME=#{realName},PASSWORD=#{password}, " +
			"ROLE=#{role},STATE=#{state},PHONE=#{phone},EMAIL=#{email},DESCRIBE=#{describe} " +
			" WHERE ID=#{id} ")
	Integer upodateUser(User user);
	//	用户的登入时间的修改
	@Update("update F_LOGIN_USER SET LOGINTIME=#{loginTime}" +
			" WHERE ID=#{id} ")
	Integer upodateTime(User user);
}