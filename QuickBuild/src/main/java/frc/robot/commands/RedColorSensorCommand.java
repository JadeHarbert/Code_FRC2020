/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ColorSensorSubsystem;

public class RedColorSensorCommand extends CommandBase {
  /**
   * Creates a new RedColorSensorCommand.
   */
  private ColorSensorSubsystem colorSensorSubsystem;

  public RedColorSensorCommand(ColorSensorSubsystem subsystem) {
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
    while(colorSensorSubsystem.match.color != Constants.redTarget) {
      //Add logic for running motor and stopping on the color
        if(colorSensorSubsystem.match.color == Constants.redTarget){
          //Stop motor
        } else {
          //Set speed of motor
        }
  
      }
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
