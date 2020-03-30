package feelfreetocode;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import feelfreetocode.models.DataCollector;
import feelfreetocode.models.DataManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.HttpURLConnection;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{



        Parent root = FXMLLoader.load(getClass().getResource("fxmls/Main.fxml"));
        primaryStage.setTitle("Covid 19 Information");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        primaryStage.setMaximized(true);
    }


    public static void main(String[] args) throws Exception{
        launch(args);


    }
}
