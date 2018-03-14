package com.refeng.controller;

import com.refeng.model.CarouselPic;

import com.refeng.model.TbMsgOffic;
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
	 * 轮播图的删除
	 * @return
	 */
	@RequestMapping("/admin/carouselPic/deletePic")
	public void deletePic(HttpServletResponse response, String  rId ) {

		Integer offic=carouselPicService.deletePic(Integer.valueOf(rId));
		try {
			response.sendRedirect("/admin/carouselPic/list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
	/**
	 * 消息推送的list
	 * @return
	 */
	@RequestMapping("/admin/carouselPic/horseList")
	public String horseList( Model model, String  pageIndex ,HttpServletRequest request)   {

		List<TbMsgOffic> officList=carouselPicService.officList();

		model.addAttribute("officList",officList);

		return "carouselPic/officList";
	}
	/**
	 * 消息推送的新增页面
	 * @return
	 */
	@RequestMapping("/admin/carouselPic/horseAdds")
	public String horseAdds( Model model, HttpServletRequest request)   {

		TbMsgOffic users= new TbMsgOffic();
		model.addAttribute("users",users);
		return "carouselPic/horseAdd";
	}


	/**
	 *  消息推送的新增保存
	 * @return
	 */
	@RequestMapping("/admin/carouselPic/horseUp")
	public void horseUp(TbMsgOffic tbMsgOffic,  HttpServletResponse response,HttpServletRequest request) {

		tbMsgOffic.setAuthor(request.getSession().getAttribute("realName").toString());
		Integer stare = carouselPicService.horseUp(tbMsgOffic);
		try {
			response.sendRedirect("/admin/carouselPic/horseList");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}


	/**
	 * 消息推送的修改
	 * @return
	 */
	@RequestMapping("/admin/carouselPic/horseUpate")
	public String horseUp( Model model, String rId ,HttpServletRequest request) {

		TbMsgOffic offic=carouselPicService.offic(Integer.valueOf(rId));
		model.addAttribute("users",offic);
		return "carouselPic/horseAdd";

	}

	/**
	 * 消息推送的删除
	 * @return
	 */
	@RequestMapping("/admin/carouselPic/delete")
	public void delete(HttpServletResponse response, String  rId ) {

		Integer offic=carouselPicService.delete(Integer.valueOf(rId));
		try {
			response.sendRedirect("/admin/carouselPic/horseList");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}
