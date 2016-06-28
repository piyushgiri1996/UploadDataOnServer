package hello.ducat.com.uploaddataonserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btn;
    //String url="http://volleywebhosting.coolpage.biz/Myinsertdemo.php";
    String url="http://volleywebhosting.coolpage.biz/newmydelete.php";

RequestQueue requestQueue;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= (EditText) findViewById(R.id.editText);
        btn= (Button) findViewById(R.id.button);
        requestQueue= Volley.newRequestQueue(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s=editText.getText().toString();
                StringRequest stringRequest=new StringRequest
                        (Request.Method.POST, url,
                                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Toast.makeText(MainActivity.this, ""+s,
                                Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError
                                                        volleyError) {
                        Toast.makeText(MainActivity.this,
                                ""+volleyError, Toast.LENGTH_SHORT).show();

                    }

                }){
                    @Override
                    protected Map<String, String> getParams() throws
                            AuthFailureError {
                        Map<String,String> params=new HashMap
                                <String, String>();
                        params.put("Name",s);

                        return params;
                    }
                };

                requestQueue.add(stringRequest);




            }
        });

    }
}
