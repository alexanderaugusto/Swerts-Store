package br.inatel.swertsstore.util;

/*
    *** CLASSE CALCULA FRETE E PRAZO ***

Objetivo: Calcular o valor do frete e seu prazo de entrega a partir de um CEP inserido pelo usuário. 

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class CalculaFretePrazo {
    
    //Atributos
    private String prazoEntregaProduto;
    private String valorEntregaProduto;
    String prazoFinal; 
       
    // Método getter para retorna o valor final 
    public String getValorEntregaProduto() 
    {
        return valorEntregaProduto;
    }

    public String getPrazoEntregaProduto() {
        
        return prazoEntregaProduto;
        
    }
    

    @SuppressWarnings("rawtypes")
    public void calculaFrete( String cepDest, String cdServ ,double quant ) {
        // Dados pesquisa
        String nCdEmpresa = "";
        String sDsSenha = "";
        //Determinando o Cep destino e o tipo de serviço 
        String sCepDestino = cepDest;
        String nCdServico = cdServ;
        
        //CEP de Sta Rita - ORIGEM 
        String sCepOrigem = "37540-000";
        //Peso do produto
        double pesoPorUnidadeAux = 1.230; 
        Double calcular;
        // Quantidade de produto - Fornecido pelo usuário
        double quantidade = 1; //No mínimo 1 item
        quantidade = quant; 
        // Calculo do peso final 
        calcular = quantidade * pesoPorUnidadeAux;
        String nVlPeso = calcular.toString();
        String nCdFormato = "1";
        //Dimensões da Caixa 
        String nVlComprimento = "30"; 
        String nVlAltura = "30"; 
        String nVlLargura = "30"; 
        String nVlDiametro = "0";
        String sCdMaoPropria = "n";
        String nVlValorDeclarado = "0";
        String sCdAvisoRecebimento = "n";
        String StrRetorno = "xml";

        // URL do webservice correio para calculo de frete
        String urlString = "http://ws.correios.com.br/calculador/CalcPrecoPrazo.aspx";

        // os parametros a serem enviados
        Properties parameters = new Properties();

        parameters.setProperty("nCdEmpresa", nCdEmpresa);
        parameters.setProperty("sDsSenha", sDsSenha);
        parameters.setProperty("nCdServico", nCdServico);
        parameters.setProperty("sCepOrigem", sCepOrigem);
        parameters.setProperty("sCepDestino", sCepDestino);
        parameters.setProperty("nVlPeso", nVlPeso);
        parameters.setProperty("nCdFormato", nCdFormato);
        parameters.setProperty("nVlComprimento", nVlComprimento);
        parameters.setProperty("nVlAltura", nVlAltura);
        parameters.setProperty("nVlLargura", nVlLargura);
        parameters.setProperty("nVlDiametro", nVlDiametro);
        parameters.setProperty("sCdMaoPropria", sCdMaoPropria);
        parameters.setProperty("nVlValorDeclarado", nVlValorDeclarado);
        parameters.setProperty("sCdAvisoRecebimento", sCdAvisoRecebimento);
        parameters.setProperty("StrRetorno", StrRetorno);

        // o iterador, para criar a URL
        Iterator i = parameters.keySet().iterator();
        // o contador
        int counter = 0;

        // enquanto ainda existir parametros
        while (i.hasNext()) {

            // pega o nome
            String name = (String) i.next();
            // pega o valor
            String value = parameters.getProperty(name);

            // adiciona com um conector (? ou &)
            // o primeiro é ?, depois são &
            urlString += (++counter == 1 ? "?" : "&") + name + "=" + value;

        }

        try {
            // cria o objeto url
            URL url = new URL(urlString);

            // cria o objeto httpurlconnection
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();

            // seta o metodo
            connection.setRequestProperty("Request-Method", "GET");

            // seta a variavel para ler o resultado
            connection.setDoInput(true);
            connection.setDoOutput(false);

            // conecta com a url destino
            connection.connect();

            // abre a conexão pra input
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));

            // le ate o final
            StringBuffer newData = new StringBuffer();
            String s = "";
            while (null != ((s = br.readLine()))) {
                newData.append(s);
            }
            br.close();

            // Prepara o XML que está em string para executar leitura por nodes
            DocumentBuilder db = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(newData.toString()));
            Document doc = db.parse(is);
            NodeList nodes = doc.getElementsByTagName("cServico");

            // Faz a leitura dos nodes
            for (int j = 0; j < nodes.getLength(); j++) {
                Element element = (Element) nodes.item(j);

                NodeList valor = element.getElementsByTagName("Valor");
                NodeList prazoEntrega = element.getElementsByTagName("PrazoEntrega");

                Element line = (Element) valor.item(0);
                Element prazo = (Element) prazoEntrega.item(0);
                
                //Armazenando os valores de PRAZO 
                prazoEntregaProduto = getCharacterDataFromElement(prazo);
                valorEntregaProduto = getCharacterDataFromElement(line);
                
                 
                NodeList erro = element.getElementsByTagName("MsgErro");
		line = (Element) erro.item(0);
                //System.out.println("Erro: " + getCharacterDataFromElement(line));
            }

        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println("Erro " + e);
        }
        
    }

    public static String getCharacterDataFromElement(Element e) {
        Node child = e.getFirstChild();
        if (child instanceof CharacterData) {
            CharacterData cd = (CharacterData) child;
            return cd.getData();
        }
        return "";
    }
    
      
     
}

