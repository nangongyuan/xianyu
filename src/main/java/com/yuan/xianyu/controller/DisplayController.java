/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: DisplayController
 * Author:   Administrator
 * Date:     2018/9/16 0016 14:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.controller;

import com.yuan.xianyu.common.Const;
import com.yuan.xianyu.common.ServerResponse;
import com.yuan.xianyu.pojo.Product;
import com.yuan.xianyu.pojo.User;
import com.yuan.xianyu.service.*;
import com.yuan.xianyu.util.PropertiesUtil;
import com.yuan.xianyu.vo.ProductDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/16 0016
 * @since 1.0.0
 */
@Controller
public class DisplayController {

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private IFileService fileService;

	@Autowired
	private IProductService productService;

	@Autowired
	private ICollegeService collegeService;

	@Autowired
	private ICollectService collectService;

	@Autowired
	private IUserService userService;

	@Autowired
	private ILeaveWordService leaveWordService;

	@Autowired
	private IOrderService orderService;

	@GetMapping("/")
	public ModelAndView index(Model model, @RequestParam(value = "collectId", defaultValue = "2115") Integer collectId,
							  HttpSession httpSession){
		httpSession.setAttribute(Const.COLLEGE_ID,collectId);
		model.addAttribute("categoryList",categoryService.listCategory());
		model.addAttribute("digital",productService.listProductByCategoryId(collectId,1,0,0,0,5));
		model.addAttribute("books",productService.listProductByCategoryId(collectId,2,0,0,0,5));
		model.addAttribute("snacks",productService.listProductByCategoryId(collectId,3,0,0,0,5));
		model.addAttribute("daily",productService.listProductByCategoryId(collectId,4,0,0,0,5));
		model.addAttribute("clothes",productService.listProductByCategoryId(collectId,5,0,0,0,5));
		model.addAttribute("collect",collegeService.getCollectById(collectId));
		model.addAttribute(Const.LOGIN_USER,httpSession.getAttribute(Const.LOGIN_USER));
		return new ModelAndView("index","model",model);
	}

	@GetMapping("/issue")
	public ModelAndView issue(Model model, HttpSession httpSession){
		model.addAttribute("categoryList",categoryService.listCategory());
		model.addAttribute(Const.LOGIN_USER,httpSession.getAttribute(Const.LOGIN_USER));
		return new ModelAndView("issue","model",model);
	}

	@GetMapping("/detail")
	public ModelAndView detail(Model model, Integer productId, HttpSession httpSession){
		productService.increaseProductHit(productId);
		ProductDetailVo productDetailVo = productService.getProductDetailById(productId);
		model.addAttribute("categoryList",categoryService.listCategory());
		model.addAttribute("productDetail",productDetailVo);
		model.addAttribute(Const.LOGIN_USER,httpSession.getAttribute(Const.LOGIN_USER));
		model.addAttribute("seller",userService.getUserById(productDetailVo.getUserId()));
		model.addAttribute("leaveWord",leaveWordService.listLeaveWordByProductId(productDetailVo.getId()));
		return new ModelAndView("detail","model",model);
	}

	@GetMapping("/list")
	public ModelAndView list(Model model,Integer categoryId, Integer order, Integer pageNum, Integer pageSize,
							 HttpSession httpSession){
		Integer colloctId = (Integer) httpSession.getAttribute(Const.COLLEGE_ID);
		if (colloctId == null){
			colloctId = Const.DEFAULT_COLLECT_ID;
		}
		model.addAttribute("categoryList",categoryService.listCategory());
		model.addAttribute("page",productService.listProductByCategoryId(colloctId,categoryId,0,order,pageNum,pageSize));
		model.addAttribute("category",categoryService.getCategoryById(categoryId));
		model.addAttribute(Const.LOGIN_USER,httpSession.getAttribute(Const.LOGIN_USER));
		model.addAttribute("order",order);
		return new ModelAndView("list","model",model);
	}

	@GetMapping("/search")
	public ModelAndView search(Model model,String word, Integer order, Integer pageNum, Integer pageSize,
							 HttpSession httpSession){
		Integer colloctId = (Integer) httpSession.getAttribute(Const.COLLEGE_ID);
		if (colloctId == null){
			colloctId = Const.DEFAULT_COLLECT_ID;
		}
		model.addAttribute("categoryList",categoryService.listCategory());
		model.addAttribute("word",word);
		model.addAttribute("page",productService.searchProduct(colloctId,word,order,pageNum,pageSize));
		model.addAttribute(Const.LOGIN_USER,httpSession.getAttribute(Const.LOGIN_USER));
		model.addAttribute("order",order);
		return new ModelAndView("search","model",model);
	}


//	@GetMapping("/test")
//	@ResponseBody
//	public Page<Product> test(){
//
//		return productService.listProductByCategoryId(2115,1,0,0,0,15);
//	}

