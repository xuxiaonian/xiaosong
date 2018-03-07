package com.refeng.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.refeng.model.CarouselPic;

import com.refeng.model.User;
import com.refeng.pojo.MenuUrlList;
import com.refeng.service.CarouselPicService;
import com.refeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class CarouselPicController {


	@Autowired
	private UserService userService;
	@Autowired
	private CarouselPicService carouselPicService;

	/**
	 * 轮播图的展示
	 * @return
	 */
	@RequestMapping("/admin/carouselPic/list")
    public String roleList( Model model, String  pageIndex ,HttpServletRequest request)   {

		List<CarouselPic> picList=carouselPicService.picList();

		model.addAttribute("picList",picList);
;
		return "carouselPic/picList";
	}
	/**
	 * 轮播图的新增
	 * @return
	 */
	
	@RequestMapping("/admin/carouselPic/newsEdit")
    public String newsEdit( Model model)   {

		CarouselPic pic=new CarouselPic();
		model.addAttribute("pic",pic);
		return "carouselPic/newsEdit";
	}
	/**
	 * 轮播图的保存
	 * @return
	 */
	@RequestMapping("/admin/carouselPic/newsAdd")
    public void newsAdd( CarouselPic pic, HttpServletResponse response,HttpServletRequest request)   {
		pic.setFounder(request.getSession().getAttribute("admin").toString());
		Integer  stare =carouselPicService.newsAdd(pic);
		try {
			response.sendRedirect("/admin/carouselPic/list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	/**
	 * 轮播图的修改
	 * @return
	 */
	
	@RequestMapping("/admin/carouselPic/update")
    public String update( Integer rId, Model model,HttpServletRequest request)   {

		String user=request.getSession().getAttribute("admin").toString();
		Integer id=Integer.parseInt(user);
		User users= userService.findById(id);
		List<MenuUrlList> menuList=userService.menuList(users.getRole());
		model.addAttribute("menuList",menuList);
		model.addAttribute("user",users);
		CarouselPic pic=carouselPicService.picById(rId);
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
		String str1 = sdf.format(pic.getStartActivityTime());
		String str2 = sdf.format(pic.getEndActivityTime());
		String str3 = sdf.format(pic.getStartExhibitionTime());
		String str4 = sdf.format(pic.getEndExhibitionTime());

		model.addAttribute("str1",str1);
		model.addAttribute("str2",str2);
		model.addAttribute("str3",str3);
		model.addAttribute("str4",str4);



		model.addAttribute("pic",pic);
		return "carouselPic/newsEdit";
	}


	/**
	 * 轮播图的展示
	 * @return
	 */
	@RequestMapping("/admin/carouselPic/horseList")
	public String horseList( Model model, String  pageIndex ,HttpServletRequest request)   {

//		List<CarouselPic> picList=carouselPicService.picList();
//
//		model.addAttribute("picList",picList);
		User users= new User();
		model.addAttribute("users",users);
		return "carouselPic/horseAdd";
	}
	@RequestMapping("/admin/carouselPic/horseAdds")
	public String horseAdds( Model model, String  dddd ,HttpServletRequest request)   {

		User users= new User();
		model.addAttribute("users",users);
		return "carouselPic/horseAdd";
	}

}
