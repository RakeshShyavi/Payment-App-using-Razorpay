package com.example.razorpay;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements PaymentResultListener {

    // variables for edit ext and button.
    private EditText amountEdt;
    private EditText idname;
    private EditText idusn;
    private EditText idemail;
    private EditText idphone;
    private Button payBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing all our variables.
        amountEdt = findViewById(R.id.idAmount);
        payBtn = findViewById(R.id.idBtnPay);
        idname = findViewById(R.id.name);
        idusn = findViewById(R.id.usn);
        idemail = findViewById(R.id.email);
        idphone = findViewById(R.id.phone);

        // adding on click listener to our button.
        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting
                // amount that is entered by user.
                String sAmount = amountEdt.getText().toString();
                String usn = idusn.getText().toString();
                String name = idname.getText().toString();
                String phone = idphone.getText().toString();
                String email = idemail.getText().toString();
                // rounding off the amount.
                int amount = Math.round(Float.parseFloat(sAmount) * 100);

                // initialize Razorpay account.
                Checkout checkout = new Checkout();

                // set your id as below
                checkout.setKeyID("rzp_test_XU3Qiw0dILWizs");

                // set image
//                checkout.setImage(R.drawable.logo);

                // initialize json object
                JSONObject object = new JSONObject();
                try {
                    // to put name
                    object.put("name", "Bangalore Institute of Technology");

                    // put description
                    object.put("description", name + " - " + usn);

                    // to set theme color
                    object.put("theme.color", "#50C878");

                    // put the currency
                    object.put("currency", "INR");

                    // put amount
                    object.put("amount", amount);

                    // put mobile number
                    object.put("prefill.contact", phone);

                    // put email
                    object.put("prefill.email", email);

                    // open razorpay to checkout activity
                    checkout.open(MainActivity.this, object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onPaymentSuccess(String s) {
        // this method is called on payment success.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Payment ID");
        builder.setMessage("Please note this ID for future reference\n"+s);
//        builder.setMessage(s);
        builder.show();
        Toast.makeText(this, "Payment is successful : " + s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        // on payment failed.
        Toast.makeText(this, "Payment Failed due to error : " + s, Toast.LENGTH_SHORT).show();
    }
}
