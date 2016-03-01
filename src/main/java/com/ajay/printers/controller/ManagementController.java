package com.ajay.printers.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ajay.printers.beans.SampleWeddingCardBean;
import com.ajay.printers.beans.WeddingCardBean;
import com.ajay.printers.model.ActiveYear;
import com.ajay.printers.model.CardSize;
import com.ajay.printers.model.CardType;
import com.ajay.printers.model.SampleWeddingCard;
import com.ajay.printers.model.UserCast;
import com.ajay.printers.model.WeddingCardFrontImage;
import com.ajay.printers.model.WeddingCard;
import com.ajay.printers.service.ActiveYearService;
import com.ajay.printers.service.CardSizeService;
import com.ajay.printers.service.CardTypeService;
import com.ajay.printers.service.SampleWeddingCardService;
import com.ajay.printers.service.UserCastService;
import com.ajay.printers.service.WeddingCardFrontImageService;
import com.ajay.printers.service.WeddingCardService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping(value = "/admin/management/**")
public class ManagementController {

	private static final Logger logger = LoggerFactory
			.getLogger(ManagementController.class);

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

	@Autowired
	private CardSizeService cardSizeService;

	@Autowired
	private SampleWeddingCardService sampleWeddingCardService;

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
		try {
			activeYearService.deleteById(activeYear.getId());
		} catch (Exception e) {
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
		return weddingCardFrontImageService
				.findAll(WeddingCardFrontImage.class);
	}

