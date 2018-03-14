package com.refeng.controller;





import com.refeng.model.Record;
import com.refeng.model.SaleUser;
import com.refeng.model.TbMsgOffic;
import com.refeng.service.CarouselPicService;
import com.refeng.service.ExternalService;
import com.refeng.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class ExternalController {
	@Autowired
	private ExternalService externalService;
	@Autowired
	private CarouselPicService carouselPicService;
	/**
	 *检查是否存在
	 * @return
	 */
	@GetMapping("/external/index")
	public String index()   {


		return  "external/index";
	}
	/**
	 *检查是否存在
	 * @return
	 */
	@PostMapping("/external/confirm")
	@ResponseBody
    public Map<String ,Object > roleList(String userId)   {
		Map<String ,Object > ss =new HashMap<>();
        List<SaleUser> roleList=externalService.role(userId);
        if(roleList.size()>0){
			ss.put("code",1);
			ss.put("name",roleList.get(0).getName());
		}else{
			ss.put("code",0);
			ss.put("name","不存在");
		}

      return  ss;
	}
	/**
	 *保存
	 * @return
	 */
	@PostMapping("/external/append")
	@ResponseBody
	public Map<String ,Object > roleAdd( @Valid Record dto)   {
		Map<String ,Object > ss =new HashMap<>();
	Integer append=externalService.roleAppend(dto);
		if(append ==1){
			ss.put("code",1);
			ss.put("name","保存成功");
		}else{
			ss.put("code",0);
			ss.put("name","保存失败");
		}

		return  ss;
	}



	/**
	 * 官方消息
	 * @return
	 */
	@GetMapping("/external/newsId")
	public String horseUp( String  rId ,Model model ) {

		TbMsgOffic offic=carouselPicService.offic(Integer.valueOf(rId));
		model.addAttribute("offic",offic);

		return "external/notice";
	}


}
