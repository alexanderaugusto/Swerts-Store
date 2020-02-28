package br.inatel.swertsstore.util;

/*
    *** CLASSE BUSCA CEP ***

Objetivo: Buscar os dados de endereço a partir de um CEP inserido pelo usuário. 

*/

import br.inatel.swertsstore.util.Webservicecep;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class BuscaCep {

    public static Webservicecep getEndereco(String cep) throws JAXBException, MalformedURLException {

        JAXBContext jc = JAXBContext.newInstance(Webservicecep.class);

        Unmarshaller u = jc.createUnmarshaller();
        URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
        Webservicecep wCep = (Webservicecep) u.unmarshal(url);

        return wCep;

    }

}
