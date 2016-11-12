package freexbarcode.qrgenerator;

import android.graphics.Bitmap;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    //Spinner spinner_outtype;
    //EditText amountout;
    //Spinner spinner_intype;
    EditText rate;


    Button ge_btn;
    ImageView image;
    String textQR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //spinner_outtype = (Spinner)findViewById(R.id.spinner_outtype);
        //amountout = (EditText) findViewById(R.id.amountout);
        //spinner_intype = (Spinner) findViewById(R.id.spinner_intype);
        rate = (EditText) findViewById(R.id.rate);
        ge_btn = (Button) findViewById(R.id.ge_btn);
        image = (ImageView) findViewById(R.id.image);

        ge_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textQR = rate.getText().toString().trim();
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try{
                    BitMatrix bitMatrix = multiFormatWriter.encode(textQR, BarcodeFormat.QR_CODE,200,200);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    image.setImageBitmap(bitmap);
                }
                catch (WriterException e){
                    e.printStackTrace();
                }
            }
        });


    }
}
