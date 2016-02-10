package com.ajay.printers.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ajay.printers.beans.WeddingCardBean;
import com.ajay.printers.model.ActiveYear;
import com.ajay.printers.model.CardType;
import com.ajay.printers.model.UserCast;
import com.ajay.printers.model.WeddingCardFrontImage;
import com.ajay.printers.model.WeddingCard;
import com.ajay.printers.service.ActiveYearService;
import com.ajay.printers.service.CardTypeService;
import com.ajay.printers.service.UserCastService;
import com.ajay.printers.service.WeddingCardFrontImageService;
import com.ajay.printers.service.WeddingCardService;

@Controller
@RequestMapping(value = "/admin/management/**")
public class ManagementController {
	@Autowired
	private CardTypeService cardTypeService;

	@Autowired
	private ActiveYearService activeYearService;
	
	@Autowired
	private WeddingCardFrontImageService weddingCardFrontImageService; 
	
	@Autowired
	private UserCastService userCastService;
	
	@Autowired
	private WeddingCardService weddingCardService; 

	/* cardType management */
	@RequestMapping(value = "cardtype")
	public String cardView(ModelMap model) {
		return "cardtype";
	}

	@RequestMapping(value = "getcards", consumes = "application/json", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<CardType> getAllCards() {
		return cardTypeService.findAll(CardType.class);
	}

	@RequestMapping(value = "card", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public @ResponseBody List<CardType> createOrUpdate(
			@RequestBody CardType cardType) {
		if (cardType.getId() == null) {
			cardTypeService.create(cardType);
		} else {
			cardTypeService.update(cardType);
		}
		return cardTypeService.findAll(CardType.class);
	}

	/* end cardType management */

	/* active year management */
	@RequestMapping(value = "activeyear")
	public String activeyear(ModelMap model) {
		return "activeyear";
	}

	@RequestMapping(value = "getAllActiveYear", consumes = "application/json", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<ActiveYear> getAllActiveYear() {
		return activeYearService.findAll(ActiveYear.class);
	}

	@RequestMapping(value = "createupdateactiveyaer", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public @ResponseBody List<ActiveYear> createOrUpdateActiveYear(
			@RequestBody ActiveYear ActiveYear) {
		if (ActiveYear.getId() == null) {
			activeYearService.create(ActiveYear);
		} else {
			activeYearService.update(ActiveYear);
		}
		return activeYearService.findAll(ActiveYear.class);
	}
	
	@RequestMapping(value = "deleteactiveyaer", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public @ResponseBody List<ActiveYear> deleteActiveYear(
			@RequestBody ActiveYear activeYear) {
		try{
			activeYearService.deleteById(activeYear.getId());
		}catch(Exception e){
			 new Exception("This year not found");
		}
		return activeYearService.findAll(ActiveYear.class);
	}
	
	/* end active year management */
	
	
	/* active year management */
	@RequestMapping(value = "weddingcardfrontimg")
	public String weddingcardfrontimg(ModelMap model) {
		return "weddingcardfrontimg";
	}

	@RequestMapping(value = "getweddingcardfrontimg", consumes = "application/json", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<WeddingCardFrontImage> getweddingcardfrontimg() {
		return weddingCardFrontImageService.findAll(WeddingCardFrontImage.class);
	}

	@RequestMapping(value = "createupdateweddingcardfrontimg", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public @ResponseBody List<WeddingCardFrontImage> createOrUpdateweddingcardfrontimg(
			@RequestBody WeddingCardFrontImage weddingCardFrontImage) {
		if (weddingCardFrontImage.getId() == null) {
			weddingCardFrontImageService.create(weddingCardFrontImage);
		} else {
			weddingCardFrontImageService.update(weddingCardFrontImage);
		}
		return weddingCardFrontImageService.findAll(WeddingCardFrontImage.class);
	}
	
	@RequestMapping(value = "deletweddingcardfrontimg", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public @ResponseBody List<WeddingCardFrontImage> deleteweddingcardfrontimg(
			@RequestBody WeddingCardFrontImage weddingCardFrontImage) {
		try{
			weddingCardFrontImageService.deleteById(weddingCardFrontImage.getId());
		}catch(Exception e){
			 new Exception("This not found");
		}
		return weddingCardFrontImageService.findAll(WeddingCardFrontImage.class);
	}
	
	/* end active year management */
	
	
	/* cast management */
	@RequestMapping(value = "casts")
	public String cast(ModelMap model) {
		return "cast";
	}

	@RequestMapping(value = "getcasts", consumes = "application/json", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<UserCast> getCasts() {
		return userCastService.findAll(UserCast.class);
	}

	@RequestMapping(value = "createupdatecast", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public @ResponseBody List<UserCast> createOrUpdateCast(
			@RequestBody UserCast userCast) {
		
		try{if (userCast.getId() == null) {
			
			userCastService.create(userCast);
			
		} else {
			userCastService.update(userCast);
		}
		}
		catch(Exception e){
			new Exception("Duplicate Entry for : "+userCast.getCast());
		}
		return userCastService.findAll(UserCast.class);
	}
	
	@RequestMapping(value = "deletcast", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public @ResponseBody List<UserCast> deleteCast(
			@RequestBody UserCast userCast) {
		try{
			userCastService.deleteById(userCast.getId());
		}catch(Exception e){
			 new Exception("This not found");
		}
		return userCastService.findAll(UserCast.class);
	}
	
	/* end cast management */
	
	/* weddingcardt management */
	
	@RequestMapping(value = "weddingcard")
	public String WeddingCard(ModelMap model) {
		return "weddingcard";
	}
	
	@RequestMapping(value = "getweddingcards", consumes = "application/json", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getWeddingCards() {
		Map<String, Object> map=weddingCardService.getWeddingCardBaseData();
		map.put("weddingcard", weddingCardService.getAllWeddingCard());
		return map;
	}
	
	@RequestMapping(value = "getweddingcardbasedata", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getWeddingCardBaseData() {
		return weddingCardService.getWeddingCardBaseData();
	}

	
	@RequestMapping(value = "cuweddingcard", method = RequestMethod.POST)
	public @ResponseBody List<WeddingCardBean> createUpdateweddingCard(
			@RequestParam(value = "activeYearId",required=false) int id,
			@RequestParam(value = "cardNumber",required=true) String cardNumber,
			@RequestParam(value = "activeYearId",required=true) int activeYearId,
			@RequestParam(value = "cardTypeId",required=true) int cardTypeId,
			@RequestParam(value = "weddingCardFrontImageId",required=true) int weddingCardFrontImageId,
			@RequestParam(value = "userCastId",required=true) int userCastId,
			@RequestParam(value = "minOrder",required=true) int minOrder,
			@RequestParam(value = "priceLTHundred",required=true) int priceLTHundred,
			@RequestParam(value = "priceGTHundred",required=true) int priceGTHundred,
			@RequestParam(value = "mainImg",required=false) MultipartFile mainImage,
			@RequestParam(value = "frontImg",required=false) MultipartFile frontImg,
			@RequestParam(value = "middleImg",required=false) MultipartFile middleImg,
			@RequestParam(value = "lastImg",required=false) MultipartFile lastImg,HttpServletRequest request)
			throws Exception {
		
		ServletContext context = request.getSession().getServletContext();
		CardType cardType=cardTypeService.read(cardTypeId);
		ActiveYear activeYear=activeYearService.read(activeYearId);
		UserCast userCast=new UserCast();
		userCast.setId(userCastId);
		WeddingCardFrontImage weddingCardFrontImage=new WeddingCardFrontImage();
		weddingCardFrontImage.setId(weddingCardFrontImageId);
		String filePath = "img/"+cardType.getType()+"/"+activeYear.getYear()+"/"+cardNumber;
		String fullPath = context.getRealPath("/"+filePath);
		System.out.println(fullPath);
		WeddingCard  weddingCard=null;
				if(id==0){
					weddingCard=new WeddingCard();
					weddingCard.setActiveYear(activeYear);
					weddingCard.setCardNumber(cardNumber);
					weddingCard.setCardType(cardType);
					weddingCard.setFrontImg(filePath+ "/"+frontImg.getName()+".jpg");
					weddingCard.setLastImg(filePath+ "/"+lastImg.getName()+".jpg");
					weddingCard.setMainImg(filePath+ "/"+mainImage.getName()+".jpg");
					weddingCard.setMiddleImg(filePath+ "/"+middleImg.getName()+".jpg");
					weddingCard.setMinOrder(minOrder);
					weddingCard.setPriceGTHundred(priceGTHundred);
					weddingCard.setPriceLTHundred(priceLTHundred);
					weddingCard.setUserCast(userCast);
					weddingCard.setWeddingCardFrontImage(weddingCardFrontImage);
					//weddingCardService.create(weddingCard);
				}else{
					weddingCard=weddingCardService.read(id);
					weddingCard.setActiveYear(activeYear);
					weddingCard.setCardNumber(cardNumber);
					weddingCard.setCardType(cardType);
					weddingCard.setFrontImg(filePath+ "/"+frontImg.getName()+".jpg");
					weddingCard.setLastImg(filePath+ "/"+lastImg.getName()+".jpg");
					weddingCard.setMainImg(filePath+ "/"+mainImage.getName()+".jpg");
					weddingCard.setMiddleImg(filePath+ "/"+middleImg.getName()+".jpg");
					weddingCard.setMinOrder(minOrder);
					weddingCard.setPriceGTHundred(priceGTHundred);
					weddingCard.setPriceLTHundred(priceLTHundred);
					weddingCard.setUserCast(userCast);
					weddingCard.setWeddingCardFrontImage(weddingCardFrontImage);
					//weddingCardService.update(weddingCard);
				}
		     if(frontImg!=null)
				uploadFile(fullPath,frontImg);
		     if(mainImage!=null)
				uploadFile(fullPath,mainImage);
		     if(middleImg!=null)
				uploadFile(fullPath,middleImg);
		     if(lastImg!=null)
				uploadFile(fullPath,lastImg);

		return weddingCardService.getAllWeddingCard();
	}

	
	private void uploadFile(String locationToSave,MultipartFile file){
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = file.getInputStream();
			File downloadFiledir = new File(locationToSave);
			if (!downloadFiledir.exists())
				downloadFiledir.mkdirs();
			System.out.println("locationToSave :"+locationToSave+"  " +downloadFiledir.exists());
			File newFile = new File(locationToSave + "/"+file.getName()+".jpg");
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		} catch (IOException e) { //
		} finally {
			try {
				if (outputStream != null)
					outputStream.close();
			} catch (IOException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	/*end weddingcardt management */
	
}
