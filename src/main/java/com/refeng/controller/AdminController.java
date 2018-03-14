package com.refeng.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.refeng.util.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.refeng.model.User;
import com.refeng.pojo.MenuUrlList;
import com.refeng.service.UserService;




@Controller
public class AdminController {

	@Autowired
	private UserService userService;

	/**
	 * 登录跳转
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/admin/login")
	public String loginGet(Model model) {
		return "login";
	}

	/**
	 * 登录
	 * 
	 * @param admin
	 * @param model
	 * @param httpSession
	 * @return
	 */
	@PostMapping("/admin/index")
	public String loginPost(User admin, Model model, HttpSession httpSession) {
		List<User> userList = userService.findByName(admin);
	
    	if(userList==null || userList.isEmpty()){
    		model.addAttribute("error", "用户名不存在，请重新登录！");
			return "login";

    	}else if(! userList.get(0).getPassword().equals(StringTools.MD5EncodeToHex(admin.getPassword()))){
    		model.addAttribute("error", "密码错误，请重新输入密码！");
			return "login";
    	}else {

    		httpSession.setAttribute("uesr", userList.get(0));
			httpSession.setAttribute("admin", userList.get(0).getId());
			httpSession.setAttribute("realName", userList.get(0).getRealName());
    		List<MenuUrlList> menuList=userService.menuList(userList.get(0).getRole());
			httpSession.setAttribute("menuList", menuList);
    		model.addAttribute("user",userList.get(0));
			userService.updateTime(userList.get(0).getId());

    		return "dashboard";
    	}
	}

	/**
	 * 首页
	 * 

	 * @param model

	 * @return
	 */
	@GetMapping("/admin/indexs")
	public String login(Model model, HttpServletRequest request) {
		if(request.getSession().getAttribute("admin")==null) {
			return "login";
		}
		String user=request.getSession().getAttribute("admin").toString();
		 Integer id=Integer.parseInt(user);
		 User users= userService.findById(id);
		List<MenuUrlList> menuList=userService.menuList(users.getRole());
		model.addAttribute("menuList",menuList);
		model.addAttribute("user",users);
	
    		return "dashboard";
    	}
	/**	 * 注册
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/admin/loginOut")
	public String register(Model model,HttpSession httpSession) {
		httpSession.setAttribute("admin", null);
		return "login";
	}
}