	@RequestMapping(value = "createupdateweddingcardfrontimg", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public @ResponseBody List<WeddingCardFrontImage> createOrUpdateweddingcardfrontimg(
			@RequestBody WeddingCardFrontImage weddingCardFrontImage) {
		if (weddingCardFrontImage.getId() == null) {
			weddingCardFrontImageService.create(weddingCardFrontImage);
		} else {
			weddingCardFrontImageService.update(weddingCardFrontImage);
		}
		return weddingCardFrontImageService
				.findAll(WeddingCardFrontImage.class);
	}

	@RequestMapping(value = "deletweddingcardfrontimg", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public @ResponseBody List<WeddingCardFrontImage> deleteweddingcardfrontimg(
			@RequestBody WeddingCardFrontImage weddingCardFrontImage) {
		try {
			weddingCardFrontImageService.deleteById(weddingCardFrontImage
					.getId());
		} catch (Exception e) {
			new Exception("This not found");
		}
		return weddingCardFrontImageService
				.findAll(WeddingCardFrontImage.class);
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

		try {
			if (userCast.getId() == null) {

				userCastService.create(userCast);

			} else {
				userCastService.update(userCast);
			}
		} catch (Exception e) {
			new Exception("Duplicate Entry for : " + userCast.getCast());
		}
		return userCastService.findAll(UserCast.class);
	}

	@RequestMapping(value = "deletcast", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public @ResponseBody List<UserCast> deleteCast(
			@RequestBody UserCast userCast) {
		try {
			userCastService.deleteById(userCast.getId());
		} catch (Exception e) {
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
		Map<String, Object> map = weddingCardService.getWeddingCardBaseData();
		map.put("weddingcard", weddingCardService.getAllWeddingCard());
		return map;
	}

	@RequestMapping(value = "getweddingcardbasedata", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getWeddingCardBaseData() {
		return weddingCardService.getWeddingCardBaseData();
	}

	@RequestMapping(value = "cuweddingcard", method = RequestMethod.POST)
	public @ResponseBody List<WeddingCardBean> createUpdateweddingCard(
			@RequestParam(value = "id", required = false, defaultValue="0") int id,
			@RequestParam(value = "cardNumber", required = true) String cardNumber,
			@RequestParam(value = "activeYearId", required = false) Integer activeYearId,
			@RequestParam(value = "cardTypeId", required = true) int cardTypeId,
			@RequestParam(value = "cardSizeId", required = true) int cardSizeId,
			@RequestParam(value = "weddingCardFrontImageId", required = true) int weddingCardFrontImageId,
			@RequestParam(value = "userCastId", required = true) int userCastId,
			@RequestParam(value = "minOrder", required = true) int minOrder,
			@RequestParam(value = "priceLTHundred", required = true) int priceLTHundred,
			@RequestParam(value = "priceGTHundred", required = true) int priceGTHundred,
			@RequestParam(value = "mainImg", required = false) MultipartFile mainImage,
			@RequestParam(value = "frontImg", required = false) MultipartFile frontImg,
			@RequestParam(value = "middleImg", required = false) MultipartFile middleImg,
			@RequestParam(value = "lastImg", required = false) MultipartFile lastImg,
			HttpServletRequest request) throws Exception {

		ServletContext context = request.getSession().getServletContext();
		CardType cardType = cardTypeService.read(cardTypeId);
		ActiveYear activeYear = activeYearService.read(activeYearId);
		UserCast userCast = new UserCast();
		userCast.setId(userCastId);
		 
		WeddingCardFrontImage weddingCardFrontImage = new WeddingCardFrontImage();
		weddingCardFrontImage.setId(weddingCardFrontImageId);
		CardSize cardSize = cardSizeService.read(cardSizeId);
		String filePath = "img/wedding/" + cardType.getType() + "/"
				+ activeYear.getYear() + "/" + cardNumber;
		String fullPath = context.getRealPath("/" + filePath);
		System.out.println(fullPath);
		WeddingCard weddingCard = null;
		if (id == 0) {
			weddingCard = new WeddingCard();
			weddingCard.setActiveYear(activeYear);
			weddingCard.setCardNumber(cardNumber);
			weddingCard.setCardType(cardType);
			weddingCard.setCardSize(cardSize);
			if (frontImg != null)
				weddingCard.setFrontImg(filePath + "/" + frontImg.getName()
						+ ".jpg");
			if (lastImg != null)
				weddingCard.setLastImg(filePath + "/" + lastImg.getName()
						+ ".jpg");
			if (mainImage != null)
				weddingCard.setMainImg(filePath + "/" + mainImage.getName()
						+ ".jpg");
			if (middleImg != null)
				weddingCard.setMiddleImg(filePath + "/" + middleImg.getName()
						+ ".jpg");
			weddingCard.setMinOrder(minOrder);
			weddingCard.setPriceGTHundred(priceGTHundred);
			weddingCard.setPriceLTHundred(priceLTHundred);
			weddingCard.setUserCast(userCast);
			weddingCard.setWeddingCardFrontImage(weddingCardFrontImage);
			weddingCardService.create(weddingCard);
		} else {
			weddingCard = weddingCardService.read(id);
			weddingCard.setActiveYear(activeYear);
			weddingCard.setCardNumber(cardNumber);
			weddingCard.setCardType(cardType);
			weddingCard.setCardSize(cardSize);
			if (frontImg != null)
				weddingCard.setFrontImg(filePath + "/" + frontImg.getName()
						+ ".jpg");
			if (lastImg != null)
				weddingCard.setLastImg(filePath + "/" + lastImg.getName()
						+ ".jpg");
			if (mainImage != null)
				weddingCard.setMainImg(filePath + "/" + mainImage.getName()
						+ ".jpg");
			if (middleImg != null)
				weddingCard.setMiddleImg(filePath + "/" + middleImg.getName()
						+ ".jpg");
			weddingCard.setMinOrder(minOrder);
			weddingCard.setPriceGTHundred(priceGTHundred);
			weddingCard.setPriceLTHundred(priceLTHundred);
			weddingCard.setUserCast(userCast);
			weddingCard.setWeddingCardFrontImage(weddingCardFrontImage);
		    weddingCardService.update(weddingCard);
		}
		if (frontImg != null)
			uploadFile(fullPath, frontImg);
		if (mainImage != null)
			uploadFile(fullPath, mainImage);
		if (middleImg != null)
			uploadFile(fullPath, middleImg);
		if (lastImg != null)
			uploadFile(fullPath, lastImg);

		return weddingCardService.getAllWeddingCard();
	}

	private void uploadFile(String locationToSave, MultipartFile file) {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = file.getInputStream();
			File downloadFiledir = new File(locationToSave);
			if (!downloadFiledir.exists())
				downloadFiledir.mkdirs();
			System.out.println("locationToSave :" + locationToSave + "  "
					+ downloadFiledir.exists());
			File newFile = new File(locationToSave + "/" + file.getName()
					+ ".jpg");
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

	/* end weddingcardt management */

	/* sampleweddingcard management */

	@RequestMapping(value = "sampleweddingcard")
	public String sampleWeddingCard(ModelMap model) {
		return "sampleweddingcard";
	}

	@RequestMapping(value = "getsampleweddingcards", consumes = "application/json", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getSampleWeddingCards() {
		Map<String, Object> map = weddingCardService.getWeddingCardBaseData();
		map.put("sampleweddingcard",
				sampleWeddingCardService.getAllSampleWeddingCard());
		return map;
	}

	@RequestMapping(value = "cusampleweddingcard", method = RequestMethod.POST)
	public @ResponseBody List<SampleWeddingCardBean> createUpdateSampleweddingCard(
			@RequestParam(value = "id", required = false,defaultValue="0") int id,
			@RequestParam(value = "cardNumber", required = false) String cardNumber,
			@RequestParam(value = "activeYearId", required = false) Integer activeYearId,
			@RequestParam(value = "cardTypeId", required = false) Integer cardTypeId,
			@RequestParam(value = "weddingCardFrontImageId", required = false) Integer weddingCardFrontImageId,
			@RequestParam(value = "userCastId", required = false) Integer userCastId,
			@RequestParam(value = "cardSizeId", required = false) Integer cardSizeId,
			@RequestParam(value = "mainImg", required = false) MultipartFile mainImage,
			@RequestParam(value = "frontImg", required = false) MultipartFile frontImg,
			@RequestParam(value = "middleImg", required = false) MultipartFile middleImg,
			@RequestParam(value = "lastImg", required = false) MultipartFile lastImg,
			HttpServletRequest request) throws Exception {

		ServletContext context = request.getSession().getServletContext();
		CardType cardType = cardTypeService.read(cardTypeId);
		ActiveYear activeYear = activeYearService.read(activeYearId);
		UserCast userCast = new UserCast();
		userCast.setId(userCastId);
		WeddingCardFrontImage weddingCardFrontImage = new WeddingCardFrontImage();
		weddingCardFrontImage.setId(weddingCardFrontImageId);
		CardSize cardSize = cardSizeService.read(cardSizeId);
		String filePath = "img/sample/" + cardType.getType() + "/"
				+ activeYear.getYear() + "/" + cardNumber;
		String fullPath = context.getRealPath("/" + filePath);
		System.out.println(fullPath);
		SampleWeddingCard sampleWeddingCard = null;
		if (id == 0) {
			sampleWeddingCard = new SampleWeddingCard();
			sampleWeddingCard.setActiveYear(activeYear);
			sampleWeddingCard.setCardNumber(cardNumber);
			sampleWeddingCard.setCardType(cardType);
			sampleWeddingCard.setCardSize(cardSize);
			if(frontImg!=null)
			sampleWeddingCard.setFrontImg(filePath + "/" + frontImg.getName()
					+ ".jpg");
			if(lastImg!=null)
			sampleWeddingCard.setLastImg(filePath + "/" + lastImg.getName()
					+ ".jpg");
			if(mainImage!=null)
			sampleWeddingCard.setMainImg(filePath + "/" + mainImage.getName()
					+ ".jpg");
			if(middleImg!=null)
			sampleWeddingCard.setMiddleImg(filePath + "/" + middleImg.getName()
					+ ".jpg");
			sampleWeddingCard.setUserCast(userCast);
			sampleWeddingCard.setWeddingCardFrontImage(weddingCardFrontImage);
			sampleWeddingCardService.create(sampleWeddingCard);
		} else {
			sampleWeddingCard = sampleWeddingCardService.read(id);
			sampleWeddingCard.setActiveYear(activeYear);
			sampleWeddingCard.setCardNumber(cardNumber);
			sampleWeddingCard.setCardType(cardType);
			sampleWeddingCard.setCardSize(cardSize);
			if(frontImg!=null)
				sampleWeddingCard.setFrontImg(filePath + "/" + frontImg.getName()
						+ ".jpg");
				if(lastImg!=null)
				sampleWeddingCard.setLastImg(filePath + "/" + lastImg.getName()
						+ ".jpg");
				if(mainImage!=null)
				sampleWeddingCard.setMainImg(filePath + "/" + mainImage.getName()
						+ ".jpg");
				if(middleImg!=null)
				sampleWeddingCard.setMiddleImg(filePath + "/" + middleImg.getName()
						+ ".jpg");
			sampleWeddingCard.setUserCast(userCast);
			sampleWeddingCard.setWeddingCardFrontImage(weddingCardFrontImage);
			sampleWeddingCardService.update(sampleWeddingCard);
		}
		if (frontImg != null)
			uploadFile(fullPath, frontImg);
		if (mainImage != null)
			uploadFile(fullPath, mainImage);
		if (middleImg != null)
			uploadFile(fullPath, middleImg);
		if (lastImg != null)
			uploadFile(fullPath, lastImg);

		return sampleWeddingCardService.getAllSampleWeddingCard();
	}

	/* end sampleweddingcard management */

	/* card size management */

	@RequestMapping(value = "cardsize")
	public String cardSize(ModelMap model) {
		return "cardsize";
	}

	@RequestMapping(value = "getcardsizes", consumes = "application/json", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<CardSize> getCastSizes() {
		return cardSizeService.findAll(CardSize.class);
	}

	@RequestMapping(value = "createupdatecardsize", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public @ResponseBody List<CardSize> createOrUpdateCardSize(
			@RequestBody CardSize cardSize) {

		try {
			if (cardSize.getId() == null) {

				cardSizeService.create(cardSize);

			} else {
				cardSizeService.update(cardSize);
			}
		} catch (Exception e) {
			new Exception("Duplicate Entry for  ardSize : "
					+ cardSize.getSize());
		}
		return cardSizeService.findAll(CardSize.class);
	}

	@RequestMapping(value = "deletcardsize", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public @ResponseBody List<CardSize> deleteCard(
			@RequestBody CardSize cardSize) {
		try {
			cardSizeService.deleteById(cardSize.getId());
		} catch (Exception e) {
			new Exception("This not found");
		}
		return cardSizeService.findAll(CardSize.class);
	}

	/* end card size management */

	/* create own card */
	@RequestMapping(value = "createowncard")
	public String createOwnCard(
			@RequestParam(required = true, value = "weddingcardid") Integer weddingCardId,
			RedirectAttributes redirectAttributes) {
		redirectAttributes.addAttribute("weddingCardId", weddingCardId);
		return "redirect:/owncard";
	}

	class User {
		private String id;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
	}
}
