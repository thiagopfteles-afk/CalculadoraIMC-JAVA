import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProjetoCalculadoraIMC extends Application {

    @Override
    public void start(Stage palco) {

        // Etiquetando as entradas com Label
        Label etiquetaPeso = new Label("Peso");
        Label etiquetaAltura = new Label("Altura");

        TextField campoPeso = new TextField();
        campoPeso.setPromptText("Peso em kg");

        TextField campoAltura = new TextField();
        campoAltura.setPromptText("Altura em cm");

        // Mostrando resultados
        Label etiquetaResultado = new Label();

        // Botão
        Button botaoCalcular = new Button("Calcular o IMC");

        botaoCalcular.setOnAction(e -> {
            try{ 

            double peso = Double.parseDouble(campoPeso.getText());
            double alturaCm = Double.parseDouble(campoAltura.getText());
            double alturaM = alturaCm / 100.0; // converter cm para metros

            double imc = peso / (alturaM * alturaM);

            etiquetaResultado.setText(String.format("Seu IMC é: %.2f", imc));

            }catch (NumberFormatException ex){
                etiquetaResultado.setText("Por favor, insira números valdos para peso e altura");
            }

        });

        // Layout vertical
        VBox layout = new VBox(10, etiquetaPeso, campoPeso, etiquetaAltura, campoAltura, botaoCalcular, etiquetaResultado);
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);

        Scene cena = new Scene(layout, 500, 500);

        palco.setTitle("Calculadora de IMC");
        palco.setScene(cena);
        palco.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}