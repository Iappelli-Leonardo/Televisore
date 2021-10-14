package it.prova.service;

import it.prova.dao.televisore.TelevisoreDAOImpl;
import it.prova.service.Televisione.TelevisioneService;
import it.prova.service.Televisione.TelevisioneServiceImpl;

public class MyServiceFactory {
	
	public static TelevisioneService getTelevisioneService() {
		TelevisioneService televisioneService = new TelevisioneServiceImpl();
		televisioneService.setTelevisoreDao(new TelevisoreDAOImpl());
		return televisioneService;
	}
	
}
