/*
==============================================================================================================

  Title: Pavers Unlimited
  Description:
  This application estimate the cost to pave a driveway and the sidewalks around a house.
  Application calculates the Labor Cost ($50/hr),
  Calculates the estimated cost to use asphalt  ($25 per square yard/meter)
  and estimated cost to use concrete  ($75 per square yard/meter).


======================================================================================
========================
*/


package wsu.csc5991.application1;


/*------------------------------------
 Import Android packages
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/*--------------------------------------------------------------
  Class ActMain
--------------------------------------------------------------
*/
public class ActMain extends AppCompatActivity {

    /*--------------------------------------------------------------
        Declare Variables
    -------------------------------------------------------------
    */


    private EditText drivewaySizeText;

    private EditText sideWalkSizeText;
    private EditText noOfHoursText;
    private EditText laborCostText;
    private EditText asphaltCostText;
    private EditText concreteCostText;
    private Button estimatedCost;


    /*--------------------------------------------------------------
           onCreate
     --------------------------------------------------------------
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.laymain);

        drivewaySizeText = (EditText) findViewById(R.id.drivewaySize);

        sideWalkSizeText = (EditText) findViewById(R.id.sideWalkSize);

        noOfHoursText = (EditText) findViewById(R.id.noOfHours);

        laborCostText = (EditText) findViewById(R.id.laborCost);

        asphaltCostText = (EditText) findViewById(R.id.asphaltCost);

        concreteCostText = (EditText) findViewById(R.id.concreteCost);

      /*---------------------------------------
        Define "estimate-cost" button click event
      ---------------------------------------*/
        estimatedCost = (Button) findViewById(R.id.estimatedCost);

        estimatedCost.setOnClickListener(new View.OnClickListener() {
            /*----------------------------------------------------------------
             Implement OnClick to calculate Labor , Asphalt and Concrete Cost
            ----------------------------------------------------------------*/
            @Override
            public void onClick(View view) {
                try {
                    float drivewaySize;
                    float sideWalkSize;
                    float noOfHours;
                    double laborCost;
                    double asphaltCost;
                    double concreteCost;

                    drivewaySize = Float.parseFloat(drivewaySizeText.getText().toString());

                    sideWalkSize = Float.parseFloat(sideWalkSizeText.getText().toString());

                    noOfHours = Float.parseFloat(noOfHoursText.getText().toString());

                    laborCost = 50 * noOfHours;

                    asphaltCost = 25 * (drivewaySize + sideWalkSize);

                    concreteCost = 75 * (drivewaySize + sideWalkSize);

                    laborCostText.setText("$" + Double.toString(laborCost));

                    asphaltCostText.setText("$" + Double.toString(asphaltCost));

                    concreteCostText.setText("$" + Double.toString(concreteCost));
                } catch (NumberFormatException ne) {

                    System.out.println("Number Format Exception::" + ne.getMessage());
                } catch (Exception e) {
                    System.out.println("Exception::" + e.getMessage());
                }
            }


        });


    }


}
