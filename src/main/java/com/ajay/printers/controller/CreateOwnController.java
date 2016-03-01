package com.ajay.printers.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ajay.printers.beans.TestBean;
import com.ajay.printers.beans.WeddingCardBean;
import com.ajay.printers.controller.ManagementController.User;
import com.ajay.printers.service.SampleWeddingCardService;
import com.ajay.printers.service.WeddingCardService;

@Controller
public class CreateOwnController {
	@Autowired
	private WeddingCardService weddingCardService;

	@Autowired
	private SampleWeddingCardService sampleWeddingCardService;

	@RequestMapping(method = RequestMethod.GET, value = "owncard")
	public String ownCard(@ModelAttribute("weddingCardId") int weddingCardId,
			ModelMap model) {
		WeddingCardBean weddingCardBean = weddingCardService
				.getById(weddingCardId);
		model.addAttribute("weddingCardBean", weddingCardBean);
		model.addAttribute("sampleWeddingCardList", sampleWeddingCardService
				.getAllBySize(weddingCardBean.getCardSizeId()));
		model.addAttribute("sampleWeddingCardDefault", sampleWeddingCardService
				.getAllBySize(weddingCardBean.getCardSizeId()).get(0));
		model.addAttribute("TestBean", new TestBean());
		return "owncard";
	}

	@RequestMapping(method = RequestMethod.POST, value = "pdf")
	public ModelAndView generatePdfReport(ModelAndView modelAndView,
			@ModelAttribute("TestBean") TestBean testBean) {
		Map<String, Object> parameterMap = new HashMap<String, Object>();

/*		List<TestBean> userList = new ArrayList<TestBean>();

		JRDataSource JRdataSource = new  JRBeanCollectionDataSource(userList);

		parameterMap.put("datasource", JRdataSource);
		parameterMap.put("img", "img/Hand (22).TIF");
		parameterMap.put("backgroundimg", "D:/javaspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/HimanshiPrinters/img/wedding/Wedding Card/2015-2016/001/frontImg.jpg");*/

		// pdfReport bean has ben declared in the jasper-views.xml file
		modelAndView = new ModelAndView("pdfnotice");

		return modelAndView;

	}// generatePdfReport

}
