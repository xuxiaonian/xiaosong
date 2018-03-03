//package com.refeng.controller;
//
//import com.refeng.model.MenuUrl;
//import com.refeng.model.Role;
//import com.refeng.model.User;
//import com.refeng.pojo.MenuUrlList;
//import com.refeng.service.LotteryUserService;
//import com.refeng.service.UserService;
//import com.refeng.util.StringTools;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//
//@Controller
//public class SaleController {
//
//
//	@Autowired
//	private UserService userService;
//	@Autowired
//	private LotteryUserService lotteryUserService;
//
//	/**
//	 * 销售的展示
//	 * @return
//	 */
//	@RequestMapping("/admin/sale/list")
//    public String roleList( String userName, Model model,HttpServletRequest request)   {
//
//
//		List<Role>  roleList =userService.roleList(userName);
//		model.addAttribute("roleList",roleList);
//		model.addAttribute("userName",userName);
//		return "user/roleList";
//	}
//	/**
//	 * 销售的新增
//	 * @return
//	 */
//
//	@RequestMapping("/admin/sale/add")
//    public String newsEdit( String userName, Model model,HttpServletRequest request)   {
//
//
//
////
////		Role role=new Role();
////
////		List<MenuUrl>  urlList =userService.MenuUrl();
////		model.addAttribute("urlList",urlList);
////		role.setState(1);
////		model.addAttribute("role",role);
//		return "user/newsEdit";
//	}
//	/**
//	 * 销售的新增的保存
//	 * @return
//	 */
//
//	@RequestMapping("/admin/power/newsAdd")
//    public void newsAdd( Role role, HttpServletResponse response)   {
//		Integer  stare =userService.newsAdd(role);
//		try {
//			response.sendRedirect("/admin/power/roleList");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//
//	}
//
//	/**
//	 * 销售的修改
//	 * @return
//	 */
//
//	@RequestMapping("/admin/power/update")
//    public String update( Integer rId, Model model,HttpServletRequest request)   {
//
//
//
////
////		Role role=userService.idRole(rId);
////
////		List<MenuUrl>  urlList =userService.MenuUrl();
////		model.addAttribute("urlList",urlList);
////		role.setState(1);
////		model.addAttribute("role",role);
//		return "user/newsEdit";
//	}
//
//
//
//
//
//
//	/**
//	 * 用户的基本信息的展示
//	 * @param model
//	 * @return
//	 */
//	@GetMapping("/admin/power/userList")
//	public String byUserId(String userName,Model model,Integer userId, HttpServletRequest request) {
//
////
////		List<User>  userList =userService.userList(userName);
////		model.addAttribute("userList",userList);
////		model.addAttribute("userName",userName);
//		return "user/userList";
//	}
//
//
//	/**
//	 * 用户的新增   页面
//	 * @return
//	 */
//
//	@RequestMapping("/admin/power/newsUser")
//    public String newsUser(  Model model,HttpServletRequest request)   {
//
//
//
////		User role=new User();
////
////
////		List<Role>  roleList=userService.roleList(null);
////		role.setState(1);
////		model.addAttribute("role",role);
////		model.addAttribute("roleList",roleList);
//		return "user/newsUser";
//	}
//
//}
