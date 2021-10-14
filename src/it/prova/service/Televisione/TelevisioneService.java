package it.prova.service.Televisione;

import java.util.List;

import it.prova.dao.televisore.TelevisoreDAO;
import it.prova.model.Televisione;

public interface TelevisioneService {

	public void setTelevisoreDao(TelevisoreDAO televisoreDAO);

	public List<Televisione> listAll() throws Exception;

	public Televisione findById(Long idInput) throws Exception;

	public int aggiorna(Televisione input) throws Exception;

	public int inserisciNuovo(Televisione input) throws Exception;

	public int rimuovi(Televisione input) throws Exception;

	public List<Televisione> findByExample(Televisione input) throws Exception;
}
