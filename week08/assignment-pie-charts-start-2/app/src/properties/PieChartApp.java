package properties;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.util.converter.NumberStringConverter;

public class PieChartApp extends Application {
	private static final int FIELD_COUNT = 4;


	@Override
	public void start(Stage primaryStage) {
		GridPane root = new GridPane ();
		root.setAlignment(Pos.CENTER);
		root.setHgap(20);
		root.setVgap(10);

		TextField[] inputs = new TextField[FIELD_COUNT];
		Label[] labels = new Label[FIELD_COUNT];
		SimpleIntegerProperty[] integerProperty = new SimpleIntegerProperty[FIELD_COUNT];
		SimpleDoubleProperty[] doubleProperty = new SimpleDoubleProperty[FIELD_COUNT];
		
		for (int i = 0; i < FIELD_COUNT; i++) {

			TextField tf = new TextField("1");
			inputs[i] = tf;
			root.add(tf, 0, i);

			Label lbl = new Label("0.00");
			labels[i] = lbl;
			root.add(lbl, 1, i);

			tf.textProperty().addListener(
					new ChangeListener <String >() {
						@Override
						public void changed (
								ObservableValue <? extends String > observable ,
								String oldValue, String newValue ) {
							if (!newValue.matches("[1-9]\\d{0,3}")) {
								tf.setText(oldValue);
							} } });

			SimpleIntegerProperty intProp = new SimpleIntegerProperty();
			NumberStringConverter converter = new NumberStringConverter();
			tf.textProperty().bindBidirectional(intProp, converter);

			integerProperty[i] = intProp;
		}

		SimpleIntegerProperty sum = new SimpleIntegerProperty();
		sum.bind(
				integerProperty[0]
						.add(integerProperty[1])
						.add(integerProperty[2])
						.add(integerProperty[3])
		);

		for (int i = 0; i < FIELD_COUNT; i++) {
			SimpleDoubleProperty ratio = new SimpleDoubleProperty();
			ratio.bind(
					integerProperty[i].add(0d).divide(sum.add(0d))
			);
			doubleProperty[i] = ratio;

			labels[i].textProperty().bind(
					ratio.asString("%.4f")
			);
		}

		Scene scene = new Scene(root, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Pie‑Chart Generator");
		primaryStage.show();
	}



	public static void main(String[] args) {
		launch(args);
	}

}
