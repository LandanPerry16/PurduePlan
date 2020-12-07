package ldp.e.purdueacademicplan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PlanOverview extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plan_overview);

        //Button button1 = (Button) findViewById(R.id.ButtonReturn);






    }

    public void onClickButton(View view) {
        onBackPressed();
    }
}
