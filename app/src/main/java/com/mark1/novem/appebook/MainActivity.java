package com.mark1.novem.appebook;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);

        listView = (ListView) findViewById(R.id.listView);

        SynProduct synProduct = new SynProduct(this, listView);
        synProduct.execute();

    }   // Main Method

    //Create Inner Class
    private class SynProduct extends AsyncTask<Void, Void, String> {

        //Explicit
        private Context context;
        private ListView myListView;
        private static final String urlJSON = "http://swiftcodingthai.com/aun/get_data_master.php";

        public SynProduct(Context context, ListView myListView) {
            this.context = context;
            this.myListView = myListView;
        }

        @Override
        protected String doInBackground(Void... voids) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(urlJSON).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();

            } catch (Exception e) {
                Log.d("AppEbookV1", "e doIn ==> " + e.toString());
                return null;
            }


        }   // doInBack

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("AppEbookV1", "JSON ==> " + s);

        }   // onPost

    }   // SynProduct

}   // Main Class
