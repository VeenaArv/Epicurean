package com.example.arvind.epicurean;

        import android.graphics.Typeface;
        import android.support.v4.app.FragmentActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.TextView;
        import android.widget.Button;
        import android.support.v4.app.FragmentTransaction;

        import com.firebase.client.DataSnapshot;
        import com.firebase.client.Firebase;
        import com.firebase.client.FirebaseError;
        import com.firebase.client.ValueEventListener;

public class MainActivity extends FragmentActivity {

    // two instances false: fragment hidden, true: fragment shown
    public boolean isOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        Firebase myFirebaseRef = new Firebase("https://incandescent-fire-2150.firebaseio.com/");
        myFirebaseRef.child("message").setValue("Do you have data? You'll love Firebase.");
        myFirebaseRef.child("message").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println(snapshot.getValue());  //prints "Do you have data? You'll love Firebase."
            }

            @Override public void onCancelled(FirebaseError error) { }

        });
        // Create a button to click once recipe is needed
        Button button = (Button) findViewById(R.id.but);
        TextView recipe = (TextView) findViewById(R.id.recipeBox);
        // new fragment pr
        final PopUpRecipe pr = new PopUpRecipe();
        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.fragment_placeholder, pr, "POPUP");
        ft.hide(pr);
        ft.commit();
      button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                FragmentTransaction f = getSupportFragmentManager().beginTransaction();
                // two instances false: fragment hidden, true: fragment shown
                if (!isOn) {
                    f.show(pr);
                    isOn = true;
                } else {
                    f.hide(pr);
                    isOn = false;
                }
                f.commit();
                return true;
            }
        });

    }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

}