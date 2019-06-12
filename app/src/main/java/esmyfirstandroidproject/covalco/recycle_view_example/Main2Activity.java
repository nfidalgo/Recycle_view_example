package esmyfirstandroidproject.covalco.recycle_view_example;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private RecyclerView recyclerViewUser;
    private RecyclerView.Adapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.w("hola Mundo", "Entramos en onCreate");

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("key_name", "string value"); // Storing string
        /*editor.putBoolean("key_name", true); // Storing boolean - true/false
        editor.putInt("key_name", 1); // Storing integer
        editor.putFloat("key_name", 2.4F); // Storing float
        editor.putLong("key_name", 3L); // Storing long*/

        editor.commit(); // commit changes
        String sh = " ";
        try {
             sh = pref.getString("key_name", null); // getting String
        }
        catch (Exception ex){
            Log.e("Covalco-MainActivity", ex.getMessage() + " " + ex.getStackTrace() );
        }

        Toast toast=Toast.makeText(getApplicationContext(),
                BuildConfig.FLAVOR + " " +
                        sh+ " " +
                BuildConfig.ENDPOINT,Toast.LENGTH_LONG);
        toast.setMargin(50,50);
        toast.show();
        recyclerViewUser = (RecyclerView) findViewById(R.id.reyclerViewUser);

        recyclerViewUser.setHasFixedSize(true);

        recyclerViewUser.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new UserAdapter(getData());
        recyclerViewUser.setAdapter(mAdapter);
    }

    public List<UserModel> getData(){
        List<UserModel> userModel = new  ArrayList<>();
        userModel.add(new UserModel("Gustavo"));
        userModel.add(new UserModel("Daniel"));
        userModel.add(new UserModel("Cecilia"));
        userModel.add(new UserModel("Diego"));
        userModel.add(new UserModel("Carlos"));
        userModel.add(new UserModel("Juan"));

        for(int i = 1; i < 15; i++){
            userModel.add(new UserModel( "Name " + i));
        }
        return userModel;

    }
}
