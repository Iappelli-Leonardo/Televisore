package it.prova.test;

import java.util.Date;
import java.util.List;

import it.prova.model.Televisione;
import it.prova.service.MyServiceFactory;
import it.prova.service.Televisione.TelevisioneService;

public class TestTelevisore {

	public static void main(String[] args) {

		// parlo direttamente con il service
		TelevisioneService userService = MyServiceFactory.getTelevisioneService();

		try {

			// ora con il service posso fare tutte le invocazioni che mi servono
			System.out.println("In tabella ci sono " + userService.listAll().size() + " elementi.");

			testInserimentoNuovoUser(userService);
			System.out.println("In tabella ci sono " + userService.listAll().size() + " elementi.");

			testRimozioneUser(userService);
			System.out.println("In tabella ci sono " + userService.listAll().size() + " elementi.");

			testFindByExample(userService);
			System.out.println("In tabella ci sono " + userService.listAll().size() + " elementi.");

			testUpdateTeleviore(userService);
			System.out.println("In tabella ci sono " + userService.listAll().size() + " elementi.");

			// E TUTTI I TEST VANNO FATTI COSI'

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void testInserimentoNuovoUser(TelevisioneService televisioneService) throws Exception {
		System.out.println(".......testInserimentoNuovoUser inizio.............");
		Televisione newUserInstance = new Televisione("samsung", "rsjj", new Date());
		if (televisioneService.inserisciNuovo(newUserInstance) != 1)
			throw new RuntimeException("testInserimentoNuovoUser fallito ");

		System.out.println("inserito nuovo record: " + newUserInstance);
		System.out.println(".......testInserimentoNuovoUser fine.............");
	}

	private static void testRimozioneUser(TelevisioneService televisioneService) throws Exception {
		System.out.println(".......testRimozioneUser inizio.............");
		// recupero tutti gli user
		List<Televisione> interoContenutoTabella = televisioneService.listAll();
		if (interoContenutoTabella.isEmpty() || interoContenutoTabella.get(0) == null)
			throw new Exception("Non ho nulla da rimuovere");

		Long idDelPrimo = interoContenutoTabella.get(0).getId();
		// ricarico per sicurezza con l'id individuato
		Televisione toBeRemoved = televisioneService.findById(idDelPrimo);
		System.out.println("User candidato alla rimozione: " + toBeRemoved);
		if (televisioneService.rimuovi(toBeRemoved) != 1)
			throw new RuntimeException("testRimozioneUser fallito ");

		System.out.println("rimosso record: " + toBeRemoved);
		System.out.println(".......testRimozioneUser fine.............");
	}

	private static void testFindByExample(TelevisioneService televisioneService) throws Exception {
		System.out.println(".......testFindByExample inizio.............");
		// inserisco i dati che poi mi aspetto di ritrovare
		televisioneService.inserisciNuovo(new Televisione("samsung", "dgg", new Date()));
		televisioneService.inserisciNuovo(new Televisione("shilps", "es4", new Date()));

		// preparo un example che ha come marca 'as' e ricerco
		List<Televisione> risultatifindByExample = televisioneService.findByExample(new Televisione("s"));
		if (risultatifindByExample.size() != 2)
			throw new RuntimeException("testFindByExample fallito ");

		// se sono qui il test è ok quindi ripulisco i dati che ho inserito altrimenti
		// la prossima volta non sarebbero 2 ma 4, ecc.
		for (Televisione userItem : risultatifindByExample) {
			televisioneService.rimuovi(userItem);
		}

		System.out.println(".......testFindByExample fine.............");
	}

	private static void testUpdateTeleviore(TelevisioneService televisioneService) throws Exception {
		System.out.println(".......testUpdateTelevisione inizio.............");

		// inserisco i dati che poi modifico
		if (televisioneService.inserisciNuovo(new Televisione("sony", "bravia", new Date())) != 1)
			throw new RuntimeException("testUpdateUser: inserimento preliminare fallito ");

		// recupero col findbyexample e mi aspetto di trovarla
		List<Televisione> risultatifindByExample = televisioneService.findByExample(new Televisione("sony", "bravia"));
		if (risultatifindByExample.size() != 1)
			throw new RuntimeException("testUpdateUser: testFindByExample fallito ");

		Long idGiovanna = risultatifindByExample.get(0).getId();
		// ricarico per sicurezza con l'id individuato e gli modifico un campo
		String nuovoCogmarca = "Perastra";
		Televisione toBeUpdated = televisioneService.findById(idGiovanna);
		toBeUpdated.setModello(nuovoCogmarca);
		System.out.println("User candidato alla modifica: " + toBeUpdated);
		if (televisioneService.aggiorna(toBeUpdated) != 1)
			throw new RuntimeException("testUpdateUser fallito ");

		System.out.println("aggiornato record: " + toBeUpdated);
		System.out.println(".......testUpdateTelevisione inizio.............");
	}

}
