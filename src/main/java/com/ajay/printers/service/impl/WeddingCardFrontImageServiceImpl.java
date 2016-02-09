package com.ajay.printers.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.printers.dao.WeddingCardFrontImageDao;
import com.ajay.printers.model.WeddingCardFrontImage;
import com.ajay.printers.service.WeddingCardFrontImageService;

@Service
@Transactional
public class WeddingCardFrontImageServiceImpl
		extends
		CRUDServiceImpl<Integer, WeddingCardFrontImage, WeddingCardFrontImageDao>
		implements WeddingCardFrontImageService {
	@Autowired
	public WeddingCardFrontImageServiceImpl(WeddingCardFrontImageDao dao) {
		super(dao);
	}

}
