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
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.Fragment;
        import android.support.v7.app.ActionBarActivity;



public class MainActivity extends FragmentActivity {
    // two instances false: fragment hidden, true: fragment shown
    public boolean isOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a button to click once recipe is needed (in progress)
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