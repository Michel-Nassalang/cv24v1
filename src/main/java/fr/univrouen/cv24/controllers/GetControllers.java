package fr.univrouen.cv24.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.TestCV;
import utils.Fichier;

@RestController
public class GetControllers {
	@GetMapping("/resume")
		public String getListCVinXML() {
		return "Envoi de la liste des CV";
	}
	@GetMapping("/cvid")
	public String getCVinXML(
			@RequestParam(value = "texte") String texte) {
		return ("Détail du CV n°" + texte);
	}
	
	@GetMapping("/test")
	public String getTestIdTitre(
			@RequestParam(value="id")int id, 
			@RequestParam(value="titre") String titre) {
		return "Test: \n" + "id = "+ id + "\ntitre = " + titre;
	}
	
	@GetMapping("/testfic")
	public ResponseEntity<String> testFichier() {
	    Fichier fichier = new Fichier();
	    String contenuFichier = fichier.loadFileXMLSmallCv();
	    return ResponseEntity.ok(contenuFichier);
	}
	
	@GetMapping("/testcv")
	public ResponseEntity<String> testFichierCv24() {
	    Fichier fichier = new Fichier();
	    String contenuFichier = fichier.loadFileXMLCv24();
	    return ResponseEntity.ok(contenuFichier);
	}
	
	@RequestMapping(value="/testxml", produces=MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody TestCV getXML() {
	TestCV cv = new TestCV("HAMILTON","Margaret","1969/07/21", 
	"Appollo11@nasa.us");
	return cv;
	}

}
