package com.maf.availablehotel.bean;

import com.maf.availablehotel.requesthandler.HotelProviderRequestHandler;
import com.maf.availablehotel.requesthandler.HotelProviderRequestHandlerImpl;
import com.maf.availablehotel.responsehandler.HotelProviderResponseHandler;
import com.maf.availablehotel.responsehandler.HotelProviderResponseHandlerImpl;

public enum HotelProviderCode {

	CRAZY  {
		@Override
		public HotelProviderRequestHandler getHotelProviderRequestHandler() {
			return new HotelProviderRequestHandlerImpl();
		}

		@Override
		public HotelProviderResponseHandler getHotelProviderResponseHandler() {
			return new HotelProviderResponseHandlerImpl();
		}
	}, BEST{

		@Override
		public HotelProviderRequestHandler getHotelProviderRequestHandler() {
			return new HotelProviderRequestHandlerImpl();
		}

		@Override
		public HotelProviderResponseHandler getHotelProviderResponseHandler() {
			return new HotelProviderResponseHandlerImpl();
		}
		
	};
	
	public abstract HotelProviderRequestHandler getHotelProviderRequestHandler();
	
	public abstract HotelProviderResponseHandler getHotelProviderResponseHandler();
}
