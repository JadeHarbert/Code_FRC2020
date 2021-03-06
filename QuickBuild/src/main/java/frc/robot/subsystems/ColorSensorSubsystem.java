/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;


public class ColorSensorSubsystem extends SubsystemBase {
  /**
   * Creates a new ColorSensorSubsystem.
   */

   public ColorSensorV3 colorSensor = new ColorSensorV3(Constants.colorSensorPort);

   public ColorMatch colorMatcher = new ColorMatch();
   public Color detectedColor = colorSensor.getColor();

   

   
   /**
    * Run the color match algorithm on our detected color
    */
   public ColorMatchResult match = colorMatcher.matchClosestColor(detectedColor);



  public ColorSensorSubsystem() {

    //Adds the colors to match against to the instance colorMatcher
    colorMatcher.addColorMatch(Constants.blueTarget);
    colorMatcher.addColorMatch(Constants.greenTarget);
    colorMatcher.addColorMatch(Constants.redTarget);
    colorMatcher.addColorMatch(Constants.yellowTarget);

    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
