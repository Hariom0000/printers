package com.ajay.printers.model;

import java.io.Serializable;

public interface PO<I extends Serializable> extends Serializable {
	public I getId();
	public void setId(I id);
}
