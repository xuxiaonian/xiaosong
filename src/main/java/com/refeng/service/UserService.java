package com.refeng.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.refeng.mapper.UserMapper;
import com.refeng.model.MenuUrl;
import com.refeng.model.Role;
import com.refeng.model.User;
import com.refeng.pojo.MenuUrlList;
import com.refeng.util.EdsUtil;



@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 查询用户列表信息;
     * @return
     */
    public List<User> findByName(User admin){
        List<User> userList = userMapper.findByName(admin);
        return userList;
    }
    
    
    
    /**
     * 菜单列表信息;
     * @return
     */
    public List<MenuUrlList> menuList(Integer id){
    	List<MenuUrlList> menuList=new ArrayList<MenuUrlList>();
//       获取父菜单
    	List<MenuUrl> parentMenu = userMapper.menuList(id);
        for(MenuUrl dis:parentMenu){
//        子菜单
        	List<MenuUrl> menu =userMapper.menuLists(dis.getId());
        	MenuUrlList show=new MenuUrlList();
        	show.setMenuName(dis.getMenuName());
        	show.setMenuUrl(dis.getMenuUrl());
        	show.setParentId(dis.getParentId());
        	show.setMenuUrlList(menu);
        	menuList.add(show);
        }
        logger.error(menuList.toString());
        return menuList;
    }
    
    
    
    /**
     * 查询用户;
     * @return
     */
    public User findById(Integer id){
        User user = userMapper.findById(id);
        return user;
    }
    
    /**
     * 查询角色列表;
     * @return
     */
    public List<Role>  roleList(String userName){
    	List<Role>  roleList =new ArrayList<Role>();
    	
//          roleList = userMapper.roleList(userName);
    	if(userName!=null && !userName.isEmpty() ) {
    		 roleList = userMapper.roleList(userName);
    	}else {
    		 roleList = userMapper.roleList();
    		}
    	 
    	  for(Role role:roleList) {
    		  List<MenuUrl>  list = userMapper.menuUrlNmae(role.getId());
    		  String name="";
    		  if(list.get(0)!=null) {
    			  for(MenuUrl url:list) {
        			  name=name+url.getMenuName()+"    ";
        		  }
    		  }
    		
    		  role.setPowerUrl(name);
      	}
        return roleList;
    }
    
//    角色新增的时候获取所有的父节点
    public List<MenuUrl>  MenuUrl(){
		return userMapper.menuUrl();
    	
    }


       
    //角色新增
	public Integer newsAdd(Role role) {
		// TODO Auto-generated method stub
		Integer add=0;
		if(role.getId()!=null) {
			role.setTime(new Date());
			add=userMapper.newsUpdate(role);
			if(add==1) {
				add=userMapper.deleteUrl(role.getId());
				String url=role.getPowerUrl();
				if(!url.isEmpty()){
					String[] parts = url.split(",");
					for(String p:parts) {
						Integer addurl=userMapper.addurl(role.getId(),Integer.parseInt(p));	
					}	
				}
			}
		}else {
			List<Role> lisr=userMapper.idList();
			role.setTime(new Date());
			role.setId(lisr.get(0).getId()+1);
			 add=userMapper.newsAdd(role);
			if(add==1) {
				String url=role.getPowerUrl();
				if(!url.isEmpty()){
					String[] parts = url.split(",");
					for(String p:parts) {
						Integer addurl=userMapper.addurl(lisr.get(0).getId()+1,Integer.parseInt(p));	
					}	
				}
			
			}
			}
		
		
		return add;
	}
	
	
//	角色的查询
	public Role idRole(Integer id) {
		Role roles=userMapper.idRole(id);
		List<Role>ss=userMapper.idRoles(id);
		String url="";
		for(Role sd:ss) {
			url=url+sd.getId()+",";
		}
		if(!url.isEmpty()) {
			url.substring(0,url.length()-1);
		}
		roles.setPowerUrl(url);
		return roles;
		
	}
	
	
	/**
     * 查询用户列表;
     * @return
     */
    public List<User>  userList(String userName){
    	List<User>  roleList =new ArrayList<User>();

    	if(userName!=null && !userName.isEmpty() ) {
    		 roleList = userMapper.userLists(userName);
    	}else {
    		 roleList = userMapper.userList();
    		}
    	 
        return roleList;
    }
    
    
    //角色新增
 	public Integer userAdd(User user) {
 		// TODO Auto-generated method stub
 		Integer add=0;
 		if(user.getId()!=null) {
			String pass=EdsUtil.encryptBasedDes(user.getPassword());
			user.setPassword(pass);
			add=userMapper.upodateUser(user);
 		}else {
 			List<User> lisr=userMapper.iduList();
 			user.setLoginTime(new Date());
 			user.setEstablishTime(new Date());
 			user.setId(lisr.get(0).getId()+1);
 			String pass=EdsUtil.encryptBasedDes(user.getPassword());
 			user.setPassword(pass);
 			 add=userMapper.newsUser(user);
 			
 			}
 		
 		
 		return add;
 	}
	//用户登入时间的修改
	public Integer updateTime(Integer id) {
		// TODO Auto-generated method stub
		Integer add=0;
		User user =new User();
		user.setId(id);
		user.setLoginTime(new Date());
		add=userMapper.upodateTime(user);
		return add;
	}


}