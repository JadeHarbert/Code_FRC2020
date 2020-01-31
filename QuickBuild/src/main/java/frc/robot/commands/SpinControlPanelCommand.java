/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ColorSensorSubsystem;

public class SpinControlPanelCommand extends CommandBase {
  /**
   * Creates a new ColorSensorCommand.
   */

  private ColorSensorSubsystem colorSensorSubsystem;
  private int rotationCount = 0;
  private Color detectedColor;

  public SpinControlPanelCommand(ColorSensorSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    colorSensorSubsystem = subsystem;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(colorSensorSubsystem.match.color == Constants.yellowTarget){
      detectedColor = Constants.yellowTarget;
    } else if (colorSensorSubsystem.match.color == Constants.blueTarget){
      detectedColor = Constants.blueTarget;
    } else if (colorSensorSubsystem.match.color == Constants.greenTarget){
      detectedColor = Constants.greenTarget;
    } else if (colorSensorSubsystem.match.color == Constants.redTarget){
      detectedColor = Constants.redTarget;
    }

     //Turn motor on

    for(int i = 0; rotationCount < 3; i++){
      if(colorSensorSubsystem.match.color == detectedColor){
        if(i%2 == 0){
        i = 0;
        rotationCount++;
        } 
        i++;
      }
    }

    //turn motor off

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
