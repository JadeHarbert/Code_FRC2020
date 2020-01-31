/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class ArcadeDriveSubsystem extends SubsystemBase {
  /**
   * Creates a new ArcadeDriveSubsystem.
   */

   //public VictorSP frontLeft = new VictorSP(Constants.frontLeft);
   //public VictorSP backLeft = new VictorSP(Constants.backLeft);
   //public VictorSP frontRight = new VictorSP(Constants.frontRight);
   //public VictorSP backRight = new VictorSP(Constants.backRight);

   public CANSparkMax frontLeft = new CANSparkMax(Constants.frontLeft, MotorType.kBrushless);
   public CANSparkMax frontRight = new CANSparkMax(Constants.frontRight, MotorType.kBrushless);
   public CANSparkMax backLeft = new CANSparkMax(Constants.backLeft, MotorType.kBrushless);
   public CANSparkMax backRight = new CANSparkMax(Constants.backRight, MotorType.kBrushless);
   public CANSparkMax midLeft = new CANSparkMax(Constants.midLeft, MotorType.kBrushless);
   public CANSparkMax midRight = new CANSparkMax(Constants.midRight, MotorType.kBrushless);
   


   public SpeedControllerGroup leftMotors = new SpeedControllerGroup(frontLeft, backLeft, midLeft);
   public SpeedControllerGroup rightMotors = new SpeedControllerGroup(frontRight, backRight, midRight);

      
   public DifferentialDrive robotDrive = new DifferentialDrive(leftMotors, rightMotors); 
   
   

  public ArcadeDriveSubsystem() {



  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    //Not sure if this is needed 
    setDefaultCommand(RobotContainer.manualDriveCartesian);
  }
}