	@GetMapping("/login")
	public ModelAndView login(Model model){
		return new ModelAndView("login","model",model);
	}


	@GetMapping("/register")
	public ModelAndView register(Model model){
		return new ModelAndView("register","model",model);
	}

	@GetMapping("/my_collect")
	public ModelAndView mycollect(Model model, @RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
								  @RequestParam(name = "pageSize", defaultValue = "10")Integer pageSize,
								  HttpSession httpSession, HttpServletResponse response) throws IOException {
		User user = (User) httpSession.getAttribute(Const.LOGIN_USER);
		if (user == null){
			response.sendRedirect("/");
			return null;
		}
		model.addAttribute("categoryList",categoryService.listCategory());
		model.addAttribute(Const.LOGIN_USER,user);
		model.addAttribute("page",collectService.listMyCollect(user.getId(),pageNum, pageSize));
		return new ModelAndView("my_collect","model",model);
	}

	@GetMapping("/my_product")
	public ModelAndView myProduct(Model model, HttpSession httpSession, HttpServletResponse response,@RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
								  @RequestParam(name = "pageSize", defaultValue = "10")Integer pageSize) throws IOException {
		User user = (User) httpSession.getAttribute(Const.LOGIN_USER);
		if (user == null){
			response.sendRedirect("/");
			return null;
		}
		model.addAttribute("userList",userService.listAllUser());
		model.addAttribute("categoryList",categoryService.listCategory());
		model.addAttribute("page",productService.listMyProduct(user.getId(),pageNum,pageSize));
		model.addAttribute(Const.LOGIN_USER,user);
		return new ModelAndView("my_product","model",model);
	}

	@GetMapping("/my_info")
	public ModelAndView myInfo(Model model, HttpSession httpSession, HttpServletResponse response) throws IOException {
		User user = (User) httpSession.getAttribute(Const.LOGIN_USER);
		if (user == null){
			response.sendRedirect("/");
			return null;
		}
		model.addAttribute("categoryList",categoryService.listCategory());
		model.addAttribute(Const.LOGIN_USER,user);
		return new ModelAndView("my_info","model",model);
	}

	@GetMapping("/my_order")
	public ModelAndView myOrder(Model model, HttpSession httpSession, HttpServletResponse response,
								@RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
								@RequestParam(name = "pageSize", defaultValue = "10")Integer pageSize) throws IOException {
		User user = (User) httpSession.getAttribute(Const.LOGIN_USER);
		if (user == null){
			response.sendRedirect("/");
			return null;
		}
		model.addAttribute("categoryList",categoryService.listCategory());
		model.addAttribute("page",orderService.listMyOrder(user.getId(),pageNum,pageSize));
		model.addAttribute(Const.LOGIN_USER,user);
		return new ModelAndView("my_order","model",model);
	}


	@RequestMapping(value = "/upload",method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<String> upload(HttpSession session, @RequestParam(value = "upload_file",required = false) MultipartFile multipartFile, HttpServletRequest request){
		String path = request.getSession().getServletContext().getRealPath("upload");
		String targetFileName = fileService.upload(multipartFile,path);
		String url = PropertiesUtil.getProperty("server.http.prefix");
		if (StringUtils.isEmpty(targetFileName)){
			ServerResponse.createError();
		}
		return ServerResponse.createSuccessByData(url+"upload/"+targetFileName);
	}

	@RequestMapping(value = "/richtext_img_upload",method = RequestMethod.POST)
	@ResponseBody
	public Map richtextImgUpload(HttpSession session, @RequestParam(value = "upload_file",required = false) MultipartFile multipartFile,
								 HttpServletRequest request, HttpServletResponse response){
		Map resultMap = new HashMap();
		String path = request.getSession().getServletContext().getRealPath("upload");
		System.out.println(path);
		String targetFileName = fileService.upload(multipartFile,path);
		String url = PropertiesUtil.getProperty("server.http.prefix");
		if (StringUtils.isEmpty(targetFileName)){
			resultMap.put("success",false);
			resultMap.put("msg","上传失败");
			return resultMap;
		}
		resultMap.put("success",true);
		resultMap.put("msg","上传成功");
		resultMap.put("file_path",url+"upload/"+targetFileName);
		response.addHeader("Access-Control-Allow-Headers","X-File-Name");
		return resultMap;
	}

}