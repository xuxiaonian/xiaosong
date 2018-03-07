package com.refeng.controller;





import com.refeng.model.SaleUser;
import com.refeng.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class SaleController {
	@Autowired
	private SaleService saleService;

	/**
	 * 销售的展示
	 * @return
	 */
	@RequestMapping("/admin/sale/list")
    public String roleList(String userName, Model model)   {

        List<SaleUser> roleList=saleService.roleList(userName);
		model.addAttribute("roleList",roleList);
		return "sale/roleList";
	}
	/**
	 * 销售的新增
	 * @return
	 */

	@RequestMapping("/admin/sale/add")
    public String newsEdit( String userName, Model model,HttpServletRequest request)   {
		List<SaleUser> sale =saleService.saleList();
        SaleUser use =new SaleUser();
        model.addAttribute("user",use);
		model.addAttribute("sale",sale);
		return "sale/saleAdd";
	}
	/**
	 * 销售的新增的保存
	 * @return
	 */

	@RequestMapping("/admin/sale/addSale")
    public void newsAdd( SaleUser sale, HttpServletResponse response,HttpServletRequest request)   {

		String user=request.getSession().getAttribute("admin").toString();
		sale.setUserIdCreate(Integer.valueOf(user));
		Integer  stare =saleService.newsAdd(sale);
		try {
			response.sendRedirect("/admin/sale/list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	/**
	 * 销售的新增的保存
	 * @return
	 */

	@RequestMapping("/admin/sale/updateSale")
	public void updateSale( SaleUser sale, HttpServletResponse response,HttpServletRequest request)   {

		String user=request.getSession().getAttribute("admin").toString();
		sale.setUserIdCreate(Integer.valueOf(user));
		Integer  stare =saleService.updateSale(sale);
		try {
			response.sendRedirect("/admin/sale/list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	/**
	 * 销售的修改
	 * @return
	 */

	@RequestMapping("/admin/sale/update")
    public String update( Integer rId, Model model,HttpServletRequest request)   {
       SaleUser use=saleService.userId(rId);

		model.addAttribute("user",use);
		return "sale/saleUpdate";
	}







}
