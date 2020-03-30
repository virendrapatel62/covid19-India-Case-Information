package feelfreetocode.models;

import javafx.application.Platform;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.omg.CORBA.INTERNAL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

public class DataCollector {
    private ArrayList<Case> cases = new ArrayList<>();
    private  DataManager dataManager = new DataManager();
    public void collectData() throws  Exception{
        SSLContext context = SSLContext.getInstance("SSL");
        context.init(null , new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }
                }
        },  new SecureRandom());

        HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
        Document document =  Jsoup.connect("https://www.mohfw.gov.in/").get();
//        System.out.println(document);

        Element div = document.getElementById("cases");
        Element table = div.getElementsByTag("table").first();
        Element header = table.getElementsByTag("thead").first();
        Elements columnHeaders = header.getElementsByTag("th");

        System.out.println(columnHeaders.eachText());

        Element tableBody = table.getElementsByTag("tbody").first();
        Elements rows = tableBody.getElementsByTag("tr");

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                int colCount = 5;
                for(int i = 0 ; i < rows.size() ; i++){


                    Elements cols = rows.get(i).getElementsByTag("td");
                    if(i==0){
                        colCount = cols.size();
                    }

                    List<String> colValues = cols.eachText();
                    if (colCount == cols.size()) {
                        Case cs = new Case(i+1 ,
                                colValues.get(1) ,
                                Integer.parseInt(colValues.get(2)),
                                Integer.parseInt(colValues.get(3)) ,
                                Integer.parseInt(colValues.get(4))
                        );
                    cases.add(cs);
                    }


                }

                dataManager.addAll(cases);
            }
        });

    }
}
