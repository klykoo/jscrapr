package com.klykoo.jScrapr;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Scrapr {
	public void scrap(String url) {
		// Clean url to remove all useless params
		url = cleanUrl(url);
		// Find the seller interface
		Class seller = getSeller(url);
		// Invoke seller class scraping
		try {
			Object retour = executerMethode(seller, "maMethode", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Class getSeller(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	private String cleanUrl(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Object executerMethode(Object objet, String nomMethode, Object[] parametres) throws Exception {
		Object retour;
		Class[] typeParametres = null;

		if (parametres != null) {
			typeParametres = new Class[parametres.length];
			for (int i = 0; i < parametres.length; ++i) {
				typeParametres[i] = parametres[i].getClass();
			}
		}

		Method m = objet.getClass().getMethod(nomMethode, typeParametres);
		if (Modifier.isStatic(m.getModifiers())) {
			retour = m.invoke(null, parametres);
		} else {
			retour = m.invoke(objet, parametres);
		}
		return retour;
	}
}
