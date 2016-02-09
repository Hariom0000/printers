/*package com.ajay.printers.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ajay.printers.model.WeddingCardBean;

@Controller
@RequestMapping("/admin/*")
public class WeddingCardController {

	@RequestMapping(value = "weddingcard", method = RequestMethod.GET)
	public String weddingCard() {
		return "weddingcard";
	}

	@RequestMapping(value = "cuweddingcard", method = RequestMethod.POST)
	public @ResponseBody String createUpdateweddingCard(
			@RequestParam(value = "cardNumber",required=false) String cardNumber,
			@RequestParam(value = "activeYear",required=false) String activeYear,
			@RequestParam(value = "cardType",required=false) String cardType,
			@RequestParam(value = "imgOnCard",required=false) String imgOnCard,
			@RequestParam(value = "Cast",required=false) String Cast,
			@RequestParam(value = "minOrder",required=false) int minOrder,
			@RequestParam(value = "priceLTHundred",required=false) int priceLTHundred,
			@RequestParam(value = "priceGTHundred",required=false) int priceGTHundred,
			@RequestParam(value = "mainImg",required=false) MultipartFile mainImage,
			@RequestParam(value = "frontImg",required=false) MultipartFile frontImg,
			@RequestParam(value = "middleImg",required=false) MultipartFile middleImg,
			@RequestParam(value = "lastImg",required=false) MultipartFile lastImg,HttpServletRequest request)
			throws Exception {
		
		ServletContext context = request.getSession().getServletContext();
		String appPath = context.getRealPath("");
		String filePath = "/img/" + cardType+"/"+activeYear+"/"+cardNumber;
		String fullPath = appPath + filePath;
		System.out.println(mainImage.getName());

		
	

		return "weddingcard";
	}

	
	private void uploadFile(String locationToSave,MultipartFile file){
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = file.getInputStream();
			File downloadFiledir = new File(locationToSave);
			if (!downloadFiledir.exists())
				downloadFiledir.mkdirs();
			System.out.println(downloadFiledir.exists());
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

}
*/