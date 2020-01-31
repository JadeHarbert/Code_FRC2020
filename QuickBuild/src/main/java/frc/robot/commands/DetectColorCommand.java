/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ColorSensorSubsystem;

public class DetectColorCommand extends CommandBase {
  /**
   * Creates a new DetectColorCommand.
   */
  private ColorSensorSubsystem colorSensorSubsystem;
  public DetectColorCommand(ColorSensorSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    colorSensorSubsystem = subsystem;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    colorSensorSubsystem.colorMatcher.setConfidenceThreshold(.10);
    
    colorSensorSubsystem.colorMatcher.addColorMatch(Constants.blueTarget);
    colorSensorSubsystem.colorMatcher.addColorMatch(Constants.greenTarget);
    colorSensorSubsystem.colorMatcher.addColorMatch(Constants.redTarget);
    colorSensorSubsystem.colorMatcher.addColorMatch(Constants.yellowTarget);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    ColorMatch colorMatcher = new ColorMatch();
    Color detectedColor = colorSensorSubsystem.colorSensor.getColor();
    ColorMatchResult match = colorMatcher.matchClosestColor(detectedColor);

    String detectedColors = " ";
    if(match.color == Constants.greenTarget){
      detectedColors = "green";
    } else if (match.color == Constants.redTarget){
      detectedColors = "red";
    } else if (match.color == Constants.yellowTarget){
      detectedColors = "Yellow";
    } else if (match.color == Constants.blueTarget){
      detectedColors = "Blue";
    } 

    SmartDashboard.putString("Detected Color:", detectedColors);

    
    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
