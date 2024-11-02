package com.example.constat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText dateAcc, lieuAcc, temois;
    RadioGroup blesseGroup, degatGroup;
    RadioButton blesoui, blesnon, degatoui, degatnon;
    FirebaseFirestore db;
    EditText V1, marque1, matricule1, venat1, allant1, nom1, prenom1, adress1, steac1;
    EditText attestation1, police1, carteV1, dateAttestation1, agence1;
    EditText Condnom1, Condprenom1, CondAdress1, Condpermis1, delivre1, prefecture1, datePermis1;
    EditText V2, marque2, matricule2, venat2, allant2, nom2, prenom2, adress2, steac2;
    EditText attestation2, police2, carteV2, dateAttestation2, agence2;
    EditText Condnom2, Condprenom2, CondAdress2, Condpermis2, delivre2, prefecture2, datePermis2;
    Button CreateCons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateAcc = findViewById(R.id.dateacc);
        lieuAcc = findViewById(R.id.lieuacc);
        temois = findViewById(R.id.Temois);
//        blesseGroup = findViewById(R.id.blesoui);
        blesoui = findViewById(R.id.blesoui);
        blesnon = findViewById(R.id.blesnon);
//        degatGroup = findViewById(R.id.degatoui);
        degatoui = findViewById(R.id.degatoui);
        degatnon = findViewById(R.id.degatnon);
        V1 = findViewById(R.id.V1);
        marque1 = findViewById(R.id.marque1);
        matricule1 = findViewById(R.id.matricule1);
        venat1 = findViewById(R.id.venat1);
        allant1 = findViewById(R.id.allant1);
        nom1 = findViewById(R.id.nom1);
        prenom1 = findViewById(R.id.prenom1);
        adress1 = findViewById(R.id.adress1);
        steac1 = findViewById(R.id.steac1);
        attestation1 = findViewById(R.id.attestation1);
        police1 = findViewById(R.id.police1);
        carteV1 = findViewById(R.id.carteV1);
        dateAttestation1 = findViewById(R.id.dateAttestation1);
        agence1 = findViewById(R.id.agence1);
        Condnom1 = findViewById(R.id.Condnom1);
        Condprenom1 = findViewById(R.id.Condprenom1);
        CondAdress1 = findViewById(R.id.CondAdress1);
        Condpermis1 = findViewById(R.id.Condpermis1);
        delivre1 = findViewById(R.id.delivre1);
        prefecture1 = findViewById(R.id.prefecture1);
        datePermis1 = findViewById(R.id.datePermis1);
        V2 = findViewById(R.id.V2);
        marque2 = findViewById(R.id.marque2);
        matricule2 = findViewById(R.id.matricule2);
        venat2 = findViewById(R.id.venat2);
        allant2 = findViewById(R.id.allant2);
        nom2 = findViewById(R.id.nom2);
        prenom2 = findViewById(R.id.prenom2);
        adress2 = findViewById(R.id.adress2);
        steac2 = findViewById(R.id.steac2);
        attestation2 = findViewById(R.id.attestation2);
        police2 = findViewById(R.id.police2);
        carteV2 = findViewById(R.id.carteV2);
        dateAttestation2 = findViewById(R.id.dateAttestation2);
        agence2 = findViewById(R.id.agence2);
        Condnom2 = findViewById(R.id.Condnom2);
        Condprenom2 = findViewById(R.id.Condprenom2);
        CondAdress2 = findViewById(R.id.CondAdress2);
        Condpermis2 = findViewById(R.id.Condpermis2);
        delivre2 = findViewById(R.id.delivre2);
        prefecture2 = findViewById(R.id.prefecture2);
        datePermis2 = findViewById(R.id.datePermis2);
        CreateCons=findViewById(R.id.CreateCons);
        db = FirebaseFirestore.getInstance();
        CreateCons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveVehicule1();
                saveVehicule2();
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

    }
    private void saveVehicule1() {
        // Get the input values from EditText fields
        String dateAccText = dateAcc.getText().toString();
        String lieuAccText = lieuAcc.getText().toString();
        String temoisText = temois.getText().toString();
        boolean isBlesse = blesoui.isChecked();
        boolean isDegat = degatoui.isChecked();
        String V1Text = V1.getText().toString();
        String marque1Text = marque1.getText().toString();
        String matricule1Text = matricule1.getText().toString();
        String venat1Text = venat1.getText().toString();
        String allant1Text = allant1.getText().toString();
        String nom1Text = nom1.getText().toString();
        String prenom1Text = prenom1.getText().toString();
        String adress1Text = adress1.getText().toString();
        String steac1Text = steac1.getText().toString();
        String attestation1Text = attestation1.getText().toString();
        String police1Text = police1.getText().toString();
        String carteV1Text = carteV1.getText().toString();
        String dateAttestation1Text = dateAttestation1.getText().toString();
        String agence1Text = agence1.getText().toString();
        String Condnom1Text = Condnom1.getText().toString();
        String Condprenom1Text = Condprenom1.getText().toString();
        String CondAdress1Text = CondAdress1.getText().toString();
        String Condpermis1Text = Condpermis1.getText().toString();
        String delivre1Text = delivre1.getText().toString();
        String prefecture1Text = prefecture1.getText().toString();
        String datePermis1Text = datePermis1.getText().toString();

        // Create a map to store the data
        Map<String, Object> data = new HashMap<>();
        data.put("Vehicule", V1Text);
        data.put("MarqueType", marque1Text);
        data.put("NumeroImmatricul", matricule1Text);
        data.put("VenatDe", venat1Text);
        data.put("AllantVers", allant1Text);
        data.put("NomAssure", nom1Text);
        data.put("PrenomAssure", prenom1Text);
        data.put("AdresseAssure", adress1Text);
        data.put("SteAssurance", steac1Text);
        data.put("NumeroAttestation", attestation1Text);
        data.put("NumeroPolice", police1Text);
        data.put("CarteVerte", carteV1Text);
        data.put("AttestationValable", dateAttestation1Text);
        data.put("Agence", agence1Text);
        data.put("NomConducteur", Condnom1Text);
        data.put("PrenomConducteur", Condprenom1Text);
        data.put("AdresseConducteur", CondAdress1Text);
        data.put("PermisConduire", Condpermis1Text);
        data.put("DelivreLe", delivre1Text);
        data.put("Prefecture", prefecture1Text);
        data.put("PermisValableJusquau", datePermis1Text);
        data.put("DateAccident", dateAccText);
        data.put("LieuAccident", lieuAccText);
        data.put("Temois", temoisText);
        data.put("Blesses", isBlesse ? "Oui" : "Non");
        data.put("DegatsMateriels", isDegat ? "Oui" : "Non");

        // Save the data to Firestore
        db.collection("constatVehicule1")
                .add(data)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(MainActivity.this, "Data saved successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Failed to save data", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void saveVehicule2() {
        // Get the input values from EditText fields
        String dateAccText = dateAcc.getText().toString();
        String lieuAccText = lieuAcc.getText().toString();
        String temoisText = temois.getText().toString();
        boolean isBlesse = blesoui.isChecked();
        boolean isDegat = degatoui.isChecked();
        String V2Text = V2.getText().toString();
        String marque2Text = marque2.getText().toString();
        String matricule2Text = matricule2.getText().toString();
        String venat2Text = venat2.getText().toString();
        String allant2Text = allant2.getText().toString();
        String nom2Text = nom2.getText().toString();
        String prenom2Text = prenom2.getText().toString();
        String adress2Text = adress2.getText().toString();
        String steac2Text = steac2.getText().toString();
        String attestation2Text = attestation2.getText().toString();
        String police2Text = police2.getText().toString();
        String carteV2Text = carteV2.getText().toString();
        String dateAttestation2Text = dateAttestation2.getText().toString();
        String agence2Text = agence2.getText().toString();
        String Condnom2Text = Condnom2.getText().toString();
        String Condprenom2Text = Condprenom2.getText().toString();
        String CondAdress2Text = CondAdress2.getText().toString();
        String Condpermis2Text = Condpermis2.getText().toString();
        String delivre2Text = delivre2.getText().toString();
        String prefecture2Text = prefecture2.getText().toString();
        String datePermis2Text = datePermis2.getText().toString();

        // Create a map to store the data
        Map<String, Object> data = new HashMap<>();
        data.put("Vehicule", V2Text);
        data.put("MarqueType", marque2Text);
        data.put("NumeroImmatricul", matricule2Text);
        data.put("VenatDe", venat2Text);
        data.put("AllantVers", allant2Text);
        data.put("NomAssure", nom2Text);
        data.put("PrenomAssure", prenom2Text);
        data.put("AdresseAssure", adress2Text);
        data.put("SteAssurance", steac2Text);
        data.put("NumeroAttestation", attestation2Text);
        data.put("NumeroPolice", police2Text);
        data.put("CarteVerte", carteV2Text);
        data.put("AttestationValable", dateAttestation2Text);
        data.put("Agence", agence2Text);
        data.put("NomConducteur", Condnom2Text);
        data.put("PrenomConducteur", Condprenom2Text);
        data.put("AdresseConducteur", CondAdress2Text);
        data.put("PermisConduire", Condpermis2Text);
        data.put("DelivreLe", delivre2Text);
        data.put("Prefecture", prefecture2Text);
        data.put("PermisValableJusquau", datePermis2Text);
        data.put("DateAccident", dateAccText);
        data.put("LieuAccident", lieuAccText);
        data.put("Temois", temoisText);
        data.put("Blesses", isBlesse ? "Oui" : "Non");
        data.put("DegatsMateriels", isDegat ? "Oui" : "Non");

        // Save the data to Firestore
        db.collection("constatVehicule2")
                .add(data)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(MainActivity.this, "Data saved successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Failed to save data", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}