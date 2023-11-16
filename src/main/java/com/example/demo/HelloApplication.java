package com.example.demo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.util.List;
import java.util.ArrayList;



public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {


        GridPane g1 = new GridPane();
//        g1.setGridLinesVisible(true); // Optional: To visualize the grid lines

        // Set column constraints to make the column expand to the available space
//        ColumnConstraints column = new ColumnConstraints();
//        column.setHgrow(javafx.scene.layout.Priority.ALWAYS);
//        g1.getColumnConstraints().addAll(new ColumnConstraints(), column, new ColumnConstraints());

        Scene scene = new Scene(g1, 500, 400, Color.GRAY);
        stage.setResizable(false);
        stage.setTitle("Hello to my world");

        Text t1 = new Text("Login Interface...");
        t1.setFont(Font.font("Times new Roman", 30));
        t1.setTextAlignment(TextAlignment.CENTER);
       g1.setPadding(new Insets(10,10,10,10));
g1.setHgap(5);
g1.setVgap(5);

        g1.add(t1, 1, 1);
        GridPane.setHalignment(t1, HPos.CENTER);
        Text txt1=new Text("Email Id:");
        Text txt2=new Text("Password:");
        g1.add(txt2,1,3);
        g1.add(txt1,1,2);
        txt1.setFont(Font.font("Times new Roman",20));
        txt2.setFont(Font.font("Times new Roman",20));

        Button b1=new Button("Login");
        Button b2=new Button("Exit");
        b1.setBackground(Background.fill(Color.BLUE));
        b2.setBackground(Background.fill(Color.BLUE));
        b1.setMinSize(20,20);
        b2.setMinSize(50,30);
        b1.setFont(Font.font("times new roman",15));
        b2.setFont(Font.font("times new roman",15));

        b1.setTextFill(Color.WHITE);
        b2.setTextFill(Color.WHITE);

g1.add(b1,2,5);
g1.add(b2,3,5);

        TextField text=new TextField();
      g1.add(text,2,2);
        PasswordField p1=new PasswordField();
        g1.add(p1,2,3);

b2.setOnAction(e->{
    Platform.exit();

});

        b1.setOnAction(e->{
            String email=text.getText();
            String password=p1.getText();
            if(isValidEmail(email) && isValidPassword(password)){
                Text t3=new Text("loging in successfullyy..");
                g1.add(t3,1,6);

                GridPane grid2 = new GridPane();
                Text welcomeText = new Text("Welcome, User!");
                welcomeText.setFont(Font.font("Times New Roman", 20));
                GridPane.setHalignment(welcomeText, HPos.CENTER);

                Text status=new Text("Check your vaccination status...");
                Text enroll=new Text("Enroll yourself for the vaccination...");
                Text verify=new Text("Verify yourself here...");

                status.setFont(Font.font("Times new Roman",20));
                enroll.setFont(Font.font("Times new Roman",20));
                verify.setFont(Font.font("Times new Roman",20));

                Button statusbutton=new Button("Status");
                Button enrollbutton=new Button("enroll");
                Button verifybutton=new Button("verify");

                statusbutton.setOnAction(p->{
                    GridPane grid3 = new GridPane();
                    Text check= new Text("Enter your CNIC here");
                    check.setFont(Font.font("Times New Roman", 20));
                    grid3.add(check,0,0);

                    TextField cnic=new TextField();
                    grid3.add(cnic,1,1);

                    Button submit1=new Button("Submit");
                    submit1.setBackground(Background.fill(Color.RED));
                    submit1.setTextFill(Color.WHITE);
                    grid3.add(submit1,1,2);

                    grid3.setVgap(10);
                    grid3.setHgap(10);

                    submit1.setOnAction(w->{
                      String cnic1=cnic.getText();



                    });

                    Scene s3 = new Scene(grid3, 500, 400, Color.LIGHTBLUE);

                    stage.setScene(s3);
                    stage.show();

                });

                statusbutton.setTextFill(Color.WHITE);
                enrollbutton.setTextFill(Color.WHITE);
                verifybutton.setTextFill(Color.WHITE);

                grid2.setVgap(10);
                grid2.setHgap(10);

                statusbutton.setBackground(Background.fill(Color.BLUE));
                enrollbutton.setBackground(Background.fill(Color.BLUE));
                verifybutton.setBackground(Background.fill(Color.BLUE));

                grid2.add(status,0,1);
                grid2.add(statusbutton,1,1);
                grid2.add(enroll,0,2);
                grid2.add(enrollbutton,1,2);
                grid2.add(verify,0,3);
                grid2.add(verifybutton,1,3);




                grid2.add(welcomeText, 0, 0);
                Scene scene2 = new Scene(grid2, 500, 400, Color.LIGHTBLUE);

                stage.setScene(scene2);
            stage.show();

            }
            else{
                Text t4=new Text("invalid username and password");
                g1.add(t4,1,7);

            }


        });


        stage.setScene(scene);
        stage.show();



    }


    private boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains("gmail.com");
    }

    private boolean isValidPassword(String password) {
        return password != null && !password.trim().isEmpty() && password.length() >= 6;
    }

    public static void main(String[] args) {
        launch();
    }
}
